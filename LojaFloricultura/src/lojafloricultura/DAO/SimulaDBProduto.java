/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojafloricultura.DAO;

import lojafloricultura.model.Produto;
import java.util.ArrayList;

/**
 *
 * @author lukas.camargo
 */
public class SimulaDBProduto {
    
    private static SimulaDBProduto mockdb;
    
    private ArrayList<Produto> listaProdutos;
    
    
    private SimulaDBProduto(){
        listaProdutos = new ArrayList<Produto>();
    }
    
    public static synchronized SimulaDBProduto getIntance(){
        if(mockdb == null)
               mockdb = new SimulaDBProduto();
        
        return mockdb;
    }
    
    public boolean SalvarProduto(Produto p){
        listaProdutos.add(p);
        return true;
    }
    
    public ArrayList<Produto> getProdutos(){
        return this.listaProdutos;
    }
    
    public boolean AtualizarProduto(Produto p){
        for(Produto item: listaProdutos){
            if(item.getId() == p.getId()){
                item.setNome(p.getNome());
                item.setDescricao(p.getDescricao());
                item.setValor(p.getValor());
            }
        }
        
        return true;
    }
    
    public boolean ExcluirProduto(int i){
        Produto produtoExcluir = new Produto();
        boolean existeNaLista = false;
        for(Produto p:listaProdutos){
            if(p.getId() == i){
                produtoExcluir = p;
                existeNaLista = true;
            }
        }
        
        if(existeNaLista) {
            listaProdutos.remove(produtoExcluir);
        }
        
        return true;    
        
    }
}
