package com.github.daniel.resumob3.application;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;

public class ExploradorDeArquivosSwing extends Component {
    public File selecionarArquivo(String titulo, String descricao, String extensao) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle(titulo);
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        FileNameExtensionFilter filter = new FileNameExtensionFilter(descricao, extensao);
        fileChooser.setFileFilter(filter);

        int retorno = fileChooser.showOpenDialog(this);

        File file;
        if (retorno == JFileChooser.APPROVE_OPTION) {
            file = fileChooser.getSelectedFile();
        }
        else {
            return null;
        }

        return file;
    }
}
