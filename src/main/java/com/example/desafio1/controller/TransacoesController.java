package com.example.desafio1.controller;

import com.example.desafio1.Service.Interface.TransacoesInterface;
import com.example.desafio1.domain.entity.Banco;
import com.example.desafio1.domain.entity.Cliente;
import com.example.desafio1.domain.entity.Transacoes;
import com.example.desafio1.domain.entity.UsuarioChave;
import com.example.desafio1.dto.BancoDTO;
import com.example.desafio1.dto.ClienteDTO;
import com.example.desafio1.dto.TransacoesDTO;
import com.example.desafio1.dto.UsuarioChaveDTO;
import com.example.desafio1.repository.TransacoesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/transacoes")
public class TransacoesController {

    private final TransacoesRepository transacoesRepository;
    private final TransacoesInterface transacoesInterface;

    @GetMapping
    @RequestMapping(value = "/{id}")
    public Transacoes transacoes(@PathVariable Integer id) {
        Optional<Transacoes> transacao = transacoesRepository.findById(id);
        return transacoesRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Transacao não encontrada"));
    }

    @GetMapping
    @RequestMapping(value = "/cliente/{id}")
    public List<List<TransacoesDTO>> transacoesByClient(@PathVariable int id) {
        return transacoesInterface.transacoesByClient(id).stream()
                .map(t -> converterTransacao(Collections.singletonList(t)))
                .collect(Collectors.toList());
    }

    private List<TransacoesDTO> converterTransacao(List<Transacoes> transacoes) {
        return transacoes.stream().map(t ->  TransacoesDTO
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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Transacoes saveTransacao(@RequestBody Transacoes transacao) {
        return transacoesRepository.save(transacao);
    }

}
