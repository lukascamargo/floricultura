/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojafloricultura.controller;
import java.sql.SQLException;
import lojafloricultura.DAO.ClienteDAO;
import lojafloricultura.DAO.VendaDAO;
import lojafloricultura.model.Cliente;
import lojafloricultura.model.Venda;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Date;

/**
 *
 * @author lukas.camargo
 */
public class VendaController {
    /**
     * 
     * Método para buscar cliente por CPF
     * 
     * @author lukas.fialho, Italo
     * @param cpf String - CPF do Cliente
     * @return Cliente
     * 
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    public Cliente buscarClientePorCPF(String cpf){
        ArrayList<Cliente> listaClientes = new ArrayList<>();

        if(cpf == null){
            throw new Error("É necessário informar o CPF do Cliente");
        }

        try {
            listaClientes = ClienteDAO.getClienteByCPF(cpf);
        } catch (SQLException ex) {
            Logger.getLogger(VendaController.class.getName()).log(Level.SEVERE, null, ex);
        }

        int size = listaClientes.size();

        return listaClientes.get(size - 1);
    }

    /**
     * 
     * Método para criar uma venda 
     * 
     * @author lukas.fialho, Italo
     * @param clienteId int - ID do Cliente
     * @return Venda
     * 
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    public Venda criarVenda(int clienteId){
        Venda venda = new Venda();
        venda.setCliente(clienteId);
        venda.setDataDaCompra(new Date());
        venda.setDataAtualizacao(new Date());
        venda.setPagamento("");
        venda = VendaDAO.criarVenda(venda);
        System.out.println("Venda ID" + venda.getCodigo());
        return venda;
    }

    /**
     * 
     * Método para finalizar uma venda 
     * 
     * @author lukas.fialho, Italo
     * @param venda Venda - Venda com todas as propriedades definidas
     * @return boolean
     * 
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    public boolean finalizaVenda(Venda venda){
        venda.setDataAtualizacao(new Date());
        return VendaDAO.atualizarVenda(venda);
    }
      
      
}
