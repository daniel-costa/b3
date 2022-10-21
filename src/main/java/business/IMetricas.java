package main.java.business;

import java.util.ArrayList;

public interface IMetricas {
    /**
     * Fornece a negociação média pelo código do ativo fornecido.
     * 
     * @param codigo Código do ativo desejado.
     * @return Negociação média do ativo desejado.
     * @throws ArithmeticException Considerando o caso em que todas as
     *                             cotas compradas foram vendidas, resultaria na
     *                             prática que não houve
     *                             nenhuma negociação, restaria apenas o ônus ou o
     *                             bônus da operação.
     *                             Nesse caso teriamos uma quantidade de 0 cotas do
     *                             ativo, proporcionando
     *                             uma divisão por 0.
     */
    public NegociacaoMedia negociacaoMedia(String codigo) throws ArithmeticException;

    /**
     * Fornece a negociação média de compra ou venda do ativo fornecido.
     * 
     * @param codigo             Código do ativo fornecido.
     * @param tipoDeMovimentacao Tipo de movimentação, compra ou venda.
     * @return Retorna a negociação média de compra ou venda do ativo desejado.
     */
    public NegociacaoMedia negociacaoMedia(String codigo, TipoDeMovimentacao tipoDeMovimentacao);

    /**
     * Fornece as negociações médias de cada ativo negociado.
     * 
     * @return Retorna uma lista de negociações médias para cada ativo
     *         negociado ou {@code} null caso não tenha nenhuma negociação média.
     */
    public ArrayList<NegociacaoMedia> negociacoesMedias();
}
