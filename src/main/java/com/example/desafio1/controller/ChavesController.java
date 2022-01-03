package com.example.desafio1.controller;

import com.example.desafio1.Service.Interface.ChavesInterace;
import com.example.desafio1.domain.entity.Chaves;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/chaves")
public class ChavesController {

    private ChavesInterace chavesInterace;

    @GetMapping
    public List<Chaves> findByChaves(){
        return chavesInterace.findByChaves();
    }

}
