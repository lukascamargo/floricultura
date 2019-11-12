
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojafloricultura.controller;

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
    
    public ArrayList<String[]> getClientes(){
        ArrayList<String[]> listaClientes = new ArrayList<>();
        
        return listaClientes;
    }
    
    public static String[] getClienteByCPF(String CPF){
        Cliente cliente = ClienteDAO.getClienteByCPF(CPF);
        String[] clientePesquisado = null;
        
        clientePesquisado = new String[]{cliente.getNome(),cliente.getCPF(),
        cliente.getEmail(), cliente.getEndereco(),cliente.getNumero(),
        cliente.getComplemento(),cliente.getSexo(),cliente.getEstadoCivil(),
        cliente.getDataNasc(),cliente.getTelefone()}
        ;
        
        
        
        return clientePesquisado;
    }
    
    public static Cliente getClienteByNome(String nome){
        Cliente clientePesquisado = ClienteDAO.getClienteByNome(nome);
        return clientePesquisado;
    }
}
