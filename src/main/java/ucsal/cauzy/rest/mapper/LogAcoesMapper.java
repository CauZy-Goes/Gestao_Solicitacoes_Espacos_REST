package ucsal.cauzy.rest.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ucsal.cauzy.domain.entity.LogAcoes;
import ucsal.cauzy.rest.dto.LogAcoesDTO;

@Mapper(componentModel = "spring")
public interface LogAcoesMapper {

    @Mapping(source = "usuario.idUsuario", target = "idUsuario")
    LogAcoesDTO toDTO(LogAcoes logAcoes);

    @Mapping(source = "idUsuario", target = "usuario.idUsuario")
    LogAcoes toEntity(LogAcoesDTO logAcoesDTO);
}
