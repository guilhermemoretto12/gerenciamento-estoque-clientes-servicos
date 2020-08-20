
package pojo;


public class Servico {
    private static Integer idServico;
    private String dataServico;
    private String descricao;
    private Cliente idCliente;
    private Medico idMedico; 
    private Integer statusServico;
    private String nomeMedico;
    private String nomeCliente;
    private Integer refServico;


    public static Integer getIdServico() {
        return idServico;
    }
    public static void setIdServico(Integer idServico) {
        Servico.idServico = idServico;
    }

    public String getDataServico() {
        return dataServico;
    }
    public void setDataServico(String dataServico) {
        this.dataServico = dataServico;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public Medico getIdMedico() {
        return idMedico;
    }
    public void setIdMedico(Medico idMedico) {
        this.idMedico = idMedico;
    }
    
    public Integer getStatusServico() {
        return statusServico;
    }
    public void setStatusServico(Integer statusServico) {
        this.statusServico = statusServico;
    }
    
    public String getNomeMedico() {
        return nomeMedico;
    }
    public void setNomeMedico(String nomeMedico) {
        this.nomeMedico = nomeMedico;
    }   
    
    public String getNomeCliente() {
        return nomeCliente;
    }
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }
    
    public Integer getRefServico() {
        return refServico;
    }
    public void setRefServico(Integer refServico) {
        this.refServico = refServico;
    }
}
