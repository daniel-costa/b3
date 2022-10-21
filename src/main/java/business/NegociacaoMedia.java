package main.java.business;

/* Negociação Média: é uma negociação simbólica que tem mesmo
resultado prático que todas as outras negociações daquele ativo.
*/
public class NegociacaoMedia extends Negociacao {

    public NegociacaoMedia() {
    }

    public NegociacaoMedia(String codigo) {
        super(codigo);
    }

    public NegociacaoMedia(TipoDeMovimentacao tipoDeMovimentacao, String codigoDeNogociacao) {
        super(tipoDeMovimentacao, codigoDeNogociacao);
    }

    public NegociacaoMedia(TipoDeMovimentacao tipoDeMovimentacao, String codigoDeNogociacao, int quantidadeNegociada,
            double precoNegociado, double valorTotalNegociado) {
        super(tipoDeMovimentacao, codigoDeNogociacao, quantidadeNegociada, precoNegociado, valorTotalNegociado);
    }
}
