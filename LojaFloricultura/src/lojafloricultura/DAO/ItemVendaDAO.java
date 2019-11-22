/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojafloricultura.DAO;

import lojafloricultura.model.ItemVenda;
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
public class ItemVendaDAO {
    
    public static String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static String LOGIN = "root";
    public static String SENHA = "root";
    public static String URL = "jdbc:mysql://localhost:3306/floricultura?useTimezone=true&serverTimezone=UTC&useSSL=false";
    private static Connection conexao = null;
    
    public static ItemVenda salvar(ItemVenda i){
        ItemVenda item = new ItemVenda();
        
        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
            Statement comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("INSERT INTO itemvenda(produtoId, quantidade, precoUnitario, precoTotal) VALUES ("
                    + i.getProdutoId() + ","
                    + i.getQuantidade() + ","
                    + i.getPrecoUnitario() + ","
                    + i.getPrecoTotal() + ")");
            
            while(rs.next()){
                item.setId(rs.getInt("id"));
                item.setProdutoId(rs.getInt("produtoId"));
                item.setPrecoUnitario(rs.getDouble("precoUnitario"));
                item.setPrecoTotal(rs.getDouble("precoTotal"));
                item.setQuantidade(rs.getInt("quantidade"));
            }
            
        } catch (SQLException ex){
            item = null;
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver não encontrado.");
            item = null;
        } finally {
            try {
                if(conexao != null)
                    conexao.close();
            } catch (SQLException ex) {
                
            }
        }
        
        return item;
    }
}
