package com.github.daniel.resumob3.domain.extrato;

import java.util.Date;

public class Movimentacao {
    private Date data;
    private String descricao;
    private double valor;

    public Movimentacao() {
    }

    public Movimentacao(Date data, String descricao, double valor) {
        this.data = data;
        this.descricao = descricao;
        this.valor = valor;
    }
    
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
