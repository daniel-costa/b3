package business;

import java.util.ArrayList;

public interface NegociacaoRepository {

    /**
     * Fornece a negociação média pelo código do ativo fornecido.
     * 
     * @param codigo Código do ativo desejado.
     * @return Negociação média do ativo desejado.
     */
    public NegociacaoMedia negociacaoMedia(String codigo);

    /**
     * Fornece a negociação média de compra ou venda do ativo fornecido.
     * 
     * @param codigo             Código do ativo fornecido.
     * @param tipoDeMovimentacao Tipo de movimentação, compra ou venda.
     * @return Retorna a negociação média de compra ou venda do ativo desejado.
     */
    public NegociacaoMedia negociacaoMedia(String codigo, TipoDeMovimentacao tipoDeMovimentacao);

    /**
     * Calcula o preço médio dos ativos comprados para o código
     * fornecido.
     * 
     * @param codigo Código do ativo desejado.
     * @return Retorna o preço médio de compra do ativo fornecido.
     */
    public double precoMedio(String codigo);

    /**
     * Calcula o total investido em um determidado ativo.
     * 
     * @param codigo Código do ativo desejado.
     * @return Retorna o valor investido em um determinado ativo.
     */
    public double totalInvestidoEmCadaAtivo(String codigo);

    /**
     * Calcula o total investido.
     * 
     * @return O total investido em todos os ativos.
     */
    public double totalInvestido();

    /**
     * Fornece uma lista de todos os ativos negociados.
     * 
     * @return Lista de ativos negociados.
     */
    public ArrayList<String> ativosNegociados();
}
