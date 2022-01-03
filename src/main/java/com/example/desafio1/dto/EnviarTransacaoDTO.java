package com.example.desafio1.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EnviarTransacaoDTO {
    private BigDecimal valor;
    private String chaveOrigem;
    private String chaveDestino;
    private String tipoChave;
    private String observacao;
}
