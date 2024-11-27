package ucsal.cauzy.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import ucsal.cauzy.domain.entity.LogAcoes;
import ucsal.cauzy.domain.repository.LogAcoesRepository;

@Service
public class LogAcoesService extends BaseService<LogAcoes, Integer> {

    @Autowired
    private LogAcoesRepository logAcoesRepository;

    @Override
    protected JpaRepository<LogAcoes, Integer> getRepository() {
        return logAcoesRepository;
    }
}

