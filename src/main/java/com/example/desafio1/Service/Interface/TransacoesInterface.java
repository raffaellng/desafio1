package com.example.desafio1.Service.Interface;

import com.example.desafio1.domain.entity.Transacoes;
import com.example.desafio1.dto.EnviarTransacaoDTO;
import com.example.desafio1.dto.TransacoesGetDTO;
import com.example.desafio1.dto.TransacoesSaveDTO;

import java.util.List;
import java.util.Optional;

public interface TransacoesInterface {
    List<List<TransacoesGetDTO>> transacoesByClient(int id);

    TransacoesSaveDTO saveTransacao(EnviarTransacaoDTO enviarTransacao);

    Optional<List<TransacoesGetDTO>> transacoesById(int id);
}
