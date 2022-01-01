package com.example.desafio1.controller;

import com.example.desafio1.domain.entity.Cliente;
import com.example.desafio1.domain.repository.ClientesRepository;
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

    @GetMapping
    @RequestMapping(value = "/{id}")
    public Cliente getClienteById(@PathVariable Integer id) {
        Optional<Cliente> cliente = clientesRepository.findByIdAndStatusTrue(id);
        return clientesRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente saveCliente(@RequestBody Cliente cliente) {
        return clientesRepository.save(cliente);
    }

    @PutMapping("/{id}")
    public void updateCliente(@PathVariable int id,
                                 @RequestBody Cliente cliente) {
        clientesRepository.findById(id)
                .map(clienteExiste -> {
                    cliente.setId(clienteExiste.getId());
                    clientesRepository.save(cliente);
                    return ResponseEntity.noContent().build();
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletCliente(@PathVariable int id) {

        clientesRepository.findById(id)
                .map(delet -> {
                    delet.setStatus(false);
                    clientesRepository.save(delet);
                    return ResponseEntity.noContent().build();
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
    }

    @GetMapping("/getfilters")
    public List<Cliente> find(Cliente filtro) {
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(
                        ExampleMatcher.StringMatcher.CONTAINING);

        Example example = Example.of(filtro, ExampleMatcher.matchingAll().withIgnoreCase().withIncludeNullValues());
        List<Cliente> lista = clientesRepository.findAll(example);
        return lista;
    }
}
