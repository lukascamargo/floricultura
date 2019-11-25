/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojafloricultura.model;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author lukas.camargo
 */
public class Venda {
    
    private int codigo;
    private int cliente;
    private ArrayList<ItemVenda> produtos;
    private double valorTotal;
    private Date dataDaCompra;
    private Date dataAtualizacao;
    private int desconto;
    private String pagamento;

    /**
     * 
     * Método para setar o valor da propriedade
     * 
     * @author lukas.fialho, Italo
     * @param desconto int - Desconto
     * 
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    public void setDesconto(int desconto) {
        this.desconto = desconto;
    }

    /**
     * 
     * Método para setar o valor da propriedade
     * 
     * @author lukas.fialho, Italo
     * @param pagamento String - Forma de Pagamento
     * 
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    public void setPagamento(String pagamento) {
        this.pagamento = pagamento;
    }

    /**
     * 
     * Método para obter o valor da propriedade
     * 
     * @author lukas.fialho, Italo
     * @return  int
     * 
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    public int getDesconto() {
        return desconto;
    }

    /**
     * 
     * Método para obter o valor da propriedade
     * 
     * @author lukas.fialho, Italo
     * @return  String
     * 
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    public String getPagamento() {
        return pagamento;
    }

    /**
     * 
     * Método para obter o valor da propriedade
     * 
     * @author lukas.fialho, Italo
     * @return  int
     * 
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    public int getCodigo() {
        return codigo;
    }

    /**
     * 
     * Método para obter o valor da propriedade
     * 
     * @author lukas.fialho, Italo
     * @return  int
     * 
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    public int getCliente() {
        return cliente;
    }

    /**
     * 
     * Método para obter o valor da propriedade
     * 
     * @author lukas.fialho, Italo
     * @return  ItemVenda
     * 
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    public ArrayList<ItemVenda> getProdutos() {
        return produtos;
    }

    /**
     * 
     * Método para obter o valor da propriedade
     * 
     * @author lukas.fialho, Italo
     * @return  double
     * 
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    public double getValorTotal() {
        return valorTotal;
    }

    /**
     * 
     * Método para obter o valor da propriedade
     * 
     * @author lukas.fialho, Italo
     * @return  Date
     * 
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    public Date getDataDaCompra() {
        return dataDaCompra;
    }

    /**
     * 
     * Método para obter o valor da propriedade
     * 
     * @author lukas.fialho, Italo
     * @return Date
     * 
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }
    
    /**
     * 
     * Método para setar o valor da propriedade
     * 
     * @author lukas.fialho, Italo
     * @param codigo int - Código
     * 
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    public void setCodigo(int codigo){
        this.codigo = codigo;
    }

    /**
     * 
     * Método para setar o valor da propriedade
     * 
     * @author lukas.fialho, Italo
     * @param cliente int - Cliente
     * 
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    /**
     * 
     * Método para setar o valor da propriedade
     * 
     * @author lukas.fialho, Italo
     * @param produtos ItemVenda - Intens da compra
     * 
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    public void setProdutos(ArrayList<ItemVenda> produtos) {
        this.produtos = produtos;
    }

    /**
     * 
     * Método para setar o valor da propriedade
     * 
     * @author lukas.fialho, Italo
     * @param valorTotal double - Valor total da compra
     * 
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    /**
     * 
     * Método para setar o valor da propriedade
     * 
     * @author lukas.fialho, Italo
     * @param dataDaCompra Date - Data da Compra
     * 
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    public void setDataDaCompra(Date dataDaCompra) {
        this.dataDaCompra = dataDaCompra;
    }
    
    /**
     * 
     * Método para setar o valor da propriedade
     * 
     * @author lukas.fialho, Italo
     * @param dataAtualizacao Date - Data da atualização
     * 
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    public void setDataAtualizacao(Date dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }
    
    /**
     * 
     * Contrutor da Classe, para realizar vendas
     * 
     * @author lukas.fialho, Italo
     * 
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    public Venda(){}
    
    /**
     * 
     * Contrutor da Classe, para realizar vendas
     * 
     * @author lukas.fialho, Italo
     * @param cliente int - Cliente 
     * @param produtos ItemVenda - Lista de Produtos no carrinho
     * 
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    public Venda(int cliente, ArrayList<ItemVenda> produtos){
        this.cliente = cliente;
        this.produtos = produtos;
        
        for(int i = 0; i < produtos.size(); i++){
            this.valorTotal += produtos.get(i).getPrecoTotal();
        }
    }
    
    /**
     * 
     * Contrutor da Classe, para realizar vendas
     * 
     * @author lukas.fialho, Italo
     * @param cliente int - Cliente 
     * @param produtos ItemVenda - Lista de Produtos no carrinho
     * @param valor double - Valor do Produto 
     * 
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    public Venda(int cliente, ArrayList<ItemVenda> produtos, double valor){
        this.cliente = cliente;
        this.produtos = produtos;
        this.valorTotal = valor;
    }
    
    /**
     * 
     * Contrutor da Classe, para realizar vendas
     * 
     * @author lukas.fialho, Italo
     * @param codigo int - 
     * @param cliente int - Cliente 
     * @param produtos ItemVenda - Lista de Produtos no carrinho
     * @param valor double - Valor do Produto 
     * 
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    public Venda(int codigo, int cliente, ArrayList<ItemVenda> produtos, double valor){
        this.codigo = codigo;
        this.cliente = cliente;
        this.produtos = produtos;
        this.valorTotal = valor;
    }
}
