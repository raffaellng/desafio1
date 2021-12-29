package com.example.desafio1.domain.reposiroty;

import com.example.desafio1.domain.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public interface Clientes extends JpaRepository<Cliente, Integer> {

}
