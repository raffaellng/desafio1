package com.example.desafio1.repository;

import com.example.desafio1.domain.entity.Transacoes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TransacoesRepository extends JpaRepository<Transacoes, Integer> {

    Optional<Transacoes> findById(Integer integer);

    List<Transacoes> findByUsuarioOrigem_Id(int usuarioOrigemId);
}
