package com.example.desafio1.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

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
    private String dataCriacao;
    private String dataAlteracao;
}
