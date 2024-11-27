package ucsal.cauzy.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import ucsal.cauzy.domain.entity.Status;
import ucsal.cauzy.domain.repository.StatusRepository;

@Service
public class StatusService extends BaseService<Status, Integer> {

    @Autowired
    private StatusRepository statusRepository;

    @Override
    protected JpaRepository<Status, Integer> getRepository() {
        return statusRepository;
    }
}

