package ucsal.cauzy.domain.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "log_acoes")
public class LogAcoes implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idlogacoes;

    @Column(name = "data_hora", nullable = false)
    private LocalDateTime dataHora;

    @ManyToOne
    @JoinColumn(name = "idusuario", nullable = false)
    private Usuario usuario;

    @Column(name = "acao", nullable = false, length = 255)
    private String acao;

	public Integer getIdlogacoes() {
		return idlogacoes;
	}

	public void setIdlogacoes(Integer idlogacoes) {
		this.idlogacoes = idlogacoes;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getAcao() {
		return acao;
	}

	public void setAcao(String acao) {
		this.acao = acao;
	}

	@Override
	public String toString() {
		return "LogAcoes [idlogacoes=" + idlogacoes + ", dataHora=" + dataHora + ", usuario=" + usuario + ", acao="
				+ acao + "]";
	}
}

