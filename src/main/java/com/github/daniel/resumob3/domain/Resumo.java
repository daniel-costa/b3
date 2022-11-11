package com.github.daniel.resumob3.domain;

import java.util.ArrayList;
import java.util.List;

public class Resumo {
    private List<Negociacao> resumoNegociacoes = new ArrayList<>();

    public List<Negociacao> getResumoNegociacoes() {
        return resumoNegociacoes;
    }

    public void addResumoNegociacoes(Negociacao resumoNegociacoes) {
        this.resumoNegociacoes.add(resumoNegociacoes);
    }
}
