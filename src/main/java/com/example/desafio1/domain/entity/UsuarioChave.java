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
public class UsuarioChave {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "IdCliente")
    private Cliente idCliente;

    @ManyToOne
    @JoinColumn(name = "IdBanco")
    private Banco idBanco;

    @ManyToOne
    @JoinColumn(name = "IdChaves")
    private Chaves idChave;

    private boolean status;
    private LocalDateTime dataEnvio;

    @PrePersist
    public void prePersist() {
        dataEnvio = LocalDateTime.now();
    }
}
