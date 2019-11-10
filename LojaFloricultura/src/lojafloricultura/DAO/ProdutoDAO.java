/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojafloricultura.DAO;

import lojafloricultura.model.Produto;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
/**
 *
 * @author lukas.camargo
 */
public class ProdutoDAO {
        
    public static boolean salvar(Produto p){
        System.out.println(p);
        return DatabaseConnection.executarUpdate("INSER INTO Produtos (nome, quantidade, valor, descricao)"
                + "'" + p.getNome() + "'" + ","
                + "'" + p.getQuantidade() + "'" + ","
                + "'" + p.getValor() + "'" + ","
                + "'" + p.getDescricao() + "'" + ")");
    }
    
    public static boolean atualizar(Produto p){
        return DatabaseConnection.executarUpdate("UPDATE Produtos SET"
                + "NOME = " + "'" + p.getNome() + "'" + ","
                + "DESCRICAO = " + "'" + p.getDescricao() + "'" + ","
                + "VALOR = " + "'" + p.getValor() + "'" + ","
                + "QUANTIDADE = " + "'" + p.getQuantidade() + "'"
                + "WHERE ID = " + p.getId());   
    }
    
    public static boolean excluir(int pID){
        return DatabaseConnection.executarUpdate("DELETE FROM Produtos"
                + "WHERE ID = " + pID);
    }
    
    public static ArrayList<Produto> getProdutos(){
        ArrayList<Produto> listaProdutos = new ArrayList<>();
        ResultSet rs = DatabaseConnection.executarQuery("SELECT * FROM Produtos");
        try {
            while(rs.next()){
                Produto p = new Produto();
                p.setId(rs.getInt("ID"));
                p.setQuantidade(rs.getInt("QUANTIDADE"));
                p.setValor(rs.getDouble("VALOR") + 50);
                p.setNome(rs.getString("NOME"));
                p.setDescricao(rs.getString("DESCRICAO"));
                listaProdutos.add(p);
            }
            
        } catch(SQLException ex){
           listaProdutos = null;
        }
        return listaProdutos;
    }
    
    public static Produto getProdutoById(int id){
        Produto p = new Produto();
        ResultSet rs = DatabaseConnection.executarQuery("SELECT * FROM Produtos"
                + "WHERE ID = " + id);
        try {
            while(rs.next()){
                p.setId(rs.getInt("ID"));
                p.setQuantidade(rs.getInt("QUANTIDADE"));
                p.setValor(rs.getDouble("VALOR"));
                p.setNome(rs.getString("NOME"));
                p.setDescricao(rs.getString("DESCRICAO"));
            }
            
        } catch(SQLException ex){
           p = null;
        }
        return p;
    }
    
    public static Produto getProdutoByNome(String nome){
        Produto p = new Produto();
        ResultSet rs = DatabaseConnection.executarQuery("SELECT * FROM Produtos"
                + "WHERE NOME LIKE " + "%" + nome + "%");
        try {
            while(rs.next()){
                p.setId(rs.getInt("ID"));
                p.setQuantidade(rs.getInt("QUANTIDADE"));
                p.setValor(rs.getDouble("VALOR"));
                p.setNome(rs.getString("NOME"));
                p.setDescricao(rs.getString("DESCRICAO"));
            }
            
        } catch(SQLException ex){
           p = null;
        }
        return p;
    }
    
}
