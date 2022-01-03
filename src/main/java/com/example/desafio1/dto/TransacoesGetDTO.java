package com.example.desafio1.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransacoesGetDTO {
    private int id;
    private UUID chaveTransacao;
    private BigDecimal valor;
    private String chaveTransação;
    private String observacao;
    private LocalDateTime dataTransacao;
    private UsuarioChaveDTO usuarioOrigem;
    private UsuarioChaveDTO usuarioDestino;
}


