package com.github.daniel.resumob3.application;

import com.github.daniel.resumob3.domain.*;
import com.github.daniel.resumob3.io.CSVResumoRepository;
import com.github.daniel.resumob3.io.XLSXNegociacaoRepository;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.file.Path;
import java.util.List;

public class EfetivaResumoNegociacoes extends Component {
    void efetivaOperacao(){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Selecione o arquivo com as transações");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivos execel", "xlsx");
        fileChooser.setFileFilter(filter);

        int retorno = fileChooser.showOpenDialog(this);

        File file;
        if (retorno == JFileChooser.APPROVE_OPTION) {
            file = fileChooser.getSelectedFile();
        }
        else {
            return;
        }
        String pathParent = file.getParent();
        String pathResumo = String.valueOf(Path.of( pathParent, "resumo.csv"));

        FileOutputStream fileOutputStream = null;

        try {
            fileOutputStream = new FileOutputStream(pathResumo);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }



        NegociacaoRepository negociacaoRepo = new XLSXNegociacaoRepository();

        FileInputStream fileInputStream;

        {
            try {
                fileInputStream = new FileInputStream(file);
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

        System.out.println("Resumo gerado com sucesso!");
        System.out.println("Arquivo salvo em: " + pathResumo);
    }
}
