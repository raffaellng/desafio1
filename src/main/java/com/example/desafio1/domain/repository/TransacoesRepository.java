package com.example.desafio1.domain.repository;

import com.example.desafio1.domain.entity.Cliente;
import com.example.desafio1.domain.entity.Transacoes;
import com.example.desafio1.domain.entity.UsuarioChave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TransacoesRepository extends JpaRepository<Transacoes, Integer> {

    List<Transacoes> findByUsuarioOrigem_Id(int usuarioOrigemId);
}
