package com.example.desafio1.Service;

import com.example.desafio1.Service.Interface.BancoInterface;
import com.example.desafio1.domain.entity.Banco;
import com.example.desafio1.repository.BancoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequiredArgsConstructor
public class BancoService implements BancoInterface {

    BancoRepository bancoRepository;

    public Banco getBancoById(int id) {
        return bancoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Banco não encontrado"));
    }

    @Override
    public Banco saveBanco(Banco banco) {
        return bancoRepository.save(banco);
    }

    @Override
    public ResponseEntity<Object> updateBanco(int id, Banco banco) {
        return bancoRepository.findById(id)
                .map(bancoExist -> {
                    banco.setId(bancoExist.getId());
                    bancoRepository.save(banco);
                    return ResponseEntity.noContent().build();
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Banco não encontrado"));
    }

    @Override
    public ResponseEntity<Object> deletBanco(int id) {
        return bancoRepository.findById(id)
                .map(delet -> {
                    delet.setStatus(false);
                    bancoRepository.save(delet);
                    return ResponseEntity.noContent().build();
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Banco não encontrado"));
    }


}
