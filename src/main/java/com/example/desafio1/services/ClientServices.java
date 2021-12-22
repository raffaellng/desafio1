package com.example.desafio1.services;

import com.example.desafio1.model.Cliente;
import com.example.desafio1.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.BeanDefinitionValidationException;
import org.springframework.stereotype.Service;

@Service
public class ClientServices {

    private ClientRepository _clientRepository; // Via construtor

    @Autowired
    public ClientServices( ClientRepository clientRepository){ // Via construtor
        _clientRepository = clientRepository;
    }

    public void salvarCliente(Cliente cliente){
        validarCliente(cliente);
        _clientRepository.save(cliente);
    }

    private void validarCliente(Cliente cliente){
        if (cliente == null)
            throw new BeanDefinitionValidationException("Client Null");

    }
}
