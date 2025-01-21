package ucsal.cauzy.rest.dto;

public class TipoSalaDTO {

    private Integer idTipoSala;
    private String nomeSala;

    public Integer getIdTipoSala() {
        return idTipoSala;
    }

    public void setIdTipoSala(Integer idTipoSala) {
        this.idTipoSala = idTipoSala;
    }

    public String getNomeSala() {
        return nomeSala;
    }

    public void setNomeSala(String nomeSala) {
        this.nomeSala = nomeSala;
    }

    @Override
    public String toString() {
        return "TipoSalaDTO [idTipoSala=" + idTipoSala + ", nomeSala=" + nomeSala + "]";
    }
}
