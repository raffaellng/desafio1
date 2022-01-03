package com.example.desafio1.Service;

import com.example.desafio1.Service.Interface.TransacoesInterface;
import com.example.desafio1.domain.entity.Transacoes;
import com.example.desafio1.exception.RegraNegocioExceptions;
import com.example.desafio1.repository.TransacoesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TransacoesService implements TransacoesInterface {

    private final TransacoesRepository transacoesRepository;

    @Override
    public List<Transacoes> transacoesByClient(int id) {
        List<Transacoes> transacoes = transacoesRepository.findByUsuarioOrigem_Id(id);

        if (transacoes.isEmpty())
            throw new RegraNegocioExceptions("Usuario origem nao existe");

        return transacoes;
    }
}
