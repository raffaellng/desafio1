package com.example.desafio1.dto;


import com.example.desafio1.domain.entity.Cliente;
import com.example.desafio1.domain.entity.UsuarioChave;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransacoesDTO {
    private int id;
    private String chaveTransacao;
    private BigDecimal valor;
    private LocalDateTime dataTransacao;
    private Cliente usuarioOrigem;
    private Cliente usuarioDestino;
    private UsuarioChaveDTO usuarioChave;
}


