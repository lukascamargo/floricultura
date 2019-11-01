/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojafloricultura.model;
import lojafloricultura.model.Cliente;
import lojafloricultura.model.Produto;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author lukas.camargo
 */
public class Venda {
    
    private int codigo;
    private Cliente cliente;
    private ArrayList<Produto> produtos;
    private double valorTotal;
    private Date dataDaCompra;
    private Date dataAtualizacao;

    public int getCodigo() {
        return codigo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public Date getDataDaCompra() {
        return dataDaCompra;
    }

    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }
    
    public void setCodigo(int codigo){
        this.codigo = codigo;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public void setDataDaCompra(Date dataDaCompra) {
        this.dataDaCompra = dataDaCompra;
    }

    public void setDataAtualizacao(Date dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }
    
    public Venda(){}
    
    public Venda(Cliente cliente, ArrayList<Produto> produtos){
        this.cliente = cliente;
        this.produtos = produtos;
        
        for(int i = 0; i < produtos.size(); i++){
            this.valorTotal += produtos.get(i).getValor();
        }
    }
   
    
    public Venda(Cliente cliente, ArrayList<Produto> produtos, double valor){
        this.cliente = cliente;
        this.produtos = produtos;
        this.valorTotal = valor;
    }
    
    public Venda(int codigo, Cliente cliente, ArrayList<Produto> produtos, double valor){
        this.codigo = codigo;
        this.cliente = cliente;
        this.produtos = produtos;
        this.valorTotal = valor;
    } 
    
    
}
