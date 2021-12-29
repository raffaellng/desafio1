package com.example.desafio1;

import com.example.desafio1.domain.entity.Cliente;
import com.example.desafio1.domain.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Desafio1Application {

    @Bean
    public CommandLineRunner init(@Autowired ClientesRepository clientesRepository) {
        return args -> {
            Cliente cliente = new Cliente();
            cliente.setNome("Raffaell Negreiros");
            clientesRepository.save(cliente);
            Cliente client2e = new Cliente();
            client2e.setNome("Gugu Negreiros");
            clientesRepository.save(client2e);
        };
    }

    public static void main(String[] args) {

        SpringApplication.run(Desafio1Application.class, args);
    }

}
