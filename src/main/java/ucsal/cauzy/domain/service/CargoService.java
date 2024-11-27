package ucsal.cauzy.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import ucsal.cauzy.domain.entity.Cargo;
import ucsal.cauzy.domain.repository.CargoRepository;

@Service
public class CargoService extends BaseService<Cargo, Integer> {

    @Autowired
    private CargoRepository cargoRepository;

    @Override
    protected JpaRepository<Cargo, Integer> getRepository() {
        return cargoRepository;
    }
}

