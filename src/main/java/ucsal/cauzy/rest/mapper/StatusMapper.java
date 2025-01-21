package ucsal.cauzy.rest.mapper;

import org.mapstruct.Mapper;
import ucsal.cauzy.domain.entity.Status;
import ucsal.cauzy.rest.dto.StatusDTO;

@Mapper(componentModel = "spring")
public interface StatusMapper {

    StatusDTO toDTO(Status status);

    Status toEntity(StatusDTO statusDTO);
}
