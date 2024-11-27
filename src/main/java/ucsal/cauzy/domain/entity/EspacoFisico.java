package ucsal.cauzy.domain.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "espaco_fisico")
public class EspacoFisico implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEspacoFisico;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal metragem;

    @ManyToOne
    @JoinColumn(name = "idTipoSala", nullable = true)
    private TipoSala tipoSala;

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

	public TipoSala getTipoSala() {
		return tipoSala;
	}

	public void setTipoSala(TipoSala tipoSala) {
		this.tipoSala = tipoSala;
	}

	@Override
	public String toString() {
		return "EspacoFisico [idEspacoFisico=" + idEspacoFisico + ", metragem=" + metragem + ", tipoSala=" + tipoSala
				+ "]";
	}
	
}

