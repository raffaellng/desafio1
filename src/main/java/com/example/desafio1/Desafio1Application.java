package com.example.desafio1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Desafio1Application {

	@GetMapping("/hello")
	public String helloWord(){
		return "hello world";
	}
	public static void main(String[] args) {
		SpringApplication.run(Desafio1Application.class, args);
	}

}
