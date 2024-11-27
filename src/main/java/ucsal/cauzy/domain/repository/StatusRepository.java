package ucsal.cauzy.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ucsal.cauzy.domain.entity.Status;

public interface StatusRepository extends JpaRepository<Status, Integer> {
}

