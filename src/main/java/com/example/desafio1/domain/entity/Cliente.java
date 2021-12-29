package com.example.desafio1.domain.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

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
    private String dataCriacao;
    private String dataAlteracao;

}
