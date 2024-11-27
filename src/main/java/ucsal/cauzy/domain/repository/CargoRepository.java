package ucsal.cauzy.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ucsal.cauzy.domain.entity.Cargo;

public interface CargoRepository extends JpaRepository<Cargo, Integer> {
}

