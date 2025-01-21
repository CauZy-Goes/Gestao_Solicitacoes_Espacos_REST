package ucsal.cauzy.rest.mapper;

import org.mapstruct.*;
import ucsal.cauzy.domain.entity.Equipamento;
import ucsal.cauzy.rest.dto.EquipamentoDTO;

@Mapper(componentModel = "spring")
public interface EquipamentoMapper {

    @Mapping(source = "idEquipamento", target = "idEquipamento")
    @Mapping(source = "espacoFisico.idEspacoFisico", target = "idEspacoFisico")
    EquipamentoDTO toDTO(Equipamento equipamento);

    @Mapping(source = "idEquipamento", target = "idEquipamento")
    @Mapping(source = "idEspacoFisico", target = "espacoFisico.idEspacoFisico")
    Equipamento toEntity(EquipamentoDTO equipamentoDTO);
}

