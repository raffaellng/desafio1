package com.example.desafio1.repository;

import com.example.desafio1.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientesRepository extends JpaRepository<Cliente, Integer> {


    Optional<Cliente> findByIdAndStatusTrue(Integer integer);
}
