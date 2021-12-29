package com.example.desafio1.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Banco")
public class Banco implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @ManyToOne
    @JoinColumn(name = "IdCliente")
    private Cliente cliente;

    private String tipoConta;
    private String agencia;
    private String conta;
    private BigDecimal saldo;
    private String tipoChave;
    private String usuario;
    private String senha;
    private boolean status;
    private String dataCriacao;
    private String dataAlteracao;

}
