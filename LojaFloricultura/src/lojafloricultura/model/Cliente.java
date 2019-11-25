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

    /**
     * 
     * Método para obter o valor da propriedade
     * 
     * @author lukas.fialho, Italo
     * @return String
     * 
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    public String getEstadoCivil() {
        return estadoCivil;
    }

    /**
     * 
     * Método para setar o valor da propriedade
     * 
     * @author lukas.fialho, Italo
     * @param estadoCivil String - Estado Civil
     * 
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    /**
     * 
     * Método para obter o valor da propriedade
     * 
     * @author lukas.fialho, Italo
     * @return String
     * 
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    public String getDataNasc() {
        return dataNasc;
    }

    /**
     * 
     * Método para setar o valor da propriedade
     * 
     * @author lukas.fialho, Italo
     * @param dataNasc String - Data de Nascimento
     * 
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    /**
     * 
     * Método para obter o valor da propriedade
     * 
     * @author lukas.fialho, Italo
     * @return String
     * 
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    public String getTelefone() {
        return telefone;
    }

    /**
     * 
     * Método para setar o valor da propriedade
     * 
     * @author lukas.fialho, Italo
     * @param telefone String - Número de Telefone
     * 
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    private String dataNasc;
    private String telefone;

    /**
     * 
     * Contrutor da Classe, para adicionar Clientes ao sistema
     * 
     * @author lukas.fialho, Italo
     * 
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    public Cliente(){
        this.id = qtdClientesCriados;
    } 
    
    /**
     * 
     * Contrutor da Classe, para adicionar Clientes ao sistema
     * 
     * @author lukas.fialho, Italo
     * @param nome String - Nome do Cliente
     * @param CPF String - CPF do Cliente
     * @param email String - Email do Cliente
     * @param endereco String - Endereço do Cliente 
     * @param numero String - Número do Endereço 
     * @param complemento String - Complemento do Endereço
     * @param sexo String - Genero do Cliente
     * @param estadoCivil String - Estado Civil do Cliente
     * @param dataNasc String - Data de Nascimento do Cliente
     * @param telefone String - Telefone do Cliente
     * 
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    public Cliente(String nome, String CPF, String email, String endereco, 
            String numero, String complemento, String sexo, String estadoCivil, 
            String dataNasc, String telefone) {
        
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

    /**
     * 
     * Contrutor da Classe, para adicionar Clientes ao sistema
     * 
     * @author lukas.fialho, Italo
     * @param id int - Id da Compra
     * @param nome String - Nome do Cliente
     * @param CPF String - CPF do Cliente
     * @param email String - Email do Cliente
     * @param endereco String - Endereço do Cliente 
     * @param numero String - Número do Endereço 
     * @param complemento String - Complemento do Endereço
     * @param sexo String - Genero do Cliente
     * @param estadoCivil String - Estado Civil do Cliente
     * @param dataNasc String - Data de Nascimento do Cliente
     * @param telefone String - Telefone do Cliente
     * 
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    public Cliente(int id, String nome, String CPF, String email, String endereco, 
            String numero, String complemento, String sexo, String estadoCivil, 
            String dataNasc, String telefone) {
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
     * Método para setar o valor da propriedade
     * 
     * @author lukas.fialho, Italo
     * @param id int - Id da Compra
     * 
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * 
     * Método para obter o valor da propriedade
     * 
     * @author lukas.fialho, Italo
     * @return String
     * 
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    public String getNome(){
        return nome;
    }
    
    /**
     * 
     * Método para setar o valor da propriedade
     * 
     * @author lukas.fialho, Italo
     * @param n String - Nome do Cliente
     * 
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    public void setNome(String n){
        this.nome = n;
    }

    /**
     * 
     * Método para obter o valor da propriedade
     * 
     * @author lukas.fialho, Italo
     * @return String
     * 
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    public String getCPF() {
        return CPF;
    }

    /**
     * 
     * Método para setar o valor da propriedade
     * 
     * @author lukas.fialho, Italo
     * @param CPF String - CPF do Cliente
     * 
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    /**
     * 
     * Método para obter o valor da propriedade
     * 
     * @author lukas.fialho, Italo
     * @return String
     * 
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    public String getEmail() {
        return email;
    }

    /**
     * 
     * Método para setar o valor da propriedade
     * 
     * @author lukas.fialho, Italo
     * @param email String - Email do Cliente
     * 
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    public void setEmail(String email) {
        this.email = email;
    }
    
    /**
     * 
     * Método para obter o valor da propriedade
     * 
     * @author lukas.fialho, Italo
     * @return String
     * 
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    public String getEndereco() {
        return endereco;
    }

    /**
     * 
     * Método para setar o valor da propriedade
     * 
     * @author lukas.fialho, Italo
     * @param endereco String - Enderecço do Cliente
     * 
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * 
     * Método para obter o valor da propriedade
     * 
     * @author lukas.fialho, Italo
     * @return String
     * 
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    public String getNumero() {
        return numero;
    }

    /**
     * 
     * Método para setar o valor da propriedade
     * 
     * @author lukas.fialho, Italo
     * @param numero String - Número do Enderecço do Cliente
     * 
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * 
     * Método para obter o valor da propriedade
     * 
     * @author lukas.fialho, Italo
     * @return String
     * 
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    public String getComplemento() {
        return complemento;
    }

    /**
     * 
     * Método para setar o valor da propriedade
     * 
     * @author lukas.fialho, Italo
     * @param complemento String - Complemento do Enderecço do Cliente
     * 
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    /**
     * 
     * Método para obter o valor da propriedade
     * 
     * @author lukas.fialho, Italo
     * @return String
     * 
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    public String getSexo() {
        return sexo;
    }

    /**
     * 
     * Método para setar o valor da propriedade
     * 
     * @author lukas.fialho, Italo
     * @param sexo String - Genêro do Enderecço do Cliente
     * 
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
}
