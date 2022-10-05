package persistence;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import business.NegociacaoMedia;
import business.NegociacaoRepository;
import business.TipoDeMovimentacao;

public class CSVNegociacaoRepository implements NegociacaoRepository {
    String pathNegociacoes = "C:\\Users\\danie\\Documents\\metricasInvestimentos\\com\\github\\daniel-costa\\metricasInvestimentos";

    @Override
    public NegociacaoMedia negociacaoMedia(String codigo) {

        return null;
    }

    @Override
    public NegociacaoMedia negociacaoMedia(String codigo, TipoDeMovimentacao tipoDeMovimentacao) {
        try {
            FileReader fr = new FileReader(pathNegociacoes);
            try (BufferedReader bf = new BufferedReader(fr)) {
                NegociacaoMedia negociacaoMedia = new NegociacaoMedia(tipoDeMovimentacao, codigo);

                String linha;
                String[] campos = new String[9];

                while ((linha = bf.readLine()) != null) {
                    campos = linha.split(",");
                    TipoDeMovimentacao tipo = TipoDeMovimentacao.valueOf(campos[1].toUpperCase());
                    if (tipoDeMovimentacao == tipo && campos[5].equals(codigo)) {

                        negociacaoMedia.setQuantidadeNegociada(
                                Integer.parseInt(campos[6]) + negociacaoMedia.getQuantidadeNegociada());
                        negociacaoMedia.setValorTotalNegociado(
                                Integer.parseInt(campos[8] + negociacaoMedia.getValorTotalNegociado()));
                    }
                }

                negociacaoMedia.setPrecoNegociado(
                        negociacaoMedia.getValorTotalNegociado() / negociacaoMedia.getQuantidadeNegociada());

                return negociacaoMedia;
            }
        } catch (IOException e) {
            System.out.println("Nenhum arquivo encontrado");

        }
        return null;
    }

    @Override
    public ArrayList<String> ativosNegociados() {
        try {
            FileReader fr = new FileReader(pathNegociacoes);
            try (BufferedReader bf = new BufferedReader(fr)) {
                ArrayList<String> listaDeAtivos = new ArrayList<>();

                String linha;
                String[] campos = new String[9];

                while ((linha = bf.readLine()) != null) {
                    campos = linha.split(",");
                    if (!listaDeAtivos.contains(campos[5])) {
                        listaDeAtivos.add(campos[5]);
                    }
                }

                return listaDeAtivos;
            }
        } catch (IOException e) {
            System.out.println("Nenhum arquivo encontrado");

        }
        return null;
    }

    @Override
    public double precoMedio(String codigo) {
        // TODO
        return 0.0;
    }

    @Override
    public double totalInvestido() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public double totalInvestidoEmCadaAtivo(String codigo) {
        // TODO Auto-generated method stub
        return 0;
    }

}
