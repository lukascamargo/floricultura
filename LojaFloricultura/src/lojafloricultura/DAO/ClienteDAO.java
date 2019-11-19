/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojafloricultura.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import lojafloricultura.model.Cliente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author lukas.camargo
 */
public class ClienteDAO {  
    
    public static String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static String LOGIN = "root";
    public static String SENHA = "";
    public static String URL = "jdbc:mysql://localhost:3307/floricultura?useTimezone=true&serverTimezone=UTC&useSSL=false";
    private static Connection conexao = null;
    
    
    
    public static boolean salvar(Cliente c){
        boolean retorno = false;
        
        try {
            Class.forName(DRIVER);
            
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
            Statement comando = conexao.createStatement();
        
        int linhasAfetadas = comando.executeUpdate("INSERT INTO clientes (nome, cpf, email, sexo, endereco, numero, complemento, estadoCivil, dataNasc, telefone) values("
                    + "'" + c.getNome() + "'" + "," + "'"
                    + c.getCPF().replace(".", "").replace("-", "") + "'" + ")"+ "'"
                    + c.getEmail() + "'" + ", " + "'"
                    + c.getSexo() + "'" + ", " + "'"
                    + c.getEndereco() + "'" + ", " + "'"
                    + c.getNumero() + "'" + ", " + "'" 
                    + c.getComplemento() + "'" + ", " + "'"
                    + c.getEstadoCivil() + "'" + ", " + "'"
                    + c.getDataNasc() + "'" + ", " + "'"
                    + c.getTelefone() + "'" + ", " + "'");
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
        return true;
    }
    
    public static boolean atualizar(Cliente c){
        return DatabaseConnection.executarUpdate("UPDATE Clientes SET"
                + "NOME = " + "'" + c.getNome() + "'" + ","
                + "CPF = " + "'" + c.getCPF().replace(".","").replace("-","") + "'" + ","
                + "EMAIL = " + "'" + c.getEmail() + "'" + ","
                + "SEXO = " + "'" + c.getSexo() + "'" + ","
                + "ENDERECO = " + "'" +c.getEndereco() + "'" + ","
                + "NUMERO = " + "'" +c.getNumero() + "'" + ","
                + "COMPLEMENTO = " + "'" +c.getComplemento() + "'" + ","
                + "ESTADOCIVIL = " + "'" +c.getEstadoCivil() + "'" + ","
                + "DATANASC = " + "'" +c.getDataNasc() + "'" +","
                + "TELEFONE = " + "'" + c.getTelefone() + "'"
                + "WHERE ID = " + c.getId());
    }
    
    public static boolean excluir(int cID){
        return DatabaseConnection.executarUpdate("DELETE FROM Clientes"
                + "WHERE ID = " + cID);
    }
    
    public static ArrayList<Cliente> getClientes() {
        Connection conexao = null;
        Statement instrucaoSQL = null; 
        ResultSet rs = null;
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        
       
        try {
            
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);  
            instrucaoSQL = conexao.createStatement();
            rs = instrucaoSQL.executeQuery("SELECT * FROM Clientes");
            
            while(rs.next()){
                Cliente c = new Cliente();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setCPF(rs.getString("cpf"));
                c.setEmail(rs.getString("email"));
                c.setSexo(rs.getString("sexo"));
                c.setEndereco(rs.getString("endereco"));
                c.setNumero(rs.getString("numero"));
                c.setComplemento(rs.getString("complemento"));
                c.setEstadoCivil(rs.getString("estadoCivil"));
                c.setDataNasc(rs.getString("dataNasc"));
                c.setTelefone(rs.getString("telefone"));
                listaClientes.add(c);
            }
        
        } catch (SQLException ex){
            listaClientes = null;
        } catch (ClassNotFoundException ex) { 
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaClientes;
    }
    
    public static ArrayList<Cliente> getClienteByCPF(String cCPF) throws SQLException {
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        Cliente c = new Cliente();
        
        Connection conexao = null;
        Statement instrucaoSQL = null; 
        ResultSet rs = null;
        
        
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);  
            instrucaoSQL = conexao.createStatement();
            rs = instrucaoSQL.executeQuery("SELECT * FROM Clientes"
                + " WHERE CPF = " + "'" + cCPF + "'");
        try {
            while(rs.next()){
                c.setId(rs.getInt("ID"));
                c.setNome(rs.getString("NOME"));
                c.setCPF(rs.getString("CPF"));
                c.setEmail(rs.getString("EMAIL"));
                c.setSexo(rs.getString("SEXO"));
                c.setEndereco(rs.getString("ENDERECO"));
                c.setNumero(rs.getString("NUMERO"));
                c.setComplemento(rs.getString("COMPLEMENTO"));
                c.setEstadoCivil(rs.getString("estadoCivil"));
                c.setDataNasc(rs.getString("dataNasc"));
                c.setTelefone(rs.getString("telefone"));
                listaClientes.add(c);
            }
        
        } catch (SQLException ex){
            c = null;
        } 
        
        return listaClientes;
    }
    
