package ucsal.cauzy.rest.dto;

import java.math.BigDecimal;

public class EspacoFisicoDTO {

    private Integer idEspacoFisico;
    private BigDecimal metragem;
    private Integer idTipoSala;

    public Integer getIdEspacoFisico() {
        return idEspacoFisico;
    }

    public void setIdEspacoFisico(Integer idEspacoFisico) {
        this.idEspacoFisico = idEspacoFisico;
    }

    public BigDecimal getMetragem() {
        return metragem;
    }

    public void setMetragem(BigDecimal metragem) {
        this.metragem = metragem;
    }

    public Integer getIdTipoSala() {
        return idTipoSala;
    }

    public void setIdTipoSala(Integer idTipoSala) {
        this.idTipoSala = idTipoSala;
    }

    @Override
    public String toString() {
        return "EspacoFisicoDTO [idEspacoFisico=" + idEspacoFisico + ", metragem=" + metragem + ", idTipoSala=" + idTipoSala + "]";
    }
}
