package pl.sunymonkey.mojadelegacja.service;

import pl.sunymonkey.mojadelegacja.model.Application;

import java.util.List;
import java.util.Optional;

public interface ApplicationService {
    Application save(Application application);
    List<Application> findAll();
    Optional<Application> findById(Long id);
}
