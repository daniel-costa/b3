package business;

import java.time.LocalDate;
import java.util.ArrayList;

public interface NegociacaoRepository {

    /**
     * Fornece todas as negociações.
     * 
     * @return retorna uma lista com todas as negociações ou {@code}NULL
     *         caso não tenha nenhuma.
     */
    public ArrayList<Negociacao> todas();

    /**
     * Fornece as negociações de acordo com o tipo desejado.
     * 
     * @param tipoDeMovimentacao Tipo de movimentação, compra ou venda.
     * @return Retorna uma lista com as negociações do tipo fornecido.
     */
    public ArrayList<Negociacao> porTipoDeMovimentacao(TipoDeMovimentacao tipoDeMovimentacao);

    /**
     * Fornece as negociações realizadas no periodo fornecido.
     * 
     * @param inicioDoPeriodo  Data que marca o período desejado.
     * @param terminoDoPeriodo Data que marca o termino do período desejado.
     * @return Retorna uma lista com as negociações dentro do período
     *         delimitado.
     */
    public ArrayList<Negociacao> entreOPeriodo(LocalDate inicioDoPeriodo, LocalDate terminoDoPeriodo);

    /**
     * Fornece as negociações realizadas por um determinado ativo.
     * 
     * @param codigo Código que identifica um ativo na bolsa de valores.
     * @return Retorna uma lista que contem as negociações do ativo fornecido.
     */
    public ArrayList<Negociacao> porCodigo(String codigo);

    /**
     * Fornece uma lista de todos os ativos negociados.
     * 
     * @return Lista de ativos negociados.
     */
    public ArrayList<String> ativosNegociados();

    /**
     * Calcula o total investido.
     * 
     * @return O total investido em todos os ativos.
     */
    public double totalInvestido();

    /**
     * Calcula o total investido em um determidado ativo.
     * 
     * @param codigo Código do ativo desejado.
     * @return Retorna o valor investido em um determinado ativo.
     */
    public double totalInvestido(String codigo);

}