    public static Cliente getClienteByCpfForBuy(String cCPF) {
        Cliente c = new Cliente();
        
        ResultSet rs = DatabaseConnection.executarQuery("SELECT * FROM Clientes"
                + "WHERE CPF = " + "'" + cCPF + "'");
        try {
            while(rs.next()){
                c.setId(rs.getInt("ID"));
                c.setNome(rs.getString("NOME"));
                c.setCPF(rs.getString("CPF"));
                c.setEmail(rs.getString("EMAIL"));
                c.setSexo(rs.getString("SEXO"));
                c.setEndereco(rs.getString("ENDERECO"));
                c.setNumero(rs.getString("NUMERO"));
                c.setComplemento(rs.getString("COMPLEMENTO"));
                c.setEstadoCivil(rs.getString("estadoCivil"));
                c.setDataNasc(rs.getString("dataNasc"));
                c.setTelefone(rs.getString("telefone"));
            }
        
        } catch (SQLException ex){
            c = null;
        } 
        
        return c;
    }
    
    public static Cliente getClienteByNome(String cNome) {
        Cliente c = new Cliente();
        
        ResultSet rs = DatabaseConnection.executarQuery("SELECT * FROM Clientes"
                + "WHERE NOME = " + "'" + cNome + "'");
        try {
            while(rs.next()){
                c.setId(rs.getInt("ID"));
                c.setNome(rs.getString("NOME"));
                c.setCPF(rs.getString("CPF"));
                c.setEmail(rs.getString("EMAIL"));
                c.setSexo(rs.getString("SEXO"));
                c.setEndereco(rs.getString("ENDERECO"));
                c.setNumero(rs.getString("NUMERO"));
                c.setComplemento(rs.getString("COMPLEMENTO"));
                c.setEstadoCivil(rs.getString("estadoCivil"));
                c.setDataNasc(rs.getString("dataNasc"));
                c.setTelefone(rs.getString("telefone"));
            }
        
        } catch (SQLException ex){
            c = null;
        } 
        
        return c;
    }
    
    public static Cliente getClienteById(int cId) {
        Cliente c = new Cliente();
        
        ResultSet rs = DatabaseConnection.executarQuery("SELECT * FROM Clientes"
                + "WHERE ID = " + "'" + cId + "'");
        try {
            while(rs.next()){
                c.setId(rs.getInt("ID"));
                c.setNome(rs.getString("NOME"));
                c.setCPF(rs.getString("CPF"));
                c.setEmail(rs.getString("EMAIL"));
                c.setSexo(rs.getString("SEXO"));
                c.setEndereco(rs.getString("ENDERECO"));
                c.setNumero(rs.getString("NUMERO"));
                c.setComplemento(rs.getString("COMPLEMENTO"));
                c.setEstadoCivil(rs.getString("estadoCivil"));
                c.setDataNasc(rs.getString("dataNasc"));
                c.setTelefone(rs.getString("telefone"));
            }
        
        } catch (SQLException ex){
            c = null;
        } 
        
        return c;
    }
}
