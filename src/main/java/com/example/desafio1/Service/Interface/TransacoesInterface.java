package com.example.desafio1.Service.Interface;

import com.example.desafio1.domain.entity.Transacoes;

import java.util.List;
import java.util.Optional;

public interface TransacoesInterface {
    List<Transacoes> transacoesByClient(int id);
}
