package com.example.desafio1.domain.repository;

import com.example.desafio1.domain.entity.Banco;
import com.example.desafio1.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BancoRepository extends JpaRepository<Banco, Integer> {
}
