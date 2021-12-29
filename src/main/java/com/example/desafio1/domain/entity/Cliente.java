package com.example.desafio1.domain.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Cliente")
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "NomeCliente")
    private String nome;

    private String cpf;
    private String dataNascimento;
    private String email;
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
