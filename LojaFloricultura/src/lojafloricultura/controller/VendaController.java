/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojafloricultura.controller;
import java.sql.SQLException;
import java.time.LocalDate;
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
            System.out.println("CPF: " + cpf);
            listaClientes = ClienteDAO.getClienteByCPF(cpf.replace(".", "").replace("-", ""));
            System.out.println(listaClientes);
            
        } catch (SQLException ex) {
            Logger.getLogger(VendaController.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println(listaClientes);
        
        
        int size = listaClientes.size();
        
        System.out.println("Size: " + size);
        
        
        Cliente cliente = new Cliente();
        cliente = listaClientes.get(size - 1);
        
        System.out.println("Cliente: " + cliente);

        return cliente;
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
    
    /**
     * 
     * Este método é utilizado para fazer pesquisas por range de data, para relatórios
     * 
     * @author lukas.fialho
     * @param dataInicail Date - Data da compra inicial
     * @param dataFinal Date - Data da compra final
     * 
     * @return String[] - Lista de Vendas com range de data
     * @version 1.0
     * @since 18 de Novembro (Data do Javadoc)
    */
    public static ArrayList<String[]> relatorioVendas(String dataInicail, String dataFinal){
        //java.sql.Date dataInicialSql = new java.sql.Date(dataInicail);
        //java.sql.Date dataFinalSql = new java.sql.Date(dataFinal);
        
        ArrayList<String[]> listaVendas = new ArrayList<>();
        
        //listaVendas = VendaDAO.relatorioVendas(dataInicialSql, dataFinalSql);
        
        return listaVendas;
    }
    
    public static ArrayList<String[]> buscarVendaPorDatas(String dataInicial, String dataFinal){
        System.out.println("Data Inicial" + dataInicial);
        System.out.println("Data Final" + dataFinal);
        ArrayList<Venda> listaVendas = VendaDAO.buscarVendaPorDatas(dataInicial, dataFinal);
        ArrayList<String[]> resultado = new ArrayList<>();
        
        for(int i = 0; i < listaVendas.size(); i++){
            resultado.add(new String[]{
                String.valueOf(listaVendas.get(i).getCodigo()),
                String.valueOf(listaVendas.get(i).getCliente()),
                ClienteDAO.getClienteById(listaVendas.get(i).getCliente()).getNome(),
                String.valueOf(listaVendas.get(i).getDataDaCompra()),
                String.valueOf(listaVendas.get(i).getDataAtualizacao()),
                String.valueOf(listaVendas.get(i).getValorTotal())
            });
        }
        
        return resultado;
        
    }
    
    
    
    
      
}
