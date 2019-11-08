/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojafloricultura.DAO;

import lojafloricultura.model.Cliente;
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
public class ClienteDAO {    
    
    public static boolean salvar(Cliente c){
        return DatabaseConnection.executarUpdate("INSERT INTO Clientes (nome, CPF)"
                    + "'"
                    + c.getNome()
                    + "'"
                    + ","
                    + "'"
                    + c.getCPF().replace(".", "").replace("-", "")
                    + "'"
                    + ")");
    }
    
    public static boolean atualizar(Cliente c){
        return DatabaseConnection.executarUpdate("UPDATE Clientes SET"
                + "NOME = " + "'" + c.getNome() + "'" + ","
                + "CPF = " + "'" + c.getCPF().replace(".","").replace("-","") + "'" + ","
                + "EMAIL = " + "'" + c.getEmail() + "'" + ","
                + "SEXO = " + "'" + c.getSexo() + "'" + ","
                + "ENDERECO = " + "'" +c.getEndereco() + "'" + ","
                + "NUMERO = " + "'" +c.getNumero() + "'" + ","
                + "COMPLEMENTO = " + "'" +c.getComplemento() + "'"
                + "WHERE ID = " + c.getId());
    }
    
    public static boolean excluir(int cID){
        return DatabaseConnection.executarUpdate("DELETE FROM Clientes"
                + "WHERE ID = " + cID);
    }
    
    public static ArrayList<Cliente> getClientes(){
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        
        ResultSet rs = DatabaseConnection.executarQuery("SELECT * FROM Clientes");
        try {
            while(rs.next()){
                Cliente c = new Cliente();
                c.setId(rs.getInt("ID"));
                c.setNome(rs.getString("NOME"));
                c.setCPF(rs.getString("CPF"));
                c.setEmail(rs.getString("EMAIL"));
                c.setSexo(rs.getString("SEXO"));
                c.setEndereco(rs.getString("ENDERECO"));
                c.setNumero(rs.getString("NUMERO"));
                c.setComplemento(rs.getString("COMPLEMENTO"));
                listaClientes.add(c);
            }
        
        } catch (SQLException ex){
            listaClientes = null;
        } finally {
            listaClientes = null;
        }
        
        return listaClientes;
    }
    
}
