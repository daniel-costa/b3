package com.github.daniel.resumob3.domain;

import java.io.InputStream;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public interface NegociacaoRepository {
    /**
     *  método para ler um fluxo de bits e converter para umas lista de
     *  negociações.
     * @param input Caminho que os bytes chegam.
     * @return Retorna uma lista contendo todas as negociações presentes no
     *         fornecido ou {@code null} caso não tenha nenhuma negociação
     *         no arquivo.
     */
    List<Negociacao> load(InputStream input);
}
