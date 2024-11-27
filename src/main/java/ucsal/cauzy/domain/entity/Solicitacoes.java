package ucsal.cauzy.domain.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "solicitacoes")
public class Solicitacoes implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idsolicitacoes;

    @Column(name = "data_hora_solicitacao", nullable = false)
    private LocalDateTime dataHoraSolicitacao;

    @Column(name = "data_hora_aprovacao", nullable = true)
    private LocalDateTime dataHoraAprovacao;

    @Column(name = "data_hora_locacao" , nullable = false) 
    private LocalDateTime dataHoraLocacao;

    @ManyToOne
    @JoinColumn(name = "idusuario_avaliador", nullable = true)
    private Usuario usuarioAvaliador;

    @ManyToOne
    @JoinColumn(name = "idusuario_solicitante", nullable = false)
    private Usuario usuarioSolicitante;

    @ManyToOne
    @JoinColumn(name = "idespacofisico", nullable = false)
    private EspacoFisico espacoFisico;

    @ManyToOne
    @JoinColumn(name = "idstatus", nullable = false)
    private Status status;

    public Integer getIdsolicitacoes() {
        return idsolicitacoes;
    }

    public void setIdsolicitacoes(Integer idsolicitacoes) {
        this.idsolicitacoes = idsolicitacoes;
    }

    public LocalDateTime getDataHoraSolicitacao() {
        return dataHoraSolicitacao;
    }

    public void setDataHoraSolicitacao(LocalDateTime dataHoraSolicitacao) {
        this.dataHoraSolicitacao = dataHoraSolicitacao;
    }

    public LocalDateTime getDataHoraAprovacao() {
        return dataHoraAprovacao;
    }

    public void setDataHoraAprovacao(LocalDateTime dataHoraAprovacao) {
        this.dataHoraAprovacao = dataHoraAprovacao;
    }

    public LocalDateTime getDataHoraLocacao() { // Getter da nova coluna
        return dataHoraLocacao;
    }

    public void setDataHoraLocacao(LocalDateTime dataHoraLocacao) { // Setter da nova coluna
        this.dataHoraLocacao = dataHoraLocacao;
    }

    public Usuario getUsuarioAvaliador() {
        return usuarioAvaliador;
    }

    public void setUsuarioAvaliador(Usuario usuarioAvaliador) {
        this.usuarioAvaliador = usuarioAvaliador;
    }

    public Usuario getUsuarioSolicitante() {
        return usuarioSolicitante;
    }

    public void setUsuarioSolicitante(Usuario usuarioSolicitante) {
        this.usuarioSolicitante = usuarioSolicitante;
    }

    public EspacoFisico getEspacoFisico() {
        return espacoFisico;
    }

    public void setEspacoFisico(EspacoFisico espacoFisico) {
        this.espacoFisico = espacoFisico;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Solicitacoes [idsolicitacoes=" + idsolicitacoes + ", dataHoraSolicitacao=" + dataHoraSolicitacao
                + ", dataHoraAprovacao=" + dataHoraAprovacao + ", dataHoraLocacao=" + dataHoraLocacao
                + ", usuarioAvaliador=" + usuarioAvaliador + ", usuarioSolicitante=" + usuarioSolicitante
                + ", espacoFisico=" + espacoFisico + ", status=" + status + "]";
    }
}
