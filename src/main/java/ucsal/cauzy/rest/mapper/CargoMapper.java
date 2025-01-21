package ucsal.cauzy.rest.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ucsal.cauzy.domain.entity.Cargo;
import ucsal.cauzy.rest.dto.CargoDTO;

@Mapper(componentModel = "spring")
public interface CargoMapper {

    CargoDTO toDTO(Cargo cargo);

    Cargo toEntity(CargoDTO cargoDTO);
}
