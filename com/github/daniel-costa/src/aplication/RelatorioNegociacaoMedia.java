package aplication;

import java.util.ArrayList;

import business.NegociacaoMedia;
import business.NegociacaoRepository;
import business.TipoDeMovimentacao;
import persistence.CSVNegociacaoRepository;

public class RelatorioNegociacaoMedia {

    public ArrayList<NegociacaoMedia> relatorioNegociacaoMedia() {
        ArrayList<NegociacaoMedia> negociacoesMedia = new ArrayList<>();

        NegociacaoRepository repoNegociacaoRepository = new CSVNegociacaoRepository();

        for (String codigo : repoNegociacaoRepository.ativosNegociados()) {
            negociacoesMedia.add(repoNegociacaoRepository.negociacaoMedia(codigo, TipoDeMovimentacao.COMPRA));
        }

        return negociacoesMedia;

    }
}
