/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojafloricultura.DAO;
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
public class DatabaseConnection {
    public static String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static String LOGIN = "root";
    public static String SENHA = "";
    public static String URL = "jdbc:mysql://localhost:3306/floricultura?useTimezone=true&serverTimezone=UTC&useSSL=false";
    
    public static boolean executarUpdate(String query){
        boolean retorno = false;
        Connection conexao = null;
        Statement instrucaoSQL = null;
        
        try {
            Class.forName(DRIVER);
            
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
            instrucaoSQL = conexao.createStatement();
            
            int linhasAfetadas = instrucaoSQL.executeUpdate(query);
            if(linhasAfetadas > 0){
                retorno = true;
            } else {
                retorno = false;
            }
        } catch (ClassNotFoundException ex){
            System.out.println("Driver não encontrado.");
            retorno = false;
        } catch (SQLException ex) {
            System.out.println("Erro no comando SQL.");
            retorno = false;
        } finally {
            try {
                if(instrucaoSQL != null)
                    instrucaoSQL.close();
                if(conexao != null)
                    conexao.close();    
            } catch (SQLException ex){
                
            }
        }
        
        return retorno;
        
    }

    public static ResultSet executarQuery(String query){
        ResultSet retorno = null;
        Connection conexao = null;
        Statement instrucaoSQL = null;
        
        try {
            Class.forName(DRIVER);
            
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
            instrucaoSQL = conexao.createStatement();
            
            retorno = instrucaoSQL.executeQuery(query);
        } catch (ClassNotFoundException ex){
            System.out.println("Driver não encontrado.");
            retorno = null;
        } catch (SQLException ex) {
            System.out.println("Erro no comando SQL.");
            retorno = null;
        } finally {
            try {
                if(instrucaoSQL != null)
                    instrucaoSQL.close();
                if(conexao != null)
                    conexao.close();    
            } catch (SQLException ex){
                
            }
        }
        
        return retorno;
    }

}
