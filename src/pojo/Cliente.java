
package pojo;

public class Cliente {
    private static Integer idCliente;
    private String nomeCliente;
    private String cpf;
    private String dataNascimento;
    private String telefone1;
    private String telefone2;
    private String estado;
    private String cidade;
    private String bairro;
    private String logradouro;
    private String numero;
    private String pais1;
    private String pais2;
    private Integer statusCliente;
    private String cep;
    private Integer codCliente;



    public static Integer getIdCliente() {
        return idCliente;
    }
    public static void setIdCliente(Integer idCliente) {
        Cliente.idCliente = idCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTelefone1() {
        return telefone1;
    }
    public void setTelefone1(String telefone1) {
        this.telefone1 = telefone1;
    }

    public String getTelefone2() {
        return telefone2;
    }
    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
    }

    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLogradouro() {
        return logradouro;
    }
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getPais1() {
        return pais1;
    }
    public void setPais1(String pais1) {
        this.pais1 = pais1;
    }

    public String getPais2() {
        return pais2;
    }
    public void setPais2(String pais2) {
        this.pais2 = pais2;
    }
    
    public Integer getStatusCliente() {
        return statusCliente;
    }
    public void setStatusCliente(Integer statusCliente) {
        this.statusCliente = statusCliente;
    } 
    
    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }
    
    public Integer getCodCliente() {
        return codCliente;
    }
    public void setCodCliente(Integer codCliente) {
        this.codCliente = codCliente;
    }
}
