package com.example.desafio1.controller;

import com.example.desafio1.domain.entity.Cliente;
import com.example.desafio1.domain.repository.ClientesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cliente")
public class ClienteController {

    private final ClientesRepository clientesRepository;

    @GetMapping
    @RequestMapping(value = "/get/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable Integer id) {

        Optional<Cliente> cliente = clientesRepository.findById(id);
        if (cliente.isPresent())
            return ResponseEntity.ok(cliente.get());

        return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/post")
    @ResponseBody
    public ResponseEntity saveCliente(@RequestBody Cliente cliente) {
        Cliente clienteSalvo = clientesRepository.save(cliente);
        return ResponseEntity.ok(clienteSalvo);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public ResponseEntity deletCliente(@PathVariable int id) {

        return clientesRepository.findById(id)
                .map(delet -> {
                    delet.setStatus(false);
                    clientesRepository.save(delet);
                    return ResponseEntity.noContent().build();
                }).orElseGet(() -> ResponseEntity.noContent().build());
    }


    @PutMapping("/put/{id}")
    @ResponseBody
    public ResponseEntity updateCliente(@PathVariable int id,
                                        @RequestBody Cliente cliente) {
        return clientesRepository.findById(id)
                .map(clienteExiste -> {
                    cliente.setId(clienteExiste.getId());
                    clientesRepository.save(cliente);
                    return ResponseEntity.noContent().build();
                }).orElseGet(() -> ResponseEntity.noContent().build());
    }
}
