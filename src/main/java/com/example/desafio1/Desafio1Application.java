package com.example.desafio1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Desafio1Application {

    @Autowired
    @Qualifier("applicationName")
    private String applicationName; //aqui está utilizando o Bean, que está os dados do arquivo config (get; set), e bem parecido com o interface do C#

    @Value("${application.printConfigurations}")// aqui ele acessa e tambem está lendo o local application.properties
    private String configurations; // aqui eu mando aonde o properties vai ser executado

    @GetMapping("/hello")
    public String helloWord() {
        return "Hello Word";
    }

    @GetMapping("/hello-configuration")
    public String printConfigurations() {
        return configurations;
    }

    @GetMapping("/hello-application-properties")
    public String printApplicationProperties() {
        return applicationName;
    }


    public static void main(String[] args) {
        SpringApplication.run(Desafio1Application.class, args);
    }

}
