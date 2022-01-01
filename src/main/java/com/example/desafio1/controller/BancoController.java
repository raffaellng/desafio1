package com.example.desafio1.controller;

import com.example.desafio1.domain.entity.Banco;
import com.example.desafio1.domain.repository.BancoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/banco")
public class BancoController {

    private final BancoRepository bancoRepository;

    @GetMapping
    @RequestMapping(value = "/{id}")
    public Banco getBancoById(@PathVariable Integer id) {
        Optional<Banco> banco = bancoRepository.findById(id);
        return bancoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Banco não encontrado"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Banco saveBanco(@RequestBody Banco banco) {
        return bancoRepository.save(banco);
    }

    @PutMapping("/{id}")
    public void updateBanco(@PathVariable int id,
                              @RequestBody Banco banco) {
        bancoRepository.findById(id)
                .map(bancoExist -> {
                    banco.setId(bancoExist.getId());
                    bancoRepository.save(banco);
                    return ResponseEntity.noContent().build();
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Banco não encontrado"));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletBanco(@PathVariable int id) {

        bancoRepository.findById(id)
                .map(delet -> {
                    delet.setStatus(false);
                    bancoRepository.save(delet);
                    return ResponseEntity.noContent().build();
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Banco não encontrado"));
    }


}
