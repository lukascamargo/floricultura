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
    
    public boolean salvar(String pNome, int pQuantidade, double pValor, String pDescricao ){
        Produto p = new Produto(pNome, pQuantidade, pValor, pDescricao);
        System.out.println(p);
        return ProdutoDAO.salvar(p);
    }
    
    public boolean atualizar(int id, String pNome, int pQuantidade, double pValor, String pDescricao){
        Produto p = new Produto(id, pNome, pQuantidade, pValor, pDescricao);
        System.out.println(p);
        return ProdutoDAO.atualizar(p);
    }
    
    public boolean excluir(int id){
        return ProdutoDAO.excluir(id);
    }
    
    public ArrayList<String[]> getProdutos(){
        ArrayList<Produto> Produtos = ProdutoDAO.getProdutos();
        System.out.println(Produtos);
        ArrayList<String[]> listaProdutos = new ArrayList<>();
        
        for(int i = 0; i < Produtos.size(); i++){
            listaProdutos.add(new String[]{
               String.valueOf(Produtos.get(i).getId()),
               Produtos.get(i).getNome(),
               String.valueOf(Produtos.get(i).getQuantidade()),
               String.valueOf(Produtos.get(i).getValor()),
               Produtos.get(i).getDescricao()
            });
        }
        
        return listaProdutos;
    }
    
    public ArrayList<String[]> getProdutoById(){
        ArrayList<String[]> produtoPesquisado = new ArrayList<>();
        
        return produtoPesquisado;
    }
    
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
