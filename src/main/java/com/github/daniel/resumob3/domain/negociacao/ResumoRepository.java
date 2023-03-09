package com.github.daniel.resumob3.domain.negociacao;

import java.io.OutputStream;

public interface ResumoRepository {
    /**
     * Salva em disco um arquivo .csv com o resumo das negociações.
     * @param resumo É o resumo de todas as negocições por ativo.
     * @param output É o caminho que os dados devem seguir.
     */
    public void save (Resumo resumo, OutputStream output);

}
