package com.example.desafio1.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Transacoes")
public class Transacoes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "IdCliente")
    private Cliente cliente;

    private String chaveTransacao;
    private BigDecimal valor;
    private String dataTransacao;
    private String dataCriacao;
    private String dataAlteracao;
}
