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
    private String estadoCivil;

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    private String dataNasc;
    private String telefone;

    public Cliente(){
        //TODO: ao criar a conexão retirar incremento do código.
        qtdClientesCriados++;
        this.id = qtdClientesCriados;
    } 
    
    //construtor
    public Cliente(String nome, String CPF, String email, String endereco, String numero, String complemento, String sexo,
            String estadoCivil, String dataNasc, String telefone) {
        
        this.nome = nome;
        this.CPF = CPF;
        this.email = email;
        this.endereco = endereco;
        this.numero = numero;
        this.complemento = complemento;
        this.sexo = sexo;
        this.estadoCivil = estadoCivil;
        this.dataNasc = dataNasc;
        this.telefone = telefone;
        
    }

    public Cliente(int id, String nome, String CPF, String email, String endereco, String numero, String complemento, String sexo, String estadoCivil, String dataNasc, String telefone) {
        this.id = id;
        this.nome = nome;
        this.CPF = CPF;
        this.email = email;
        this.endereco = endereco;
        this.numero = numero;
        this.complemento = complemento;
        this.sexo = sexo;
        this.estadoCivil = estadoCivil;
        this.dataNasc = dataNasc;
        this.telefone = telefone;
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
    
    public String getNome(){
        return nome;
    }
    
    public void setNome(String n){
        this.nome = n;
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
