package persistence;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import business.Negociacao;
import business.NegociacaoRepository;
import business.TipoDeMercado;
import business.TipoDeMovimentacao;

public class CSVNegociacaoRepository implements NegociacaoRepository {
    // FIXME System.getenv
    String pathNegociacoes = "C:\\Users\\danie\\Documents\\metricasInvestimentos\\com\\github\\daniel-costa\\src\\resources\\base\\negociacoes.csv";

    @Override
    public ArrayList<Negociacao> todas() {
        try {
            FileReader fr = new FileReader(pathNegociacoes);
            try (BufferedReader bf = new BufferedReader(fr)) {
                ArrayList<Negociacao> negociacoes = new ArrayList<>();

                String linha;
                String[] campos = new String[9];

                while ((linha = bf.readLine()) != null) {
                    campos = linha.split(",");
                    LocalDate dataDoNegocio = LocalDate.parse(campos[0]);
                    TipoDeMovimentacao tipoDeMovimentacao = TipoDeMovimentacao
                            .valueOf(campos[1].toUpperCase());
                    TipoDeMercado tipoDeMercado = TipoDeMercado
                            .valueOf(campos[2].toUpperCase());
                    LocalDate dataDeVencimento = LocalDate.parse(campos[3]);
                    String corretora = campos[4];
                    String codigoDeNegociacao = campos[5];
                    int quantidadeNegociada = Integer.parseInt(campos[6]);
                    double precoNegociado = Double.parseDouble(campos[7]);
                    double valorTotalNegociado = Double.parseDouble(campos[8]);

                    negociacoes.add(new Negociacao(dataDoNegocio, tipoDeMovimentacao,
                            tipoDeMercado, dataDeVencimento, corretora, codigoDeNegociacao,
                            quantidadeNegociada, precoNegociado, valorTotalNegociado));
                }
                return negociacoes;
            }
        } catch (IOException e) {
            System.out.println("Nenhum arquivo encontrado");

        }
        return null;
    }

    @Override
    public ArrayList<String> ativosNegociados() {
        NegociacaoRepository repoNegociacao = new CSVNegociacaoRepository();
        ArrayList<Negociacao> negociacoes = repoNegociacao.todas();

        ArrayList<String> ativosNegociados = new ArrayList<>();

        for (Negociacao negociacao : negociacoes) {
            if (!ativosNegociados.contains(negociacao.getCodigoDeNegociacao())) {
                ativosNegociados.add(negociacao.getCodigoDeNegociacao());
            }
        }

        return ativosNegociados;
    }

    @Override
    public ArrayList<Negociacao> porCodigo(String codigo) {
        NegociacaoRepository repoNegociacao = new CSVNegociacaoRepository();
        ArrayList<Negociacao> negociacoes = repoNegociacao.todas();

        ArrayList<Negociacao> negociacoesDeUmAtivo = new ArrayList<>();

        for (Negociacao negociacao : negociacoes) {
            if (negociacao.getCodigoDeNegociacao().equals(codigo)) {
                negociacoesDeUmAtivo.add(negociacao);
            }
        }

        return negociacoesDeUmAtivo;
    }

    @Override
    public ArrayList<Negociacao> porTipoDeMovimentacao(TipoDeMovimentacao tipoDeMovimentacao) {
        NegociacaoRepository repoNegociacao = new CSVNegociacaoRepository();
        ArrayList<Negociacao> negociacoes = repoNegociacao.todas();

        ArrayList<Negociacao> negociacoesDeUmTipoDeMovimentacao = new ArrayList<>();

        for (Negociacao negociacao : negociacoes) {
            if (negociacao.getTipoDeMovimentacao().equals(tipoDeMovimentacao)) {
                negociacoesDeUmTipoDeMovimentacao.add(negociacao);
            }
        }

        return negociacoesDeUmTipoDeMovimentacao;
    }

    @Override
    public double totalInvestido() {
        NegociacaoRepository repoNegociacao = new CSVNegociacaoRepository();
        ArrayList<Negociacao> negociacoes = repoNegociacao.todas();

        double total = 0.0;
        for (Negociacao negociacao : negociacoes) {
            total += negociacao.getValorTotalNegociado();
        }

        return total;
    }

    @Override
    public double totalInvestido(String codigo) {
        NegociacaoRepository repoNegociacao = new CSVNegociacaoRepository();
        ArrayList<Negociacao> negociacoes = repoNegociacao.todas();

        double total = 0.0;
        for (Negociacao negociacao : negociacoes) {
            if (negociacao.getCodigoDeNegociacao().equals(codigo)) {
                total += negociacao.getValorTotalNegociado();
            }
        }

        return total;
    }

    @Override
    public ArrayList<Negociacao> entreOPeriodo(LocalDate inicioDoPeriodo, LocalDate terminoDoPeriodo) {
        // TODO Auto-generated method stub
        return null;
    }
}
