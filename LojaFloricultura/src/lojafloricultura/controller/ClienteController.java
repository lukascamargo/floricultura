
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
    /**
     * 
     * Método para salvar um novo Cliente
     * 
     * @author lukas.fialho, Italo
     * @param pNome String - Nome do Cliente
     * @param pCPF String - CPF do Cliente
     * @param pEmail String - Email do Cliente 
     * @param pEndereco String - Endereço
     * @param pNumero String - Número do Endereço 
     * @param pComplemento String - Complemento do Endereço
     * @param pSexo String - Genero do Cliente
     * @param pEstadoCivil String - Estado Civil do Cliente
     * @param pDataNasc String - Data de Nascimento do Cliente 
     * @param pTelefone String - Telefone do Cliente
     * 
     * @return boolean 
     * 
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    public static boolean salvar(String pNome, String pCPF, String pEmail,
            String pEndereco,String pNumero, String pComplemento, String pSexo,
            String pEstadoCivil, String pDataNasc, String pTelefone){
        
        Cliente c = new Cliente(pNome, pCPF, pEmail, pEndereco, pNumero,
        pComplemento, pSexo, pEstadoCivil, pDataNasc, pTelefone);
        return ClienteDAO.salvar(c);
    }
    
    /**
     * 
     * Método para editar as informações de um Cliente existente
     * 
     * @author lukas.fialho, Italo
     * @param ID int - ID do Cliente
     * @param pNome String - Nome do Cliente
     * @param pCPF String - CPF do Cliente
     * @param pEmail String - Email do Cliente 
     * @param pEndereco String - Endereço
     * @param pNumero String - Número do Endereço 
     * @param pComplemento String - Complemento do Endereço
     * @param pSexo String - Genero do Cliente
     * @param pEstadoCivil String - Estado Civil do Cliente
     * @param pDataNasc String - Data de Nascimento do Cliente 
     * @param pTelefone String - Telefone do Cliente
     * 
     * @return boolean 
     * 
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    public static boolean atualizar(int ID, String pNome, String pCPF, String pEmail,
            String pEndereco,String pNumero, String pComplemento, String pSexo,
            String pEstadoCivil, String pDataNasc, String pTelefone){
        
        Cliente c = new Cliente(ID, pNome, pCPF, pEmail, pEndereco, pNumero,
        pComplemento, pSexo, pEstadoCivil, pDataNasc, pTelefone);
        return ClienteDAO.atualizar(c);
    }
    
    /**
     * 
     * Método para excluir um Cliente
     * 
     * @author lukas.fialho, Italo
     * @param ID int - ID do Cliente
     * 
     * @return boolean 
     * 
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    public static boolean excluir(int ID){
        
        return ClienteDAO.excluir(ID);
    }
    
    /**
     * 
     * Método para buscar Clientes
     * 
     * @author lukas.fialho, Italo
     * 
     * @return ArrayList 
     * 
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
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
            });
        }
        return clientePesquisado;
    }
    
    /**
     * 
     * Método para buscar Clientes por CPF
     * 
     * @author lukas.fialho, Italo
     * @param CPF String - CPF do Cliente
     * 
     * @return ArrayList 
     * 
     * @throws SQLException - Caso tenha alguma exceção de SQL na ProdutoDAO
     * @throws ClassNotFoundException - Caso tenha algum problema ao usar a classe de conexão com o SQL na ProdutoDAO
     * 
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    public static ArrayList<String[]> getClienteByCPF(String CPF)throws SQLException, ClassNotFoundException{
        
        ArrayList<Cliente> cliente = ClienteDAO.getClienteByCPF(CPF.replace(".","").replace("-",""));
        ArrayList<String[]> clientePesquisado = new ArrayList<>();
        
        
        for(int i = 0; i < cliente.size(); i ++){
            clientePesquisado.add(new String[]{
                String.valueOf(cliente.get(i).getId()),cliente.get(i).getNome(),
                cliente.get(i).getEmail(),cliente.get(i).getEndereco(),
                String.valueOf(cliente.get(i).getNumero()),cliente.get(i).getComplemento(),
                cliente.get(i).getSexo(),cliente.get(i).getEstadoCivil(),
                String.valueOf(cliente.get(i).getDataNasc()),String.valueOf(cliente.get(i).getTelefone())
            });
        }
        
        return clientePesquisado;
    }
    
    /**
     * 
     * Método para buscar um Cliente por CPF
     * 
     * @author lukas.fialho, Italo
     * @param cpf String - CPF do Cliente
     * 
     * @return Cliente 
     * 
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    public static Cliente getClienteByCpfForBuy(String cpf){
        Cliente clientePesquisado = ClienteDAO.getClienteByCpfForBuy(cpf);
        return clientePesquisado;
    }
    
    /**
     * 
     * Método para buscar um Cliente por Nome
     * 
     * @author lukas.fialho, Italo
     * @param nome String - Nome do Cliente
     * 
     * @return Cliente 
     * 
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    public static Cliente getClienteByNome(String nome){
        Cliente clientePesquisado = ClienteDAO.getClienteByNome(nome);
        return clientePesquisado;
    }
    
    /**
     * 
     * Método para buscar um Cliente por Id
     * 
     * @author lukas.fialho, Italo
     * @param id int - Id do Cliente
     * 
     * @return Cliente 
     * 
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    public static Cliente getClienteById(int id){
        Cliente clientePesquisado = ClienteDAO.getClienteById(id);
        return clientePesquisado;
    }
}
