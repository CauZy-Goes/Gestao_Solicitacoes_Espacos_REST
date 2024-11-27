package ucsal.cauzy.domain.entity;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "equipamento")
public class Equipamento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idequipamento;

    @Column(name = "nome_equipamento", nullable = false, length = 255)
    private String nomeEquipamento;

    @ManyToOne
    @JoinColumn(name = "idespacofisico")
    private EspacoFisico espacoFisico;

	public Integer getIdequipamento() {
		return idequipamento;
	}

	public void setIdequipamento(Integer idequipamento) {
		this.idequipamento = idequipamento;
	}

	public String getNomeEquipamento() {
		return nomeEquipamento;
	}

	public void setNomeEquipamento(String nomeEquipamento) {
		this.nomeEquipamento = nomeEquipamento;
	}

	public EspacoFisico getEspacoFisico() {
		return espacoFisico;
	}

	public void setEspacoFisico(EspacoFisico espacoFisico) {
		this.espacoFisico = espacoFisico;
	}

	@Override
	public String toString() {
		return "Equipamento [idequipamento=" + idequipamento + ", nomeEquipamento=" + nomeEquipamento
				+ ", espacoFisico=" + espacoFisico + "]";
	}
}

