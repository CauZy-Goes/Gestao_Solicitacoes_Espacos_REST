package ucsal.cauzy.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import ucsal.cauzy.domain.entity.TipoSala;
import ucsal.cauzy.domain.repository.TipoSalaRepository;

@Service
public class TipoSalaService extends BaseService<TipoSala, Integer> {

    @Autowired
    private TipoSalaRepository tipoSalaRepository;

    @Override
    protected JpaRepository<TipoSala, Integer> getRepository() {
        return tipoSalaRepository;
    }
}

