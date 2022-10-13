package aplication;

import java.util.ArrayList;

import business.IMetricas;
import business.Negociacao;
import business.NegociacaoMedia;
import business.NegociacaoRepository;
import business.TipoDeMovimentacao;
import persistence.CSVNegociacaoRepository;

public class Metricas implements IMetricas {

    public NegociacaoMedia negociacaoMedia(String codigo) throws ArithmeticException {
        NegociacaoMedia compra = negociacaoMedia(codigo, TipoDeMovimentacao.COMPRA);
        NegociacaoMedia venda = negociacaoMedia(codigo, TipoDeMovimentacao.COMPRA);

        int quantidadeNegociada = (compra.getQuantidadeNegociada() - venda.getQuantidadeNegociada()); // referente ao
                                                                                                      // ativo e ao tipo
                                                                                                      // de
                                                                                                      // movimentação.
        double valorTotalNegociado = compra.getValorTotalNegociado() - venda.getValorTotalNegociado();
        double precoMedio = 0.0;

        try {
            precoMedio = valorTotalNegociado / quantidadeNegociada;
        } catch (ArithmeticException e) {
            quantidadeNegociada = 0;
            valorTotalNegociado = 0.0;
            precoMedio = 0.0;
        }

        return new NegociacaoMedia(TipoDeMovimentacao.COMPRA, codigo, quantidadeNegociada, precoMedio,
                valorTotalNegociado);
    }

    public NegociacaoMedia negociacaoMedia(String codigo, TipoDeMovimentacao tipoDeMovimentacao) {
        NegociacaoRepository repoNegociacao = new CSVNegociacaoRepository();
        ArrayList<Negociacao> negociacoesDeUmAtivo = repoNegociacao.porCodigo(codigo);

        int quantidadeNegociada = 0; // referente ao ativo e ao tipo de movimentação.
        double valorTotalNegociado = 0.0;
        double precoMedio = 0.0;

        for (Negociacao negociacao : negociacoesDeUmAtivo) {
            if (negociacao.getTipoDeMovimentacao().equals(tipoDeMovimentacao)) {
                quantidadeNegociada += negociacao.getQuantidadeNegociada();
                valorTotalNegociado += negociacao.getValorTotalNegociado();
            }
        }
        precoMedio = valorTotalNegociado / quantidadeNegociada;

        return new NegociacaoMedia(tipoDeMovimentacao, codigo, quantidadeNegociada, precoMedio, valorTotalNegociado);
    }

    public ArrayList<NegociacaoMedia> negociacoesMedias() {
        return null;
    }

}
