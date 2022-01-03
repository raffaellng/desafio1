package com.example.desafio1.controller;

import com.example.desafio1.Service.Interface.TransacoesInterface;
import com.example.desafio1.domain.entity.Transacoes;
import com.example.desafio1.dto.TransacoesDTO;
import com.example.desafio1.repository.TransacoesRepository;
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
        return transacoesInterface.transacoesByClient(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Transacoes saveTransacao(@RequestBody Transacoes transacao) {
        return transacoesRepository.save(transacao);
    }

}
