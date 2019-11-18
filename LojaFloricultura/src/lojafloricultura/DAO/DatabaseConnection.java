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
    public static String SENHA = "root";
    public static String URL = "jdbc:mysql://localhost:3306/floricultura?useTimezone=true&serverTimezone=UTC&useSSL=false";
    private static Connection conexao = null;
    
    public static boolean executarUpdate(String query){
        boolean retorno = false;
        
        System.out.println("Executar Update");
        
        try {
            Class.forName(DRIVER);
            
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
            Statement comando = conexao.createStatement();
            
            int linhasAfetadas = comando.executeUpdate(query);
            System.out.println(linhasAfetadas);
            if(linhasAfetadas > 0){
                retorno = true;
            } else {
                retorno = false;
            }
        } catch (ClassNotFoundException ex){
            System.out.println("Driver não encontrado.");
            System.out.println(ex);
            retorno = false;
        } catch (SQLException ex) {
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

    public static ResultSet executarQuery(String query){
        System.out.println("Executar Query");
        ResultSet retorno = null;  
        
        try {
            System.out.println("Executar Query 2");
            Class.forName(DRIVER);
            
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
            Statement comando = conexao.createStatement();
            
            //ResultSet rs = comando.executeQuery(query);
            boolean resultado = comando.execute(query);
            
            retorno = comando.getResultSet();
            
            System.out.print("Retorno: ");
            System.out.println(retorno);
        } catch (ClassNotFoundException ex){
            System.out.println("Driver não encontrado.");
            retorno = null;
        } catch (SQLException ex) {
            System.out.println(ex);
            System.out.println("Erro no comando SQL.");
            retorno = null;
        } finally {
            DatabaseConnection.closeConnection();
        }
        
        return retorno;
    }
    
    
    private static void closeConnection() {
        try {
             if(conexao != null){
               conexao.close();
               conexao = null;
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

}
