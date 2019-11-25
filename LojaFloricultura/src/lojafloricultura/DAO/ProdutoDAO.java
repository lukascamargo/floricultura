/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojafloricultura.DAO;

import lojafloricultura.model.Produto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
/**
 * Essa DAO é de conexão com o banco de dados para todas as ocasiões de Produto
 * @author lukas.camargo
 */
public class ProdutoDAO {
    public static String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static String LOGIN = "root";
    public static String SENHA = "root";
    public static String URL = "jdbc:mysql://localhost:3306/floricultura?useTimezone=true&serverTimezone=UTC&useSSL=false";
    private static Connection conexao = null;
   
        
    /**
     * 
     * Este é o método que salva o Produto no banco de dados. 
     * Caso tenha qualquer alteração no model, é necessário refletir nesta <b>classe</b>
     * 
     * @author lukas.fialho
     * @param p - Produto
     * @return boolean - informa se salvou no banco ou não
     * @version 1.0
     * @since 18 de Novembro (data do Javadoc)
    */
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
                return false;
            }
        }
        
        return retorno;
    }
    
    /**
     * Esste método deve ser utilizado para atualizar as informações de Produto no banco de dados. Caso tenha qualquer alteração no model, é necessário refletir nesta <b>classe</b>
     * @author lukas.fialho
     * @param p - Produto que será atualizado
     * @return boolean - informação se o insert de dados foi realizado ou não
     * @version 1.0
     * @since 18 de Novembro (Data do Javadoc)
    */
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
                return false;
            }
        }
        
        return retorno;
    }
    
    /**
     * 
     * Esse método deve ser utilizado para deletar algum produto do banco de dados.
     * 
     * @author lukas.fialho
     * @param pID - Produto ID
     * @return boolean - Informação se o delete foi realizado ou não
     * @version 1.0.
     * @since 18 de Novembro (Data do Javadoc)
    */
    public static boolean excluir(int pID){
        return DatabaseConnection.executarUpdate("DELETE FROM produtos"
                + " WHERE ID = " + pID);
    }
    
    /**
     * 
     * Esse método deve ser utilizado para buscar todos os Produtos cadastrados na base
     * 
     * @author lukas.fialho
     * @return ArrayList
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    public static ArrayList<Produto> getProdutos(){
        ArrayList<Produto> listaProdutos = new ArrayList<>();
        
        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
            Statement comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM produtos");
            System.out.println(rs);
            while(rs.next()){
                Produto p = new Produto();
                System.out.println(p);
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
                return null;
            }
        }
        
        return listaProdutos;
    }
    
    /**
     * 
     * Esse método deve ser utilizado para buscar o Produto cadastrado que possui um ID específico
     * 
     * @author lukas.fialho
     * @param id - ID do Produto
     * @return Produto
     * @version 1.0
     * @throws SQLException - Se existir alguma exceção de SQL
     * @throws ClassNotFoundException - Se existir algum problema de criação de classe do SQL
     * @since 18 de Novembro(Javadoc)
    */
    public static Produto getProdutoById(int id) throws SQLException, ClassNotFoundException{
        Produto p = new Produto();
        
        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
            Statement comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM produtos "
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

    /**
     * 
     * Esse método deve ser utilizado para buscar os Produtos cadastrados que possuem nomes parecidos com o do parametro informado
     * 
     * @author lukas.fialho
     * @param nome - Nome do Produto a ser Pesquisado
     * @return AraryList
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
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
                p.setValor(rs.getDouble("valor"));
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
                return null;
            }
        }
        
        return listaProdutos;
    }
    
}
