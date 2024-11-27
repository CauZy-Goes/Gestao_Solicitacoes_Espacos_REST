package ucsal.cauzy.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import ucsal.cauzy.domain.entity.Solicitacoes;
import ucsal.cauzy.domain.repository.SolicitacoesRepository;

@Service
public class SolicitacoesService extends BaseService<Solicitacoes, Integer> {

    @Autowired
    private SolicitacoesRepository solicitacoesRepository;

    @Override
    protected JpaRepository<Solicitacoes, Integer> getRepository() {
        return solicitacoesRepository;
    }
}
