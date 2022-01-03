package com.example.desafio1.Service.Interface;

import com.example.desafio1.domain.entity.Banco;
import org.springframework.http.ResponseEntity;

public interface BancoInterface {

    Banco getBancoById(int id);

    Banco saveBanco(Banco banco);

    ResponseEntity<Object> updateBanco(int id, Banco banco);

    ResponseEntity<Object> deletBanco(int id);

}
