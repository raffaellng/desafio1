package com.example.desafio1.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Chaves")
public class Chaves {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String tipoChave;
    private String descricao;
    private LocalDateTime dataCriacao;
    private boolean status;

    @PrePersist
    public void prePersist() {
        dataCriacao = LocalDateTime.now();
    }
}
