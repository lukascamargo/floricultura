/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojafloricultura.controller;





import java.sql.SQLException;
import java.util.ArrayList;
import lojafloricultura.model.Produto;
import lojafloricultura.DAO.ProdutoDAO;

/**
 *
 * @author lukas.camargo
 */
public class ProdutoController {
    
    /**
     * Este método deve ser utilizado para salvar um novo Produto
     * 
     * @author lukas.fialho
     * @param pNome - Nome do Produto (string)
     * @param pQuantidade - Quantidade do Produto (int)
     * @param pValor - Valor do Produto (double)
     * @param pDescricao - Descricao do Produto (string)
     * @return boolean - Informativo caso a funcao funcionou ou nao
     * @version 1.0
     * @since  18 de Novembro (Javadoc)
    */
    public boolean salvar(String pNome, int pQuantidade, double pValor, String pDescricao ){
        Produto p = new Produto(pNome, pQuantidade, pValor, pDescricao);
        System.out.println(p);
        return ProdutoDAO.salvar(p);
    }
    
    /**
     * 
     * Este método deve ser utilizado para atualizar um Produto
     * 
     * @author lukas.fialho
     * @param id - ID do Produto (int)
     * @param pNome - Nome do Produto (string)
     * @param pQuantidade - Quantidade do Produto (int)
     * @param pValor - Valor do Produto (double)
     * @param pDescricao - Descricao do Proudot
     * @return boolean - Informativo se a operação foi sucesso ou nao
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    public boolean atualizar(int id, String pNome, int pQuantidade, double pValor, String pDescricao){
        Produto p = new Produto(id, pNome, pQuantidade, pValor, pDescricao);
        System.out.println(p);
        return ProdutoDAO.atualizar(p);
    }
    
    /**
     * 
     * Esse método é utilizado para excluir um produto
     * 
     * @author lukas.fialho
     * @param id - ID do Produto
     * @return boolean - Informativo se a operacao foi sucesso ou nao
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    public boolean excluir(int id){
        return ProdutoDAO.excluir(id);
    }
    
    /**
     * 
     * Este metodo deve ser utilizado para buscar todos os Produtos
     * 
     * @author lukas.fialho
     * @return ArrayList de String[]
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    public ArrayList<String[]> getProdutos(){
        ArrayList<Produto> Produtos = ProdutoDAO.getProdutos();
        System.out.println(Produtos);
        ArrayList<String[]> listaProdutos = new ArrayList<>();
       int n = 0;
        
        if(Produtos.size()>0){
           for(int i = 0; i < Produtos.size(); i++){
            listaProdutos.add(new String[]{
               String.valueOf(Produtos.get(i).getId()),
               Produtos.get(i).getNome(),
               String.valueOf(Produtos.get(i).getQuantidade()),
               String.valueOf(Produtos.get(i).getValor()),
               Produtos.get(i).getDescricao()
            });
            } 
        }
        
        
        
        return listaProdutos;
    }
    
    /**
     * Este metodo deve ser utilizado para trazer produto com base no ID
     * 
     * @author lukas.fialho
     * @param id - ID do Produto (int)
     * @return ArrayList de String[]
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    public ArrayList<String[]> getProdutoById(int id){
        ArrayList<String[]> produtoPesquisado = new ArrayList<>();
        
        return produtoPesquisado;
    }
    
    /**
     * Este metodo deve ser utilizado para buscar produtos com base no nome
     * 
     * @author lukas.fialho
     * @param nome - Nome do Produto (string)
     * @return ArrayList de String[]
     * @version 1.0
     * @throws SQLException - Caso tenha alguma exceção de SQL na ProdutoDAO
     * @throws ClassNotFoundException - Caso tenha algum problema ao usar a classe de conexão com o SQL na ProdutoDAO
     * @since 18 de Novembro (javadoc)
    */
    public ArrayList<String[]> getProdutoByName(String nome) throws SQLException, ClassNotFoundException{
        ArrayList<Produto> Produtos = ProdutoDAO.getProdutoByNome(nome);
        ArrayList<String[]> produtoPesquisado = new ArrayList<>();
        
        for(int i = 0; i < Produtos.size(); i++){
            produtoPesquisado.add(new String[]{
               String.valueOf(Produtos.get(i).getId()),
               Produtos.get(i).getNome(),
               String.valueOf(Produtos.get(i).getQuantidade()),
               String.valueOf(Produtos.get(i).getValor()),
               Produtos.get(i).getDescricao()
            });
        }
        
        return produtoPesquisado;
    }
    
}
