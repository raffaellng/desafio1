package com.example.desafio1.domain.repository;

import com.example.desafio1.domain.entity.UsuarioChave;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioChaveRepository extends JpaRepository<UsuarioChave, Integer> {
}
