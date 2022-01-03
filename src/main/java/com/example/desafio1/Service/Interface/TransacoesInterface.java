package com.example.desafio1.Service.Interface;

import com.example.desafio1.dto.TransacoesDTO;

import java.util.List;

public interface TransacoesInterface {
    List<List<TransacoesDTO>> transacoesByClient(int id);
}
