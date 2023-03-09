package com.github.daniel.resumob3.domain.negociacao;

import java.util.Date;

public class Negociacao {
    private Date dataDoNegocio;
    private TipoDeMovimentacao tipoDeMovimentacao;
    private String corretora;
    private String ativo;
    private int quantidadeNegociada;
    private double precoNegociado;
    private double valorTotalNegociado;

    public Negociacao() {
    }

    public Negociacao(TipoDeMovimentacao tipoDeMovimentacao, String ativo, int quantidadeNegociada, double precoNegociado, double valorTotalNegociado) {
        this.tipoDeMovimentacao = tipoDeMovimentacao;
        this.ativo = ativo;
        this.quantidadeNegociada = quantidadeNegociada;
        this.precoNegociado = precoNegociado;
        this.valorTotalNegociado = valorTotalNegociado;
    }

    public Negociacao(Date dataDoNegocio, TipoDeMovimentacao tipoDeMovimentacao,
                      String corretora, String ativo, int quantidadeNegociada,
                      double precoNegociado, double valorTotalNegociado) {
        this.dataDoNegocio = dataDoNegocio;
        this.tipoDeMovimentacao = tipoDeMovimentacao;
        this.corretora = corretora;
        this.ativo = ativo;
        this.quantidadeNegociada = quantidadeNegociada;
        this.precoNegociado = precoNegociado;
        this.valorTotalNegociado = valorTotalNegociado;
    }

    public Date getDataDoNegocio() {
        return dataDoNegocio;
    }

    public void setDataDoNegocio(Date dataDoNegocio) {
        this.dataDoNegocio = dataDoNegocio;
    }

    public TipoDeMovimentacao getTipoDeMovimentacao() {
        return tipoDeMovimentacao;
    }

    public void setTipoDeMovimentacao(TipoDeMovimentacao tipoDeMovimentacao) {
        this.tipoDeMovimentacao = tipoDeMovimentacao;
    }

    public String getCorretora() {
        return corretora;
    }

    public void setCorretora(String corretora) {
        this.corretora = corretora;
    }

    public String getAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }

    public int getQuantidadeNegociada() {
        return quantidadeNegociada;
    }

    public void setQuantidadeNegociada(int quantidadeNegociada) {
        this.quantidadeNegociada = quantidadeNegociada;
    }

    public double getPrecoNegociado() {
        return precoNegociado;
    }

    public void setPrecoNegociado(double precoNegociado) {
        this.precoNegociado = precoNegociado;
    }

    public double getValorTotalNegociado() {
        return valorTotalNegociado;
    }

    public void setValorTotalNegociado(double valorTotalNegociado) {
        this.valorTotalNegociado = valorTotalNegociado;
    }
}
