
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojafloricultura.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import lojafloricultura.DAO.ClienteDAO;
import lojafloricultura.model.Cliente;

/**
 *
 * @author ifreitas
 */
public class ClienteController {
    public static boolean salvar(String pNome, String pCPF, String pEmail,
            String pEndereco,String pNumero, String pComplemento, String pSexo,
            String pEstadoCivil, String pDataNasc, String pTelefone){
        
        Cliente c = new Cliente(pNome, pCPF, pEmail, pEndereco, pNumero,
        pComplemento, pSexo, pEstadoCivil, pDataNasc, pTelefone);
        return ClienteDAO.salvar(c);
    }
    
    public static boolean atualizar(int ID, String pNome, String pCPF, String pEmail,
            String pEndereco,String pNumero, String pComplemento, String pSexo,
            String pEstadoCivil, String pDataNasc, String pTelefone){
        
        Cliente c = new Cliente(ID, pNome, pCPF, pEmail, pEndereco, pNumero,
        pComplemento, pSexo, pEstadoCivil, pDataNasc, pTelefone);
        return ClienteDAO.atualizar(c);
        
    }
    
    public static boolean excluir(int ID){
        
        return ClienteDAO.excluir(ID);
    }
    
    public static ArrayList<String[]> getClientes() {
        ArrayList<Cliente> cliente = ClienteDAO.getClientes();
        ArrayList<String[]> clientePesquisado = new ArrayList<>();
        
        
        for(int i = 0; i < cliente.size(); i ++){
        clientePesquisado.add(new String[]{
            String.valueOf(cliente.get(i).getId()),cliente.get(i).getNome(),
            cliente.get(i).getEmail(),cliente.get(i).getEndereco(),
            String.valueOf(cliente.get(i).getNumero()),cliente.get(i).getComplemento(),
            cliente.get(i).getSexo(),cliente.get(i).getEstadoCivil(),
            String.valueOf(cliente.get(i).getDataNasc()),String.valueOf(cliente.get(i).getTelefone())
        })
        ;}
        return clientePesquisado;
    }
    
    public static ArrayList<String[]> getClienteByCPF(String CPF)throws SQLException, ClassNotFoundException{
        
        ArrayList<Cliente> cliente = ClienteDAO.getClienteByCPF(CPF);
        ArrayList<String[]> clientePesquisado = new ArrayList<>();
        
        
        for(int i = 0; i < cliente.size(); i ++){
        clientePesquisado.add(new String[]{
            String.valueOf(cliente.get(i).getId()),cliente.get(i).getNome(),
            cliente.get(i).getEmail(),cliente.get(i).getEndereco(),
            String.valueOf(cliente.get(i).getNumero()),cliente.get(i).getComplemento(),
            cliente.get(i).getSexo(),cliente.get(i).getEstadoCivil(),
            String.valueOf(cliente.get(i).getDataNasc()),String.valueOf(cliente.get(i).getTelefone())
        })
        ;}
        
        
        
        return clientePesquisado;
    }
    
    public static Cliente getClienteByCpfForBuy(String cpf){
        Cliente clientePesquisado = ClienteDAO.getClienteByCpfForBuy(cpf);
        return clientePesquisado;
    }
    
    public static Cliente getClienteByNome(String nome){
        Cliente clientePesquisado = ClienteDAO.getClienteByNome(nome);
        return clientePesquisado;
    }
    
    public static Cliente getClienteById(int id){
        Cliente clientePesquisado = ClienteDAO.getClienteById(id);
        return clientePesquisado;
    }
}
