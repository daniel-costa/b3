package com.github.daniel.resumob3.io;

import com.github.daniel.resumob3.domain.*;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.URI;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


public class CSVResumoRepositoryTest {
    public Path getPath(String fileName) {
        ClassLoader classLoader = this.getClass().getClassLoader();
        URL resource = classLoader.getResource(fileName);
        URI uri = null;

        try {
            uri = resource.toURI();
        } catch (Exception exp) {
            return null;
        }

        return resource == null ? null : Paths.get(uri);
    }

    @Test
    void testandoEscrita(){
        String pathTabela = getPath("negociacoes.xlsx").toString();
        String pathResumo = pathTabela.substring
                (0, pathTabela.length() - "negociacoes.xlsx".length()) + "resumoNegociacoes.csv";

        NegociacaoRepository negociacaoRepo = new XLSXNegociacaoRepository();

        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(pathResumo.toString());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        FileInputStream fileInputStream;

        {
            try {
                fileInputStream = new FileInputStream(getPath("negociacoes.xlsx").toFile());
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        List<Negociacao> todas = negociacaoRepo.load(fileInputStream);
        List<String> ativos = ComputoDosDados.getAtivos(todas);

            Resumo resumo = new Resumo();
            for (String ativo : ativos) {
                Negociacao resumoNegociacao = ComputoDosDados.resumoNegocicoes(todas, ativo);
                resumo.addResumoNegociacoes(resumoNegociacao);
            }

            ResumoRepository resumoRepo = new CSVResumoRepository();
            resumoRepo.save(resumo, fileOutputStream);

    }
}