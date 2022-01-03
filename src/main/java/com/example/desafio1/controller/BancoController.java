package com.example.desafio1.controller;

import com.example.desafio1.Service.Interface.BancoInterface;
import com.example.desafio1.domain.entity.Banco;
import com.example.desafio1.repository.BancoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/banco")
public class BancoController {

    private final BancoRepository bancoRepository;
    private final BancoInterface bancoInterface;

    @GetMapping
    @RequestMapping(value = "/{id}")
    public Banco getBancoById(@PathVariable int id) {
        return bancoInterface.getBancoById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Banco saveBanco(@RequestBody Banco banco) {

        return bancoInterface.saveBanco(banco);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateBanco(@PathVariable int id,
                                              @RequestBody Banco banco) {
        return bancoInterface.updateBanco(id, banco);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> deletBanco(@PathVariable int id) {
        return bancoInterface.deletBanco(id);
    }


}
