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
@Table(name = "Endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "IdCliente")
    private Cliente cliente;

    private String rua;
    private int numero;
    private String complemento;
    private int cep;
    private String estado;
    private String pais;
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
