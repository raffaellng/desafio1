package com.example.desafio1.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

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

    @PrePersist
    public void prePersist() {
        dataCriacao = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        dataAlteracao = LocalDateTime.now();
    }

}
