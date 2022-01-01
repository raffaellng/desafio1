package com.example.desafio1.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

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

    private UUID chaveTransacao;
    private BigDecimal valor;
    private LocalDateTime dataTransacao;

    @ManyToOne
    @JoinColumn(name = "UsuarioChaveOrigem")
    private UsuarioChave usuarioOrigem;


    @ManyToOne
    @JoinColumn(name = "UsuarioChaveDestino")
    private UsuarioChave usuarioDestino;

    @PrePersist
    public void prePersist() {
        dataTransacao = LocalDateTime.now();
    }

}
