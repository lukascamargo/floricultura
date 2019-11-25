/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojafloricultura.DAO;

import lojafloricultura.model.Venda;
import lojafloricultura.model.Cliente;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author lukas.camargo
 */
public class VendaDAO {
    Cliente Cliente = null;
    public static String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static String LOGIN = "root";
    public static String SENHA = "root";
    public static String URL = "jdbc:mysql://localhost:3306/floricultura?useTimezone=true&serverTimezone=UTC&useSSL=false";
    private static Connection conexao = null;
    
    /**
     * 
     * Este é o método que salva a Venda no banco de dados. 
     * Caso tenha qualquer alteração no model, é necessário refletir nesta <b>classe</b>
     * 
     * @author lukas.fialho
     * @param v - Venda
     * @return boolean - informa se salvou no banco ou não
     * @version 1.0
     * @since 18 de Novembro (data do Javadoc)
    */
    public static boolean salvar(Venda v){
        return DatabaseConnection.executarUpdate("");
    }
    
    /**
     * 
     * Esste método deve ser utilizado para atualizar as informações de uma Venda 
     * no banco de dados. Caso tenha qualquer alteração no model, é necessário refletir nesta <b>classe</b>
     * 
     * @author lukas.fialho
     * @param v - Venda que será atualizada
     * @return boolean - informação se o insert de dados foi realizado ou não
     * @version 1.0
     * @since 18 de Novembro (Data do Javadoc)
    */
    public static boolean atualizar(Venda v){
        return DatabaseConnection.executarUpdate("");
    }
    
    /**
     * 
     * Esste método deve ser utilizado para criar uma Venda 
     * 
     * @author lukas.fialho
     * @param v - Venda que será criada
     * @return boolean
     * @version 1.0
     * @since 18 de Novembro (Data do Javadoc)
    */
    public static Venda criarVenda(Venda v){
        Venda venda = new Venda();
        
        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
            Statement comando = conexao.createStatement();
            PreparedStatement pStmt = conexao.prepareStatement(
                    "INSERT INTO vendas(clienteId, valorTotal, dataDaCompra, dataAtualizacao, desconto, pagamento) VALUES (?, ?, ?, ?, ?, ?)",
                    PreparedStatement.RETURN_GENERATED_KEYS
            );
            pStmt.setInt(1, v.getCliente());
            pStmt.setDouble(2, v.getValorTotal());
            pStmt.setDate(3, new java.sql.Date(v.getDataDaCompra().getTime()));
            pStmt.setDate(4, new java.sql.Date(v.getDataAtualizacao().getTime()));
            pStmt.setInt(5, v.getDesconto());
            pStmt.setString(6, v.getPagamento());
            pStmt.executeUpdate();
      
            ResultSet rs = pStmt.getGeneratedKeys();
            System.out.println("Result Set: " + rs);
            
            while(rs.next()){
                System.out.println("Result Set Venda ID: " + rs.getLong(1));
                venda = v;
                venda.setCodigo(Integer.parseInt(String.valueOf(rs.getLong(1))));
            }
            
        } catch (SQLException ex){
            System.out.println("SQL Exception: " + ex);
            venda = null;
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver não encontrado.");
            venda = null;
        } finally {
            try {
                if(conexao != null)
                    conexao.close();
            } catch (SQLException ex) {
                System.out.println("SQL Exception: " + ex);
            }
        }
        
        return venda;
    }
    
    /**
     * 
     * Esste método deve ser utilizado para atualizar as informações de uma Venda 
     * no banco de dados. Caso tenha qualquer alteração no model, é necessário refletir nesta <b>classe</b>
     * 
     * @author lukas.fialho
     * @param v - Venda que será atualizada
     * @return boolean - informação se o insert de dados foi realizado ou não
     * @version 1.0
     * @since 18 de Novembro (Data do Javadoc)
    */
    public static boolean atualizarVenda(Venda v){
        boolean retorno = false;
        
        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
            Statement comando = conexao.createStatement();
            PreparedStatement pStmt = conexao.prepareStatement(
                    "UPDATE vendas SET clienteId=?, valorTotal=?, dataDaCompra=?, dataAtualizacao=?, desconto=?, pagamento=? WHERE id = ?"
            );
            pStmt.setInt(1, v.getCliente());
            pStmt.setDouble(2, v.getValorTotal());
            pStmt.setDate(3, new java.sql.Date(v.getDataDaCompra().getTime()));
            pStmt.setDate(4, new java.sql.Date(v.getDataAtualizacao().getTime()));
            pStmt.setInt(5, v.getDesconto());
            pStmt.setString(6, v.getPagamento());
            pStmt.setInt(7, v.getCodigo());
            int linhasAfetadas = pStmt.executeUpdate();
            
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
    
    /**
     * 
     * Esste método deve ser utilizado para buscar as informações de uma Venda 
     * 
     * @author lukas.fialho
     * 
     * @return ArrayList
     * @version 1.0
     * @since 18 de Novembro (Data do Javadoc)
    */
    public static ArrayList<Venda> getVendas() {
        ArrayList<Venda> listaVendas = new ArrayList<>();
        
        ResultSet rs = DatabaseConnection.executarQuery("SELECT * FROM Vendas");
        
        try {
            while(rs.next()){
                Venda v = new Venda();
                
                v.setCodigo(rs.getInt("ID"));
                v.setValorTotal(rs.getDouble("VALORTOTAL"));
                v.setDataAtualizacao(rs.getDate("DATAATUALIZACAO"));
                v.setDataDaCompra(rs.getDate("DATADACOMPRA"));
                
                listaVendas.add(v);
                
            }
        } catch (SQLException ex){
            listaVendas = null;
        }
        
        return listaVendas;
    }
    
    /**
     * 
     * Esste método deve ser utilizado para buscar as informações de uma Venda a partir do Id
     * 
     * @author lukas.fialho
     * @param codigo int - ID da Venda
     * @return ArrayList
     * @version 1.0
     * @since 18 de Novembro (Data do Javadoc)
    */
    public static Venda getVenda(int codigo) {
        Venda v = new Venda();
        
        ResultSet rs = DatabaseConnection.executarQuery("SELECT * FROM Vendas"
                + " WHERE ID = " + codigo);
        
        try {
            while(rs.next()){
                
                
                v.setCodigo(rs.getInt("ID"));
                v.setValorTotal(rs.getDouble("VALORTOTAL"));
                v.setDataAtualizacao(rs.getDate("DATAATUALIZACAO"));
                v.setDataDaCompra(rs.getDate("DATADACOMPRA"));
                                
            }
        } catch (SQLException ex){
            v = null;
        }
        
        return v;
    }
        
}
