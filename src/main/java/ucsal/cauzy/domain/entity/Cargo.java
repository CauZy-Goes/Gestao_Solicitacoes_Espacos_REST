package ucsal.cauzy.domain.entity;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cargo")
public class Cargo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idcargo;

    @Column(name = "nome_cargo", nullable = false, length = 50)
    private String nomeCargo;

	public Integer getIdcargo() {
		return idcargo;
	}

	public void setIdcargo(Integer idcargo) {
		this.idcargo = idcargo;
	}

	public String getNomeCargo() {
		return nomeCargo;
	}

	public void setNomeCargo(String nomeCargo) {
		this.nomeCargo = nomeCargo;
	}

	@Override
	public String toString() {
		return "Cargo [idcargo=" + idcargo + ", nomeCargo=" + nomeCargo + "]";
	}
	
	
}

