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
 * Classe criada para trazer reaproveitamento de código durante a conexão com o banco de dados
 * @deprecated Com o não funcionamento desta classe, as conexões com o banco de dados foram adicionadas a cada uma das DAOs
 * @author lukas.camargo
 */
public class DatabaseConnection {
    public static String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static String LOGIN = "root";
    public static String SENHA = "";
    public static String URL = "jdbc:mysql://localhost:3307/floricultura?useTimezone=true&serverTimezone=UTC&useSSL=false";
    private static Connection conexao = null;
    
    /**
     * Essa função deve ser utilizada para executar algum tipo de inserção no banco de dados
     * @deprecated Em cada DAO existe uma função que pode ser utilizada no lugar desta
     * @author lukas.fialho
     * @param query - Query que será executada (string)
     * @return boolean - Se foi executada a Query ou não
     * @version 0.0 
     * @since 18 de Novembro (data do Javadoc)
    */
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

    /**
     * Essa função deve ser utilizada para executar algum tipo de busca no banco de dados
     * @deprecated Em cada DAO existe uma função que pode ser utilizada no lugar desta
     * @author lukas.fialho
     * @param query - Query que será exeutada (string)
     * @return ResultSet - Resultado da Query
     * @version 0.0
     * @since 18 de Novembro (Data do Javadoc)
    */
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
    
    /**
     * Essa função deve ser utilizada para reaproveitamento de código na hora de fechar a conexão
     * @deprecated Em cada DAO existe uma função que pode ser utilizada no lugar desta
     * @author lukas.fialho
     * @version 0.0
     * @since 18 de Novembro (Data do Javadoc)
    */
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
