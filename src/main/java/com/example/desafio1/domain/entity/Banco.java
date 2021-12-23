package com.example.desafio1.domain.entity;

import java.math.BigDecimal;

public class Banco {
    private int Id;
    private Cliente cliente;
    private String tipoBanco;
    private String Agencia;
    private String Conta;
    private BigDecimal Saldo;
    private boolean Status;
    private String Usuario;
    private String Senha;
    private String DataCriacao;
    private String DataAlteracao;

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

    public String getTipoBanco() {
        return tipoBanco;
    }

    public void setTipoBanco(String tipoBanco) {
        this.tipoBanco = tipoBanco;
    }

    public String getAgencia() {
        return Agencia;
    }

    public void setAgencia(String agencia) {
        Agencia = agencia;
    }

    public String getConta() {
        return Conta;
    }

    public void setConta(String conta) {
        Conta = conta;
    }

    public BigDecimal getSaldo() {
        return Saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        Saldo = saldo;
    }

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean status) {
        Status = status;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String usuario) {
        Usuario = usuario;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String senha) {
        Senha = senha;
    }

    public String getDataCriacao() {
        return DataCriacao;
    }

    public void setDataCriacao(String dataCriacao) {
        DataCriacao = dataCriacao;
    }

    public String getDataAlteracao() {
        return DataAlteracao;
    }

    public void setDataAlteracao(String dataAlteracao) {
        DataAlteracao = dataAlteracao;
    }
}
