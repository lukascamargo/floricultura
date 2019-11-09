package lojafloricultura.model;

/**
 *
 * @author ifreitas
 */
public class Produto {
    
    private int id;
    private int quantidade;
    private float valor;
    private String nome;
    private String descricao;

    public int getId() {
        return id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public float getValor() {
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

    public void setValor(float valor) {
        this.valor = valor;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
    
    
    
    
}
