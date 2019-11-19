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
    public static String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static String LOGIN = "root";
    public static String SENHA = "";
    public static String URL = "jdbc:mysql://localhost:330/floricultura?useTimezone=true&serverTimezone=UTC&useSSL=false";
    private static Connection conexao = null;
   
        
    
    public static boolean salvar(Produto p){
        boolean retorno = false;
        
        try {
            Class.forName(DRIVER);
            
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
            Statement comando = conexao.createStatement();
            
            int linhasAfetadas = comando.executeUpdate("INSERT INTO produtos (nome, quantidade, valor, descricao) VALUES ("
                + "'" + p.getNome() + "'" + ","
                + p.getQuantidade() + ","
                + p.getValor() + ","
                + "'" + p.getDescricao() + "'" + ")");
            if(linhasAfetadas > 0){
                retorno = true;
            } else {
                retorno = false;
            }
            
        } catch(ClassNotFoundException ex){
            System.out.println("Driver não encontrado.");
            System.out.println(ex);
            retorno = false;
        } catch(SQLException ex){
            System.out.println("Erro no comando SQL: " + ex);
            System.out.println(ex);
            retorno = false;
        } finally {
            try {
                if(conexao != null)
                    conexao.close();    
            } catch (SQLException ex){
                
            }
        }
        
        return retorno;
    }
    
    public static boolean atualizar(Produto p){
        boolean retorno = false;
        
        try {
            Class.forName(DRIVER);
            
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
            Statement comando = conexao.createStatement();
            
            int linhasAfetadas = comando.executeUpdate("UPDATE produtos SET "
                + "nome = " + "'" + p.getNome() + "'" + ","
                + "descricao = " + "'" + p.getDescricao() + "'" + ","
                + "valor = " +  p.getValor() + ","
                + "quantidade = " + p.getQuantidade()
                + " WHERE id = " + p.getId());
            
            if(linhasAfetadas > 0){
                retorno = true;
            } else {
                retorno = false;
            }
            
        } catch(ClassNotFoundException ex){
            System.out.println("Driver não encontrado.");
            System.out.println(ex);
            retorno = false;
        } catch(SQLException ex){
            System.out.println("Erro no comando SQL: " + ex);
            System.out.println(ex);
            retorno = false;
        } finally {
            try {
                if(conexao != null)
                    conexao.close();    
            } catch (SQLException ex){
                
            }
        }
        
        return retorno;
    }
    
    public static boolean excluir(int pID){
        return DatabaseConnection.executarUpdate("DELETE FROM produtos"
                + " WHERE ID = " + pID);
    }
    
    public static ArrayList<Produto> getProdutos(){
        ArrayList<Produto> listaProdutos = new ArrayList<>();
        
        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
            Statement comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM produtos");
            
            while(rs.next()){
                Produto p = new Produto();
                p.setId(rs.getInt("id"));
                p.setQuantidade(rs.getInt("quantidade"));
                p.setValor(rs.getDouble("valor") + 50);
                p.setNome(rs.getString("nome"));
                p.setDescricao(rs.getString("descricao"));
                listaProdutos.add(p);
            }
            
        } catch(SQLException ex){
           listaProdutos = null;
        }  catch (ClassNotFoundException ex){
            System.out.println("Driver não encontrado.");
            listaProdutos = null;
        } finally {
            try {
                if(conexao!=null)
                  conexao.close();
              } catch (SQLException ex) {
             }
        }
        
        return listaProdutos;
    }
    
    public static Produto getProdutoById(int id) throws SQLException, ClassNotFoundException{
        Produto p = new Produto();
        
        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
            Statement comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM produtos"
                + "WHERE id = " + id);
            while(rs.next()){
                p.setId(rs.getInt("id"));
                p.setQuantidade(rs.getInt("quantidade"));
                p.setValor(rs.getDouble("valor"));
                p.setNome(rs.getString("nome"));
                p.setDescricao(rs.getString("descricao"));
            }
            
        } catch(SQLException ex){
           p = null;
        } 
        return p;
    }

    public static ArrayList<Produto> getProdutoByNome(String nome){
        ArrayList<Produto> listaProdutos = new ArrayList<>();
        
        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
            Statement comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM produtos WHERE nome LIKE '%" + nome + "%'");
            
            while(rs.next()){
                Produto p = new Produto();
                p.setId(rs.getInt("id"));
                p.setQuantidade(rs.getInt("quantidade"));
                p.setValor(rs.getDouble("valor") + 50);
                p.setNome(rs.getString("nome"));
                p.setDescricao(rs.getString("descricao"));
                listaProdutos.add(p);
            }
            
        } catch(SQLException ex){
           listaProdutos = null;
        }  catch (ClassNotFoundException ex){
            System.out.println("Driver não encontrado.");
            listaProdutos = null;
        } finally {
            try {
                if(conexao!=null)
                  conexao.close();
              } catch (SQLException ex) {
             }
        }
        
        return listaProdutos;
    }
    
}
