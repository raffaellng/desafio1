package com.example.desafio1.repository;

import com.example.desafio1.domain.entity.Chaves;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChavesRepository extends JpaRepository<Chaves, Integer> {
}
