package com.example.desafio1.controller;

import com.example.desafio1.Service.Interface.ClienteInterface;
import com.example.desafio1.domain.entity.Cliente;
import com.example.desafio1.repository.ClientesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cliente")
public class ClienteController {

    private final ClientesRepository clientesRepository;
    private final ClienteInterface clienteInterface;

    @GetMapping
    @RequestMapping(value = "/{id}")
    public Cliente getClienteById(@PathVariable Integer id) {
        return clienteInterface.findByIdAndStatusTrue(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente saveCliente(@RequestBody Cliente cliente) {
        return clienteInterface.saveCliente(cliente);
    }

    @PutMapping("/{id}")
    public void updateCliente(@PathVariable int id, @RequestBody Cliente cliente) {
        clienteInterface.updateCliente(cliente, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletCliente(@PathVariable int id) {
        clienteInterface.deletCliente(id);
    }
}
