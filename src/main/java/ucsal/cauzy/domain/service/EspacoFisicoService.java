package ucsal.cauzy.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import ucsal.cauzy.domain.entity.EspacoFisico;
import ucsal.cauzy.domain.repository.EspacoFisicoRepository;

@Service
public class EspacoFisicoService extends BaseService<EspacoFisico, Integer> {

    @Autowired
    private EspacoFisicoRepository espacoFisicoRepository;

    @Override
    protected JpaRepository<EspacoFisico, Integer> getRepository() {
        return espacoFisicoRepository;
    }
}

