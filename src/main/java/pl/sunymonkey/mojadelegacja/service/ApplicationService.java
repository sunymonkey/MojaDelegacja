package pl.sunymonkey.mojadelegacja.service;

import pl.sunymonkey.mojadelegacja.model.Application;
import pl.sunymonkey.mojadelegacja.model.dto.ApplicationDto;

import java.util.List;
import java.util.Optional;

public interface ApplicationService {
    Application save(Application application);
    List<Application> findAll();
    Optional<Application> findById(Long id);
    Application save(ApplicationDto dto);
}
