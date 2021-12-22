package com.example.desafio1.services;

import com.example.desafio1.model.Cliente;
import com.example.desafio1.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServices {

    private ClientRepository _clientRepository;

    @Autowired
    public ClientServices( ClientRepository clientRepository){
        _clientRepository = clientRepository;
    }

    public void salvarCliente(Cliente cliente){
        validarCliente(cliente);
        //ClientRepository clientRepository = new ClientRepository();
        _clientRepository.save(cliente);
    }

    private void validarCliente(Cliente cliente){

    }
}
