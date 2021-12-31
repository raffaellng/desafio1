package com.example.desafio1;

import com.example.desafio1.domain.entity.*;
import com.example.desafio1.domain.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.UUID;

@RestController
@SpringBootApplication
public class Desafio1Application {

    @Bean
    public CommandLineRunner massaTeste(@Autowired ClientesRepository clientesRepository,
                                        @Autowired BancoRepository bancoRepository,
                                        @Autowired ChavesRepository chavesRepository,
                                        @Autowired UsuarioChaveRepository usuarioChaveRepository,
                                        @Autowired TransacoesRepository transacoesRepository) {
        return args -> {
            //CLIENTE
            Cliente cliente = new Cliente();
            cliente.setNome("Raffaell Negreiros");
            cliente.setCpf("12222222200");
            cliente.setDataNascimento("18-10-1993 00:00:00");
            cliente.setEmail("raffaell@gmail.com");
            clientesRepository.save(cliente);

            Cliente cliente2 = new Cliente();
            cliente2.setNome("Gustavo Negreiros");
            cliente2.setCpf("12222222201");
            cliente2.setDataNascimento("04-01-1995 00:00:00");
            cliente2.setEmail("gustavo@gmail.com");
            clientesRepository.save(cliente2);

            //BANCO
            Banco banco = new Banco();
            banco.setCliente(cliente);
            banco.setInstituicao("banco 1");
            banco.setAgencia(2442);
            banco.setConta(123456789);
            banco.setTipoConta("Corrente");
            banco.setSaldo(BigDecimal.valueOf(1000.00));
            banco.setStatus(true);
            banco.setUsuario("Raffaell1810");
            banco.setSenha("123456789");
            bancoRepository.save(banco);

            Banco banco1 = new Banco();
            banco1.setCliente(cliente2);
            banco1.setInstituicao("banco 2");
            banco1.setAgencia(2444);
            banco1.setConta(123456789);
            banco1.setTipoConta("Corrente");
            banco1.setSaldo(BigDecimal.valueOf(800.00));
            banco1.setStatus(true);
            banco1.setUsuario("gugu0401");
            banco1.setSenha("123456789");
            bancoRepository.save(banco1);

            //CHAVES
            Chaves chaves1 = new Chaves();
            chaves1.setTipoChave("CPF");
            chaves1.setDescricao("O tipo de chave nesta informação e um cpf valido");
            chaves1.setStatus(true);
            chavesRepository.save(chaves1);

            Chaves chaves2 = new Chaves();
            chaves2.setTipoChave("CNJP");
            chaves2.setDescricao("O tipo de chave nesta informação e um CNPJ valido");
            chaves2.setStatus(true);
            chavesRepository.save(chaves2);

            Chaves chaves3 = new Chaves();
            chaves3.setTipoChave("Email");
            chaves3.setDescricao("O tipo de chave nesta informação e email valido");
            chaves3.setStatus(true);
            chavesRepository.save(chaves3);

            Chaves chaves4 = new Chaves();
            chaves4.setTipoChave("Telefone");
            chaves4.setDescricao("O tipo de chave nesta informação e um Telefone valido");
            chaves4.setStatus(true);
            chavesRepository.save(chaves4);

            Chaves chaves5 = new Chaves();
            chaves5.setTipoChave("Aleatoria");
            chaves5.setDescricao("O tipo de chave, o sistema cria uma chave aleatoria com numeros e caracters");
            chaves5.setStatus(true);
            chavesRepository.save(chaves5);

            //USUARIO CHAVES
            UsuarioChave usuarioChave = new UsuarioChave();
            usuarioChave.setIdCliente(cliente);
            usuarioChave.setIdBanco(banco);
            usuarioChave.setIdChave(chaves4);
            usuarioChave.setChave("34996399990");
            usuarioChave.setStatus(true);
            usuarioChaveRepository.save(usuarioChave);

            UsuarioChave usuarioChave1 = new UsuarioChave();
            usuarioChave1.setIdCliente(cliente2);
            usuarioChave1.setIdBanco(banco1);
            usuarioChave1.setIdChave(chaves1);
            usuarioChave1.setChave("12222222201");
            usuarioChave1.setStatus(true);
            usuarioChaveRepository.save(usuarioChave1);

            //TRANSACAO
            Transacoes transacoes = new Transacoes();
            UUID temp = UUID.randomUUID();
            transacoes.setChaveTransacao(temp);
            transacoes.setValor(BigDecimal.valueOf(200.00));
            transacoes.setUsuarioDestino(usuarioChave);
            transacoes.setUsuarioOrigem(usuarioChave1);
            transacoesRepository.save(transacoes);

        };
    }

    public static void main(String[] args) {

        SpringApplication.run(Desafio1Application.class, args);
    }

}
