package com.example.desafio1.Service;

import com.example.desafio1.Service.Interface.ChavesInterace;
import com.example.desafio1.domain.entity.Chaves;
import com.example.desafio1.repository.ChavesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ChaveService implements ChavesInterace {

    ChavesRepository chavesRepository;

    public List<Chaves> findByChaves() {
        return this.chavesRepository.findAll();
    }
}
