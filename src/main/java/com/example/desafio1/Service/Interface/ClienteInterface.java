package com.example.desafio1.Service.Interface;

import com.example.desafio1.domain.entity.Cliente;
import org.springframework.http.ResponseEntity;

public interface ClienteInterface {

    Cliente findByIdAndStatusTrue(int id);

    Cliente saveCliente(Cliente cliente);

    Cliente updateCliente(Cliente cliente, int id);

    ResponseEntity<Object> deletCliente(int id);
}
