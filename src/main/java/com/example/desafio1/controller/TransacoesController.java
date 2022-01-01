package com.example.desafio1.controller;

import com.example.desafio1.domain.entity.Transacoes;
import com.example.desafio1.domain.entity.UsuarioChave;
import com.example.desafio1.domain.repository.TransacoesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/transacoes")
public class TransacoesController {

    private final TransacoesRepository transacoesRepository;

    @GetMapping
    @RequestMapping(value = "/{id}")
    public Transacoes transacoes(@PathVariable Integer id) {
        Optional<Transacoes> transacao = transacoesRepository.findById(id);
        return transacoesRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Transacao não encontrada"));
    }

    @GetMapping
    @RequestMapping(value = "/cliente/{id}")
    public List<Transacoes> transacoesByClient(@PathVariable int id) {
        List<Transacoes> transacao = transacoesRepository.findByUsuarioOrigem_Id(id);
        return transacao;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Transacoes saveTransacao(@RequestBody Transacoes transacao) {
        return transacoesRepository.save(transacao);
    }

}
