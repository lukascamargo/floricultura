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
    
    public ItemVenda(){}
    
    public ItemVenda(int pId, int vId, int iQuantidade, double iUnitario, double iTotal){
        this.produtoId = pId;
        this.vendaId = vId;
        this.quantidade = iQuantidade;
        this.precoUnitario = iUnitario;
        this.precoTotal = iTotal;
    }
    
    public ItemVenda(int iId, int pId, int vId, int iQuantidade, double iUnitario, double iTotal){
        this.id = iId;
        this.produtoId = pId;
        this.vendaId = vId;
        this.quantidade = iQuantidade;
        this.precoUnitario = iUnitario;
        this.precoTotal = iTotal;
    }

    public int getId() {
        return id;
    }

    public int getProdutoId() {
        return produtoId;
    }
    
    public int getVendaId(){
        return vendaId;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public double getPrecoTotal() {
        return precoTotal;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProdutoId(int produtoId) {
        this.produtoId = produtoId;
    }
    
    public void setVendaId(int vendaId){
        this.vendaId = vendaId;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public void setPrecoTotal(double precoTotal) {
        this.precoTotal = precoTotal;
    }
    
    
    
}
