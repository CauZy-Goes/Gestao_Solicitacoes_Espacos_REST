package ucsal.cauzy.rest.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ucsal.cauzy.domain.entity.Usuario;
import ucsal.cauzy.rest.dto.UsuarioDTO;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    @Mapping(source = "cargo.idCargo", target = "idCargo")
    @Mapping(source = "senha", target = "senha")
    UsuarioDTO toDTO(Usuario usuario);

    @Mapping(source = "idCargo", target = "cargo.idCargo")
    @Mapping(source = "senha", target = "senha")
    Usuario toEntity(UsuarioDTO usuarioDTO);
}
