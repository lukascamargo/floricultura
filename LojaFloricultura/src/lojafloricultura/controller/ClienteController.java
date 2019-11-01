
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojafloricultura.controller;

import java.util.ArrayList;
import lojafloricultura.model.Cliente;

/**
 *
 * @author ifreitas
 */
public class ClienteController {
    public boolean salvar(){
        return true;
    }
    
    public boolean atualizar(){
        return true;
    }
    
    public boolean excluir(){
        return true;
    }
    
    public ArrayList<String[]> getClientes(){
        ArrayList<String[]> listaProdutos = new ArrayList<>();
        
        return listaProdutos;
    }
    
    public ArrayList<String[]> getClienteById(){
        ArrayList<String[]> produtoPesquisado = new ArrayList<>();
        
        return produtoPesquisado;
    }
    
    public ArrayList<String[]> getClienteByName(){
        ArrayList<String[]> produtoPesquisado = new ArrayList<>();
        
        return produtoPesquisado;
    }
}
