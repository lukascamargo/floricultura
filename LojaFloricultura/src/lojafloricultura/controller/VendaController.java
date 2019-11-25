/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojafloricultura.controller;
import java.sql.SQLException;
import lojafloricultura.DAO.ClienteDAO;
import lojafloricultura.DAO.ProdutoDAO;
import lojafloricultura.DAO.VendaDAO;
import lojafloricultura.model.Cliente;
import lojafloricultura.model.Produto;
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
      
    
      public boolean finalizaVenda(Venda venda){
          venda.setDataAtualizacao(new Date());
          return VendaDAO.atualizarVenda(venda);
      }
      
      
}
