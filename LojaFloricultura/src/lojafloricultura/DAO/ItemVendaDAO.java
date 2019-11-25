/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojafloricultura.DAO;

import lojafloricultura.model.ItemVenda;
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
public class ItemVendaDAO {
    
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
     * @param i - ItemVenda
     * @return ItemVenda 
     * @version 1.0
     * @since 18 de Novembro (data do Javadoc)
    */
    public static ItemVenda salvar(ItemVenda i){
        ItemVenda item = new ItemVenda();
        
        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
            Statement comando = conexao.createStatement();
            int linhasAfetadas = comando.executeUpdate("INSERT INTO itemvenda(produtoId, vendaId, quantidade, precoUnitario, precoTotal) VALUES ("
                    + i.getProdutoId() + ","
                    + i.getVendaId() + ","
                    + i.getQuantidade() + ","
                    + i.getPrecoUnitario() + ","
                    + i.getPrecoTotal() + ")", Statement.RETURN_GENERATED_KEYS);
            System.out.println("Linhas Afetadas: " + linhasAfetadas);
            
            ResultSet rs = comando.getGeneratedKeys();
            
            System.out.println(rs);
            
            while(rs.next()){
                //item.setId(rs.getInt("id"));
                item = i;
                item.setId(Integer.parseInt(String.valueOf(rs.getLong(1))));
                /*item.setProdutoId(rs.getInt("produtoId"));
                item.setPrecoUnitario(rs.getDouble("precoUnitario"));
                item.setPrecoTotal(rs.getDouble("precoTotal"));
                item.setQuantidade(rs.getInt("quantidade"));*/
            }
            
        } catch (SQLException ex){
            System.out.println("SQL Exception: " + ex);
            item = null;
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver não encontrado.");
            item = null;
        } finally {
            try {
                if(conexao != null)
                    conexao.close();
            } catch (SQLException ex) {
                System.out.println("SQL Exception: " + ex);
            }
        }
        
        return item;
    }
    
    /**
     * 
     * Este é o método que busca e retorna uma lista de Itens para Venda
     * 
     * @author lukas.fialho
     * @param vendaId int - ID da Venda
     * @return LIsta de ItemVenda 
     * @version 1.0
     * @since 18 de Novembro (data do Javadoc)
    */
    public static ArrayList<ItemVenda> getItensPorVendaId(int vendaId){
        ArrayList<ItemVenda> listaItens = new ArrayList<>();
        
        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
            Statement comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM itemvenda "
                + "WHERE vendaId = " + vendaId);
            
            while(rs.next()){
                ItemVenda i = new ItemVenda();
                i.setId(rs.getInt("id"));
                i.setProdutoId(rs.getInt("produtoId"));
                i.setVendaId(rs.getInt("vendaId"));
                i.setQuantidade(rs.getInt("quantidade"));
                i.setPrecoUnitario(rs.getDouble("precoUnitario"));
                i.setPrecoTotal(rs.getDouble("precoTotal"));
                listaItens.add(i);
            }
            
            System.out.println("Tamanho do Lista Itens" + listaItens.size());
            
        } catch(SQLException ex){
           listaItens = null;
        }  catch (ClassNotFoundException ex){
            System.out.println("Driver não encontrado.");
            listaItens = null;
        } finally {
            try {
                if(conexao!=null)
                  conexao.close();
            } catch (SQLException ex) {
                return null;
            }
        }
        
        return listaItens;
    }
    
    /**
     * 
     * Este é o método que busca e retorna uma lista de Itens para Venda
     * 
     * @author lukas.fialho
     * @param iID int - ID do Item 
     * @return boolean
     * @version 1.0
     * @since 18 de Novembro (data do Javadoc)
    */
    public static boolean excluir(int iID){
        boolean retorno = false;
        Connection conexao = null;
        Statement instrucaoSQL = null; 
        
        try {
            //Carrega a classe responsável pelo driver
            Class.forName(DRIVER);
            
            //Tenta estabeler a conexão com o SGBD e cria o objeto de conexão
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);     
            instrucaoSQL = conexao.createStatement(); 
            
            int linhasAfetadas = instrucaoSQL.executeUpdate("DELETE FROM itemvenda where id= " + iID);
            
            if(linhasAfetadas>0)
            {
                retorno = true;
            } else {
                retorno = false;
            }
            
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver não encontrado.");
            retorno = false;
        } catch (SQLException ex) {
            System.out.println("Erro no comando SQL.");
            retorno = false;
        } finally {
            
            //Libero os recursos da memória
            try {
                if(instrucaoSQL!=null)
                    instrucaoSQL.close();
                if(conexao!=null)
                  conexao.close();
            } catch (SQLException ex) {
                return false;
            }
        }
        return retorno;
    }
}
