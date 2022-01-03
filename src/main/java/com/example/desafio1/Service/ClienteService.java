package com.example.desafio1.Service;

import com.example.desafio1.Service.Interface.ClienteInterface;
import com.example.desafio1.domain.entity.Cliente;
import com.example.desafio1.exception.RegraNegocioExceptions;
import com.example.desafio1.repository.ClientesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ClienteService implements ClienteInterface {

    private final ClientesRepository clientesRepository;

    @Override
    public Cliente findByIdAndStatusTrue(int id) {
        Optional<Cliente> cliente = clientesRepository.findByIdAndStatusTrue(id);
        return clientesRepository.findById(id)
                .orElseThrow(() -> new RegraNegocioExceptions("Cliente não encontrado"));
    }

    public Cliente saveCliente(Cliente cliente) {
        try {
            return clientesRepository.save(cliente);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Cliente updateCliente(Cliente cliente, int id) {
        clientesRepository.findById(id)
                .map(clienteExiste -> {
                    cliente.setId(clienteExiste.getId());
                    clientesRepository.save(cliente);
                    return ResponseEntity.noContent().build();
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
        return cliente;
    }

    @Override
    public ResponseEntity<Object> deletCliente(int id) {
        return clientesRepository.findById(id)
                .map(delet -> {
                    delet.setStatus(false);
                    clientesRepository.save(delet);
                    return ResponseEntity.noContent().build();
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
    }
}
