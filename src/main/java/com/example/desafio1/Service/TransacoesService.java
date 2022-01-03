package com.example.desafio1.Service;

import com.example.desafio1.Service.Interface.TransacoesInterface;
import com.example.desafio1.domain.entity.Banco;
import com.example.desafio1.domain.entity.Cliente;
import com.example.desafio1.domain.entity.Transacoes;
import com.example.desafio1.domain.entity.UsuarioChave;
import com.example.desafio1.dto.BancoDTO;
import com.example.desafio1.dto.ClienteDTO;
import com.example.desafio1.dto.TransacoesDTO;
import com.example.desafio1.dto.UsuarioChaveDTO;
import com.example.desafio1.exception.RegraNegocioExceptions;
import com.example.desafio1.repository.TransacoesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TransacoesService implements TransacoesInterface {

    private final TransacoesRepository transacoesRepository;

    @Override
    public List<List<TransacoesDTO>> transacoesByClient(int id) {
        try {
            List<List<TransacoesDTO>> transacoes = transacoesRepository
                    .findByUsuarioOrigem_Id(id)
                    .stream()
                    .map(
                            t -> converterTransacao(Collections.singletonList(t))
                    )
                    .toList();

            if (transacoes.isEmpty())
                throw new RegraNegocioExceptions("Usuario origem nao existe");

            return transacoes;
        }
        catch (Exception ex){
            throw ex;
        }
    }

    private List<TransacoesDTO> converterTransacao(List<Transacoes> transacoes) {
        return transacoes.stream().map(t -> TransacoesDTO
                .builder()
                .id(t.getId())
                .chaveTransacao(t.getChaveTransacao())
                .valor(t.getValor())
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
                .statusEnvio(usuarioChave.isStatusEnvio())
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
