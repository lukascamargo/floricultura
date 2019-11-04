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
public class ProdutoDAO {
    public static boolean salvar(Produto p){
        return SimulaDBProduto.getIntance().SalvarProduto(p);
    }
    
    public static boolean atualizar(Produto p){
        return SimulaDBProduto.getIntance().AtualizarProduto(p);
    }
    
    public static boolean excluir(int pID){
        return SimulaDBProduto.getIntance().ExcluirProduto(pID);
    }
    
    public static ArrayList<Produto> getProdutos(){
        return SimulaDBProduto.getIntance().getProdutos();
    }
    
    public static Produto getProdutoById(int id){
        return SimulaDBProduto.getIntance().getProdutoById(id);
    }
    
    public static Produto getProdutoByNome(String nome){
        return SimulaDBProduto.getIntance().getProdutoByNome(nome);
    }
    
}
