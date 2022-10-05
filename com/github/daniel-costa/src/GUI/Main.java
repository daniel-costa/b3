package GUI;

import aplication.RelatorioNegociacaoMedia;
import business.NegociacaoMedia;

public class Main {
    public static void main(String[] args) throws Exception {
        RelatorioNegociacaoMedia relatorioNegociacaoMedia = new RelatorioNegociacaoMedia();

        for (NegociacaoMedia negociacaoMedia : relatorioNegociacaoMedia.relatorioNegociacaoMedia()) {
            System.out.println(negociacaoMedia.getCodigoDeNegociacao() + ": " + negociacaoMedia.getPrecoNegociado());
        }
    }
}
