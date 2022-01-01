package com.example.desafio1.dto;

import com.example.desafio1.domain.entity.Chaves;
import com.example.desafio1.domain.entity.Cliente;

import java.time.LocalDateTime;

public class UsuarioChaveDTO {
    private int id;
    private String chave;
    private boolean statusEnvio;
    private LocalDateTime dataEnvio;
}
