/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojafloricultura.DAO;

import lojafloricultura.model.Cliente;
import java.util.ArrayList;

/**
 *
 * @author lukas.camargo
 */
public class SimulaDBCliente {
    private static SimulaDBCliente mockdb;
    
    private ArrayList<Cliente> listaClientes; 
    
    private SimulaDBCliente(){
        listaClientes = new ArrayList<>();
    }
    
    public static synchronized SimulaDBCliente getInstance(){
        if(mockdb == null)
                mockdb = new SimulaDBCliente();
        return mockdb;
    }
    
    public boolean SalvarCliente(Cliente c){
        listaClientes.add(c);
        return true;
    }
    
    public ArrayList<Cliente> getClientes(){
        return this.listaClientes;
    }
    
    public boolean AtualizarCliente(Cliente c){
        for(Cliente item: listaClientes){
            if(item.getId() == c.getId()){
                item.setNome(c.getNome());
                item.setCPF(c.getCPF());
            }
        }
        
        return true;
    }
    
    public boolean ExcluirCliente(int i){
        Cliente clienteExcluir = new Cliente();
        boolean existeNaLista = false;
        for(Cliente c: listaClientes){
            if(c.getId() == i){
                clienteExcluir = c;
                existeNaLista = true;
            }
        }
        
        if(existeNaLista)
                listaClientes.remove(clienteExcluir);
        
        return true;
    }
}
