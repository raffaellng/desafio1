package com.example.desafio1.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioChaveDTO {
    private ClienteDTO cliente;
    private BancoDTO banco;
    private String chave;
    private boolean statusEnvio;
    private LocalDateTime dataEnvio;
}
