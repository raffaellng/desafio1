package com.example.desafio1.domain.repository;

import com.example.desafio1.domain.entity.Endereco;
import com.example.desafio1.domain.entity.Transacoes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacoesRepository extends JpaRepository<Transacoes, Integer> {
}
