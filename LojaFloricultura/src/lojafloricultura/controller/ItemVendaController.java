/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojafloricultura.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import lojafloricultura.model.ItemVenda;
import lojafloricultura.model.Produto;
import lojafloricultura.DAO.ProdutoDAO;
import lojafloricultura.DAO.ItemVendaDAO;
/**
 *
 * @author lukas.camargo
 */
public class ItemVendaController {
    ProdutoController produtoController = new ProdutoController();
    
    /**
     * 
     * Método para finalizar uma venda 
     * 
     * @author lukas.fialho, Italo
     * @param produtoId int - ID do Produto
     * @param vendaId int - ID da Venda
     * @param quantidade int - Quantidade do Item 
     * @param precoUnitario double - Preço unitário do Produto
     * @param precoTotal double - Preço total do Produto
     * 
     * @return ItemVenda
     * @throws SQLException - Caso tenha alguma exceção de SQL na ProdutoDAO
     * @throws ClassNotFoundException - Caso tenha algum problema ao usar a classe de conexão com o SQL na ProdutoDAO
     * 
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    public ItemVenda criarItemVenda(int produtoId, int vendaId, int quantidade, 
            double precoUnitario, double precoTotal) throws SQLException, ClassNotFoundException {
        ArrayList<String[]> itemVendaLista = new ArrayList<>();
        ItemVenda itemVenda = new ItemVenda(
                produtoId,
                vendaId,
                quantidade,
                precoUnitario,
                precoTotal
        );
        ItemVenda novoItem;
       
        
        Produto produto = buscarProduto(produtoId);
        
        if(produto.getQuantidade() >= quantidade && quantidade >= 0){
            novoItem = ItemVendaDAO.salvar(itemVenda);
            
            //Retirar Quantidade do Produto de Estoque
            RetirarQuantidadeProduto(produtoId, quantidade);
            
            System.out.println("Novo Item Venda" + novoItem);
            
            itemVendaLista.add(new String[]{
                String.valueOf(novoItem.getId()),
                String.valueOf(novoItem.getProdutoId()),
                produto.getNome(),
                String.valueOf(novoItem.getQuantidade()),
                String.valueOf(novoItem.getPrecoUnitario()),
                String.valueOf(novoItem.getPrecoTotal())
            });
            
        } else if(quantidade < 0) {
            throw new Error("Quantidade não pode ser menor que zero");
        } else {
            throw new Error("Quantidade não pode ser maior do que a disponível em Estoque");
        }
        
        return novoItem;
    } 
    
    /**
     * 
     * Método para excluir Item da venda 
     * 
     * @author lukas.fialho, Italo
     * @param itemId int - ID da Venda
     * @param produtoId int - ID do Produto
     * @param quantidade int - Quantidade do Item
     * 
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    public void excluirItemVenda(int itemId, int produtoId, int quantidade){
        ItemVendaDAO.excluir(itemId);
        AdicionarQuantidadeProduto(produtoId, quantidade);
    }
    
    /**
     * 
     * Método para buscar Produto para adicionar ao Carrinho de Compra
     * 
     * @author lukas.fialho, Italo
     * @param produtoId int - ID do Produto
     * 
     * @return Produto
     * 
     * @throws SQLException - Caso tenha alguma exceção de SQL na ProdutoDAO
     * @throws ClassNotFoundException - Caso tenha algum problema ao usar a classe de conexão com o SQL na ProdutoDAO
     * 
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    public Produto buscarProduto(int produtoId)  throws SQLException, ClassNotFoundException{
        Produto produto = ProdutoDAO.getProdutoById(produtoId);
        System.out.println(produto);
        return produto;
    }
    
    /**
     * 
     * Método para buscar Produto para adicionar ao Carrinho de Compra
     * 
     * @author lukas.fialho, Italo
     * @param vendaId int - ID da Venda
     * @return String[]
     * 
     * @since 18 de Novembro (Javadoc)
    */
    public ArrayList<String[]> buscarItens(int vendaId){
        ArrayList<ItemVenda> itens = ItemVendaDAO.getItensPorVendaId(vendaId);
        ArrayList<String[]> listaItens = new ArrayList<>();
        
        for(int i = 0; i < itens.size(); i++){
            try {
                listaItens.add(new String[]{
                    String.valueOf(itens.get(i).getId()),
                    String.valueOf(itens.get(i).getProdutoId()),
                    this.buscarProduto(itens.get(i).getProdutoId()).getNome(),
                    String.valueOf(itens.get(i).getQuantidade()),
                    String.valueOf(itens.get(i).getPrecoUnitario()),
                    String.valueOf(itens.get(i).getPrecoTotal())
                });
            } catch (SQLException ex) {
                Logger.getLogger(ItemVendaController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ItemVendaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return listaItens;
    }
    
    /**
     * 
     * Método para buscar o valor total da Compra
     * 
     * @author lukas.fialho, Italo
     * @param vendaId int - ID da Venda
     * @return double
     * 
     * @since 18 de Novembro (Javadoc)
    */
    public double buscarValorTotal(int vendaId){
        ArrayList<ItemVenda> itens = ItemVendaDAO.getItensPorVendaId(vendaId);
        double total = 0;
        
        for(int i = 0; i < itens.size(); i++){
            total += itens.get(i).getPrecoTotal();
        }
        
        return total;
    }
    
    /**
     * 
     * Método para subtrair a quantidade de Produto no estoque, de acordo com a 
     * quantidade adicionada no carrinho
     * 
     * @author lukas.fialho, Italo
     * @param produtoId int - ID do Produto
     * @param quantidadeSolicitada int - Quantidade
     * 
     * @since 18 de Novembro (Javadoc)
    */
    public void RetirarQuantidadeProduto(int produtoId, int quantidadeSolicitada){
        try {
            Produto produto = ProdutoDAO.getProdutoById(produtoId);
            
            produto.setQuantidade(produto.getQuantidade() - quantidadeSolicitada);
            
            ProdutoDAO.atualizar(produto);
            
        } catch (SQLException ex) {
            Logger.getLogger(ItemVendaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ItemVendaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * 
     * Método para adicionar a quantidade de Produto no estoque, de acordo com a 
     * quantidade passada por parâmetro
     * 
     * @author lukas.fialho, Italo
     * @param produtoId int - ID do Produto
     * @param quantidadeDevolvida int - Quantidade
     * 
     * @since 18 de Novembro (Javadoc)
    */
    public void AdicionarQuantidadeProduto(int produtoId, int quantidadeDevolvida){
        try {
            Produto produto = ProdutoDAO.getProdutoById(produtoId);
            
            produto.setQuantidade(produto.getQuantidade() + quantidadeDevolvida);
            
            ProdutoDAO.atualizar(produto);
            
        } catch (SQLException ex) {
            Logger.getLogger(ItemVendaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ItemVendaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
