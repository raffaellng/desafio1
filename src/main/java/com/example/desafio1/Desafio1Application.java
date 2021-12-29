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
            //CLIENTE
            Cliente cliente = new Cliente();
            cliente.setNome("Raffaell Negreiros");
            cliente.setCpf("122.256.166-20");
            cliente.setDataNascimento("18-10-1993 00:00:00");
            cliente.setEmail("Raffaell@gmail.com");
            clientesRepository.save(cliente);

            //ENDERECO
        };
    }

    public static void main(String[] args) {

        SpringApplication.run(Desafio1Application.class, args);
    }

}
