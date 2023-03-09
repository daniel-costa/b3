package com.github.daniel.resumob3.domain.extrato;

import java.util.Map;

public class RelatorioMensal {
    private int mes;
    private double valorDepositado;
    private double valorSacado;
    private double valorInvestido;
    private double rendimentos;

    public RelatorioMensal() {
    }
    public RelatorioMensal(int mes, double valorDepositado, double valorSacado, double valorInvestido, double rendimentos) {
        this.mes = mes;
        this.valorDepositado = valorDepositado;
        this.valorSacado = valorSacado;
        this.valorInvestido = valorInvestido;
        this.rendimentos = rendimentos;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public double getValorDepositado() {
        return valorDepositado;
    }

    public void setValorDepositado(double valorDepositado) {
        this.valorDepositado = valorDepositado;
    }

    public double getValorSacado() {
        return valorSacado;
    }

    public void setValorSacado(double valorSacado) {
        this.valorSacado = valorSacado;
    }

    public double getValorInvestido() {
        return valorInvestido;
    }

    public void setValorInvestido(double valorInvestido) {
        this.valorInvestido = valorInvestido;
    }

    public double getRendimentos() {
        return rendimentos;
    }

    public void setRendimentos(double rendimentos) {
        this.rendimentos = rendimentos;
    }
}
