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
public class TransacoesSaveDTO {

    private BigDecimal valor;
    private String observacao;
    private UsuarioChaveDTO usuarioOrigem;
    private UsuarioChaveDTO usuarioDestino;
}


