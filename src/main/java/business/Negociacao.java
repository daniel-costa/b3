package main.java.business;

import java.time.LocalDate;

public class Negociacao {
    private LocalDate dataDoNegocio;
    private TipoDeMovimentacao tipoDeMovimentacao;
    private String tipoDeMercado;
    private LocalDate dataDeVencimento;
    private String corretora;
    private String codigoDeNegociacao;
    private int quantidadeNegociada;
    private double precoNegociado;
    private double valorTotalNegociado;

    public Negociacao() {
    }

    public Negociacao(String codigo) {
    }

    public Negociacao(TipoDeMovimentacao tipoDeMovimentacao, String codigoDeNogociacao) {
        this.tipoDeMovimentacao = tipoDeMovimentacao;
        this.codigoDeNegociacao = codigoDeNogociacao;
    }

    public Negociacao(TipoDeMovimentacao tipoDeMovimentacao, String codigoDeNogociacao, int quantidadeNegociada,
            double precoNegociado, double valorTotalNegociado) {
        this.tipoDeMovimentacao = tipoDeMovimentacao;
        this.codigoDeNegociacao = codigoDeNogociacao;
        this.quantidadeNegociada = quantidadeNegociada;
        this.precoNegociado = precoNegociado;
        this.valorTotalNegociado = valorTotalNegociado;
    }

    public Negociacao(LocalDate dataDoNegocio, TipoDeMovimentacao tipoDeMovimentacao, String tipoDeMercado,
            LocalDate dataDeVencimento, String corretora, String codigoDeNegociacao, int quantidadeNegociada,
            double precoNegociado, double valorTotalNegociado) {
        this.dataDoNegocio = dataDoNegocio;
        this.tipoDeMovimentacao = tipoDeMovimentacao;
        this.tipoDeMercado = tipoDeMercado;
        this.dataDeVencimento = dataDeVencimento;
        this.corretora = corretora;
        this.codigoDeNegociacao = codigoDeNegociacao;
        this.quantidadeNegociada = quantidadeNegociada;
        this.precoNegociado = precoNegociado;
        this.valorTotalNegociado = valorTotalNegociado;
    }

    public LocalDate getDataDoNegocio() {
        return dataDoNegocio;
    }

    public void setDataDoNegocio(LocalDate dataDoNegocio) {
        this.dataDoNegocio = dataDoNegocio;
    }

    public TipoDeMovimentacao getTipoDeMovimentacao() {
        return tipoDeMovimentacao;
    }

    public void setTipoDeMovimentacao(TipoDeMovimentacao tipoDeMovimentacao) {
        this.tipoDeMovimentacao = tipoDeMovimentacao;
    }

    public String getTipoDeMercado() {
        return tipoDeMercado;
    }

    public void setTipoDeMercado(String tipoDeMercado) {
        this.tipoDeMercado = tipoDeMercado;
    }

    public LocalDate getDataDeVencimento() {
        return dataDeVencimento;
    }

    public void setDataDeVencimento(LocalDate dataDeVencimento) {
        this.dataDeVencimento = dataDeVencimento;
    }

    public String getCorretora() {
        return corretora;
    }

    public void setCorretora(String corretora) {
        this.corretora = corretora;
    }

    public String getCodigoDeNegociacao() {
        return codigoDeNegociacao;
    }

    public void setCodigoDeNegociacao(String codigoDeNogociacao) {
        this.codigoDeNegociacao = codigoDeNogociacao;
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
