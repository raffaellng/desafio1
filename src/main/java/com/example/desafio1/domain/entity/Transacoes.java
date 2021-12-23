package com.example.desafio1.domain.entity;

import java.math.BigDecimal;

public class Transacoes {
    private int Id;
    private Cliente cliente;
    private String chaveTransacao;
    private BigDecimal Valor;
    private String dataTransacao;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getChaveTransacao() {
        return chaveTransacao;
    }

    public void setChaveTransacao(String chaveTransacao) {
        this.chaveTransacao = chaveTransacao;
    }

    public BigDecimal getValor() {
        return Valor;
    }

    public void setValor(BigDecimal valor) {
        Valor = valor;
    }

    public String getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(String dataTransacao) {
        this.dataTransacao = dataTransacao;
    }
}
