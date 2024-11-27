package ucsal.cauzy.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import ucsal.cauzy.domain.entity.Equipamento;
import ucsal.cauzy.domain.repository.EquipamentoRepository;

@Service
public class EquipamentoService extends BaseService<Equipamento, Integer> {

    @Autowired
    private EquipamentoRepository equipamentoRepository;

    @Override
    protected JpaRepository<Equipamento, Integer> getRepository() {
        return equipamentoRepository;
    }
}

