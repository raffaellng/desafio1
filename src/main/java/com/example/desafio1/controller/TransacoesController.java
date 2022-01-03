package com.example.desafio1.controller;

import com.example.desafio1.Service.Interface.TransacoesInterface;
import com.example.desafio1.domain.entity.Transacoes;
import com.example.desafio1.dto.EnviarTransacaoDTO;
import com.example.desafio1.dto.TransacoesGetDTO;
import com.example.desafio1.dto.TransacoesSaveDTO;
import com.example.desafio1.repository.TransacoesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    public Optional<List<TransacoesGetDTO>> transacoes(@PathVariable Integer id) {
        return transacoesInterface.transacoesById(id);
    }

    @GetMapping
    @RequestMapping(value = "/cliente/{id}")
    public List<List<TransacoesGetDTO>> transacoesByClient(@PathVariable int id) {
        return transacoesInterface.transacoesByClient(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TransacoesSaveDTO saveTransacao(@RequestBody EnviarTransacaoDTO enviarTransacao) {
        return transacoesInterface.saveTransacao(enviarTransacao);
    }

}
