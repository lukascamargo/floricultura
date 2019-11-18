package lojafloricultura.model;

/**
 *
 * @author ifreitas
 */
public class Produto {
    
    private int id;
    private int quantidade;
    private double valor;
    private String nome;
    private String descricao;
    
    public Produto(){}
    
    public Produto(int id, String nome, int quantidade, double valor, String descricao){
        this.id = id;
        this.nome = nome;
        this.quantidade = quantidade;
        this.valor = valor;
        this.descricao = descricao;
    }
    
    public Produto(String nome, int quantidade, double valor, String descricao){
        this.nome = nome;
        this.quantidade = quantidade;
        this.valor = valor;
        this.descricao = descricao;
    }   
    

    public int getId() {
        return id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getValor() {
        return valor;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
    
    public void setId(int pId){
        this.id = pId;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
    
    
    
    
}
