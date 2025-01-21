package ucsal.cauzy.rest.dto;

public class EquipamentoDTO {
    private Integer idEquipamento;
    private String nomeEquipamento;
    private Integer idEspacoFisico;

    public Integer getIdEquipamento() {
        return idEquipamento;
    }

    public void setIdEquipamento(Integer id) {
        this.idEquipamento = id;
    }

    public String getNomeEquipamento() {
        return nomeEquipamento;
    }

    public void setNomeEquipamento(String nomeEquipamento) {
        this.nomeEquipamento = nomeEquipamento;
    }

    public Integer getIdEspacoFisico() {
        return idEspacoFisico;
    }

    public void setIdEspacoFisico(Integer idEspacoFisico) {
        this.idEspacoFisico = idEspacoFisico;
    }
}
