package pl.sunymonkey.mojadelegacja.service.impl;

import org.springframework.stereotype.Service;
import pl.sunymonkey.mojadelegacja.model.Status;
import pl.sunymonkey.mojadelegacja.repository.StatusRepository;
import pl.sunymonkey.mojadelegacja.service.StatusService;

@Service
public class StatusServiceImpl implements StatusService {

    private final StatusRepository statusRepository;

    public StatusServiceImpl(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    @Override
    public Status findByStatus(String name) {
        return statusRepository.findByStatus(name);
    }

    @Override
    public Status save(Status status) {
        return statusRepository.save(status);
    }
}
