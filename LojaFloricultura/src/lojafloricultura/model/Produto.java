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
    
    /**
     * 
     * Construtor utilizado para iniciar um novo Objeto sem passar parametro nenhum
     * 
     * @author lukas.fialho
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    public Produto(){}
    
    /**
     * 
     * Este construtor é bastante utilizado nos casos de atualização de um Objeto de Produto
     * 
     * @author lukas.fialho
     * @param id - ID do Produto (int)
     * @param nome - Nome do Produto (string)
     * @param quantidade - Quantidade do Produto (jnt)
     * @param valor - Valor do Produto (double)
     * @param descricao - Descricao do Produto (string)
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    public Produto(int id, String nome, int quantidade, double valor, String descricao){
        this.id = id;
        this.nome = nome;
        this.quantidade = quantidade;
        this.valor = valor;
        this.descricao = descricao;
    }
    
    /**
     * Este construtor deve ser utilizado na criação de um Objeto de Produto
     * @author lukas.fialho
     * @param nome - Nome do Produto (string)
     * @param quantidade - Quantidade do Produto (int)
     * @param valor - Valor do Produto (double)
     * @param descricao - Descricao do Produto (descricao)
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    public Produto(String nome, int quantidade, double valor, String descricao){
        this.nome = nome;
        this.quantidade = quantidade;
        this.valor = valor;
        this.descricao = descricao;
    }   

    /**
     * Getter de ID
     * @author lukas.fialho
     * @return int ID
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    public int getId() {
        return id;
    }

    /**
     * Getter de Quantidade
     * @author lukas.fialho
     * @return int quantidade
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * Getter de Valor
     * @author lukas.fialho
     * @return double valor
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    public double getValor() {
        return valor;
    }

    /**
     *  Getter de Nome
     * @author lukas.fialho
     * @return String nome
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    public String getNome() {
        return nome;
    }

    /**
     * Getter de Descricao
     * @author lukas.fialho
     * @return String descricao
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    public String getDescricao() {
        return descricao;
    }
    
    /**
     * Setter de ID
     * @author lukas.fialho
     * @version 1.0
     * @param pId - Integer
     * @since 18 de Novembro (Javadoc)
    */
    public void setId(int pId){
        this.id = pId;
    }

    /**
     * Setter de Quantidade
     * @author lukas.fialho
     * @param quantidade int
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * Setter de Valor
     * @author lukas.fialho
     * @param valor -  Double
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    public void setValor(double valor) {
        this.valor = valor;
    }

    /**
     * Setter de Nome
     * @author lukas.fialho
     * @param nome - String
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Setter de Descricao
     * @author lukas.fialho
     * @param descricao - String
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
    
    
    
    
}
