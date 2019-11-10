/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojafloricultura.DAO;

import lojafloricultura.model.Venda;
import lojafloricultura.model.Cliente;
import java.util.ArrayList;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author lukas.camargo
 */
public class VendaDAO {
    Cliente Cliente = null;
        
    public static boolean salvar(Venda v){
        return DatabaseConnection.executarUpdate("");
    }
    
    
    public static boolean atualizar(Venda v){
        return DatabaseConnection.executarUpdate("");
    }
    
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
