package com.example.desafio1.Service;

import com.example.desafio1.Service.Interface.TransacoesInterface;
import com.example.desafio1.domain.entity.Banco;
import com.example.desafio1.domain.entity.Cliente;
import com.example.desafio1.domain.entity.Transacoes;
import com.example.desafio1.domain.entity.UsuarioChave;
import com.example.desafio1.dto.*;
import com.example.desafio1.exception.RegraNegocioExceptions;
import com.example.desafio1.repository.BancoRepository;
import com.example.desafio1.repository.ClientesRepository;
import com.example.desafio1.repository.TransacoesRepository;
import com.example.desafio1.repository.UsuarioChaveRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TransacoesService implements TransacoesInterface {

    private final TransacoesRepository transacoesRepository;
    private final ClientesRepository clientesRepository;
    private final UsuarioChaveRepository usuarioChaveRepository;
    private final BancoRepository bancoRepository;


    @Override
    public Optional<List<TransacoesGetDTO>> transacoesById(int id) {
        Optional<Transacoes> transacao = transacoesRepository.findById(id);
        return transacao.map(t -> converterTransacao(Collections.singletonList(t)));
    }

    @Override
    @Transactional
    public TransacoesSaveDTO saveTransacao(EnviarTransacaoDTO enviarTransacao) {

        UsuarioChave existeChaveOrigem = usuarioChaveRepository.findByChave(enviarTransacao.getChaveOrigem());
        UsuarioChave existeChaveDestino = usuarioChaveRepository.findByChave(enviarTransacao.getChaveDestino());

        Banco userOrigem = bancoRepository.findById(existeChaveOrigem.getIdCliente().getId())
                .orElseThrow(() -> new RegraNegocioExceptions("Usuario origem não existe"));

        Banco userDestino = bancoRepository.findById(existeChaveDestino.getIdCliente().getId())
                .orElseThrow(() -> new RegraNegocioExceptions("Usuario destino não existe"));

        if (Objects.equals(existeChaveDestino.getIdChave().getTipoChave(), enviarTransacao.getTipoChave()))
            throw new RegraNegocioExceptions("A chave nao corresponde ao tipo selecionado");

        if (existeChaveOrigem == null || !existeChaveOrigem.isStatusChave())
            throw new RegraNegocioExceptions("Chave de origem desativada ou não existe");

        if (existeChaveDestino == null || !existeChaveDestino.isStatusChave())
            throw new RegraNegocioExceptions("Chave de destino desativada ou não existe");

        if (userOrigem.getSaldo().intValue() < enviarTransacao.getValor().intValue())
            throw new RegraNegocioExceptions("Sem saldo suficiente");

        userOrigem.setSaldo(userOrigem.getSaldo().min(enviarTransacao.getValor()));
        SalvarSaldo(userOrigem);

        userDestino.setSaldo(userDestino.getSaldo().add(enviarTransacao.getValor()));
        SalvarSaldo(userDestino);

        transacoesRepository.save(salvarTransacao(enviarTransacao, existeChaveDestino, existeChaveOrigem));

        return TransacoesSaveDTO.builder()
                .valor(enviarTransacao.getValor())
                .observacao(enviarTransacao.getObservacao())
                .usuarioDestino(converterUsuarioChave(existeChaveOrigem))
                .usuarioOrigem(converterUsuarioChave(existeChaveDestino))
                .build();
    }

    private void SalvarSaldo(Banco banco) {
        bancoRepository.save(banco);
    }

    private Transacoes salvarTransacao(EnviarTransacaoDTO enviarTransacao, UsuarioChave existeChaveDestino, UsuarioChave existeChaveOrigem) {
        return transacoesRepository.save(Transacoes.builder()
                .chaveTransacao(UUID.randomUUID())
                .valor(enviarTransacao.getValor())
                .observacao(enviarTransacao.getObservacao())
                .usuarioOrigem(existeChaveOrigem)
                .usuarioDestino(existeChaveDestino)
                .build());
    }

    @Override
    public List<List<TransacoesGetDTO>> transacoesByClient(int id) {
        try {
            List<List<TransacoesGetDTO>> transacoes = transacoesRepository
                    .findByUsuarioOrigem_Id(id)
                    .stream()
                    .map(
                            t -> converterTransacao(Collections.singletonList(t))
                    )
                    .toList();

            if (transacoes.isEmpty())
                throw new RegraNegocioExceptions("Usuario origem nao existe");

            return transacoes;
        } catch (Exception ex) {
            throw ex;
        }
    }

    private List<TransacoesGetDTO> converterTransacao(List<Transacoes> transacoes) {
        return transacoes.stream().map(t -> TransacoesGetDTO
                .builder()
                .id(t.getId())
                .chaveTransacao(t.getChaveTransacao())
                .valor(t.getValor())
                .observacao(t.getObservacao())
                .dataTransacao(t.getDataTransacao())
                .usuarioOrigem(converterUsuarioChave(t.getUsuarioOrigem()))
                .usuarioDestino(converterUsuarioChave(t.getUsuarioDestino()))
                .build()
        ).collect(Collectors.toList());
    }

    private UsuarioChaveDTO converterUsuarioChave(UsuarioChave usuarioChave) {
        return UsuarioChaveDTO
                .builder()
                .cliente(converterCliente(usuarioChave.getIdCliente()))
                .banco(converterBanco(usuarioChave.getIdBanco()))
                .chave(usuarioChave.getChave())
                .statusEnvio(usuarioChave.isStatusChave())
                .dataEnvio(usuarioChave.getDataEnvio())
                .build();
    }

    private BancoDTO converterBanco(Banco banco) {
        return BancoDTO.builder()
                .instituicao(banco.getInstituicao())
                .agencia(banco.getAgencia())
                .conta(banco.getConta())
                .build();
    }

    private ClienteDTO converterCliente(Cliente cliente) {
        return ClienteDTO
                .builder()
                .nome(cliente.getNome())
                .cpf(cliente.getCpf())
                .dataNascimento(cliente.getDataNascimento())
                .email(cliente.getEmail())
                .build();
    }


}
