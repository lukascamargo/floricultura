/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojafloricultura.model;

/**
 *
 * @author lukas.camargo
 */
public class ItemVenda {
    
    private int id;
    private int produtoId;
    private int vendaId;
    private int quantidade;
    private double precoUnitario;
    private double precoTotal;
    
    /**
     * 
     * Contrutor da Classe, para adicionar itens á compra
     * 
     * @author lukas.fialho, Italo
     * 
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    public ItemVenda(){}
    
    /**
     * 
     * Contrutor da Classe, para adicionar itens á compra
     * 
     * @author lukas.fialho, Italo
     * @param pId int - Id do Produto 
     * @param vId int - Id da Compra
     * @param iQuantidade int - Quantidade do Produto
     * @param iUnitario double - Valor Unitário
     * @param iTotal double - Total da Compra
     * 
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    public ItemVenda(int pId, int vId, int iQuantidade, double iUnitario, double iTotal){
        this.produtoId = pId;
        this.vendaId = vId;
        this.quantidade = iQuantidade;
        this.precoUnitario = iUnitario;
        this.precoTotal = iTotal;
    }
    
    /**
     * 
     * Contrutor da Classe, para adicionar itens á compra
     * 
     * @author lukas.fialho, Italo
     * @param iId int - 
     * @param pId int - Id do Produto 
     * @param vId int - Id da Compra
     * @param iQuantidade int - Quantidade do Produto
     * @param iUnitario double - Valor Unitário
     * @param iTotal double - Total da Compra
     * 
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    public ItemVenda(int iId, int pId, int vId, int iQuantidade, double iUnitario, double iTotal){
        this.id = iId;
        this.produtoId = pId;
        this.vendaId = vId;
        this.quantidade = iQuantidade;
        this.precoUnitario = iUnitario;
        this.precoTotal = iTotal;
    }

    /**
     * 
     * Método para obter o valor da propriedade
     * 
     * @author lukas.fialho, Italo
     * @return int
     * 
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    public int getId() {
        return id;
    }

    /**
     * 
     * Método para obter o valor da propriedade
     * 
     * @author lukas.fialho, Italo
     * @return int
     * 
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    public int getProdutoId() {
        return produtoId;
    }
    
    /**
     * 
     * Método para obter o valor da propriedade
     * 
     * @author lukas.fialho, Italo
     * @return int
     * 
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    public int getVendaId(){
        return vendaId;
    }

    /**
     * 
     * Método para obter o valor da propriedade
     * 
     * @author lukas.fialho, Italo
     * @return int
     * 
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * 
     * Método para obter o valor da propriedade
     * 
     * @author lukas.fialho, Italo
     * @return double
     * 
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    public double getPrecoUnitario() {
        return precoUnitario;
    }

    /**
     * 
     * Método para obter o valor da propriedade
     * 
     * @author lukas.fialho, Italo
     * @return double
     * 
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    public double getPrecoTotal() {
        return precoTotal;
    }

    /**
     * 
     * Método para setar o valor da propriedade
     * 
     * @author lukas.fialho, Italo
     * @param id int
     * 
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 
     * Método para setar o valor da propriedade
     * 
     * @author lukas.fialho, Italo
     * @param produtoId int - Id do Produto
     * 
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    public void setProdutoId(int produtoId) {
        this.produtoId = produtoId;
    }
    
    /**
     * 
     * Método para setar o valor da propriedade
     * 
     * @author lukas.fialho, Italo
     * @param vendaId int - Id da Venda
     * 
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    public void setVendaId(int vendaId){
        this.vendaId = vendaId;
    }

    /**
     * 
     * Método para setar o valor da propriedade
     * 
     * @author lukas.fialho, Italo
     * @param quantidade int - Quantidade do Produto
     * 
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * 
     * Método para setar o valor da propriedade
     * 
     * @author lukas.fialho, Italo
     * @param precoUnitario double - Preço unitário do Produto
     * 
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    /**
     * 
     * Método para setar o valor da propriedade
     * 
     * @author lukas.fialho, Italo
     * @param precoTotal double - Preço total da Compra
     * 
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    public void setPrecoTotal(double precoTotal) {
        this.precoTotal = precoTotal;
    }
}
