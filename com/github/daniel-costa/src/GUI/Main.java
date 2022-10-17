package GUI;

import java.util.Locale;
import java.util.Scanner;

import aplication.Metricas;
import business.negocio.IMetricas;
import business.negocio.NegociacaoMedia;

public class Main {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);

        IMetricas repoMetricas = new Metricas();

        Scanner sc = new Scanner(System.in);
        String codigo = sc.nextLine();
        NegociacaoMedia negociacaoMedia = repoMetricas.negociacaoMedia(codigo);
        System.out.printf("Ativo: %s \nValor relativo: %.2f", negociacaoMedia.getCodigoDeNegociacao(),
                negociacaoMedia.getPrecoNegociado());

        sc.close();
    }
}