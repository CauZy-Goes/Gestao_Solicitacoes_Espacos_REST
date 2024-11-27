package ucsal.cauzy.domain.entity;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tipo_sala")
public class TipoSala implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idtiposala;

    @Column(name = "nome_sala", nullable = false, length = 50)
    private String nomeSala;

	public Integer getIdtiposala() {
		return idtiposala;
	}

	public void setIdtiposala(Integer idtiposala) {
		this.idtiposala = idtiposala;
	}

	public String getNomeSala() {
		return nomeSala;
	}

	public void setNomeSala(String nomeSala) {
		this.nomeSala = nomeSala;
	}

	@Override
	public String toString() {
		return "TipoSala [idtiposala=" + idtiposala + ", nomeSala=" + nomeSala + "]";
	}

}

