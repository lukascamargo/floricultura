package lojafloricultura.model;

/**
 *
 * @author ifreitas
 */
public class Cliente {
    private static int qtdClientesCriados;
    
    private int id;
    private String nome;
    private String CPF;
    private String email;
    private String endereco;
    private String numero;
    private String complemento;
    private String sexo;

    public Cliente(){
        //TODO: ao criar a conexão retirar incremento do código.
        qtdClientesCriados++;
        this.id = qtdClientesCriados;
    } 
    
    //construtor
    public Cliente(int id, String nome, String CPF, String endereco, String numero, String complemento, String sexo) {
        this.id = id;
        this.nome = nome;
        this.CPF = CPF;
        this.endereco = endereco;
        this.numero = numero;
        this.complemento = complemento;
        this.sexo = sexo;
    }
    
    /*
    * Métodos Getters e Setters das propriedades
    */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
}
