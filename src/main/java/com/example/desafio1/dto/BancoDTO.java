package com.example.desafio1.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BancoDTO {

    private String instituicao;
    private String tipoConta;
    private int agencia;
    private int conta;
    private BigDecimal saldo;
    private String usuario;
    private String senha;
    private boolean status;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAlteracao;
}
