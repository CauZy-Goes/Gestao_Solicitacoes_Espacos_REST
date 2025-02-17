package ucsal.cauzy.domain.entity;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;

    @Column(name = "nome_usuario", nullable = false, length = 255)
    private String nomeUsuario;

    @Column(name = "email", nullable = false, length = 255, unique = true)
    private String email;

	@ManyToOne
    @JoinColumn(name = "idcargo", nullable = false)
    private Cargo cargo;

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idusuario) {
		this.idUsuario = idusuario;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	@Override
	public String toString() {
		return "Usuario [idusuario=" + idUsuario + ", nomeUsuario=" + nomeUsuario + ", email=" + email + ", cargo="
				+ cargo + "]";
	}
    
}

