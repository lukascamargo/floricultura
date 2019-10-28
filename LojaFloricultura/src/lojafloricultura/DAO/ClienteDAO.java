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
public class ClienteDAO {
    
    public static boolean salvar(Cliente c){
        return SimulaDBCliente.getInstance().SalvarCliente(c);
    }
    
    public static boolean atualizar(Cliente c){
        return SimulaDBCliente.getInstance().AtualizarCliente(c);
    }
    
    public static boolean excluir(int cID){
        return SimulaDBCliente.getInstance().ExcluirCliente(cID);
    }
    
    public static ArrayList<Cliente> getClientes(){
        return SimulaDBCliente.getInstance().getClientes();
    }
    
}
