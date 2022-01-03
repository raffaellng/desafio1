package com.example.desafio1.controller;

import com.example.desafio1.exception.ApiErrosExceptions;
import com.example.desafio1.exception.RegraNegocioExceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(RegraNegocioExceptions.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrosExceptions handleRegraException(RegraNegocioExceptions ex){
        String mensagemErro = ex.getMessage();
        return new ApiErrosExceptions(mensagemErro);
    }
}
