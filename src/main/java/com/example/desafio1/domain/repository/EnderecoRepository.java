package com.example.desafio1.domain.repository;

import com.example.desafio1.domain.entity.Chaves;
import com.example.desafio1.domain.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
}
