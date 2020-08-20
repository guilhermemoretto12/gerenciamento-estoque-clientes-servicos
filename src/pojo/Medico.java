
package pojo;


public class Medico {
    private static Integer idMedico;
    private String nomeMedico;
    private Integer statusMedico;

    public static Integer getIdMedico() {
        return idMedico;
    }
    public static void setIdMedico(Integer idMedico) {
        Medico.idMedico = idMedico;
    }

    public String getNomeMedico() {
        return nomeMedico;
    }
    public void setNomeMedico(String nomeMedico) {
        this.nomeMedico = nomeMedico;
    }
    
    public Integer getStatusMedico() {
        return statusMedico;
    }
    public void setStatusMedico(Integer statusMedico) {
        this.statusMedico = statusMedico;
    }
}
