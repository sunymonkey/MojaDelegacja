package pl.sunymonkey.mojadelegacja.service;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import pl.sunymonkey.mojadelegacja.model.Application;
import pl.sunymonkey.mojadelegacja.model.dto.ApplicationDto;
import pl.sunymonkey.mojadelegacja.security.CurrentUser;

import java.util.List;
import java.util.Optional;

public interface ApplicationService {
    Application save(CurrentUser currentUser, Application application);
    List<Application> findAll();
    Optional<Application> findById(Long id);
    Application save(CurrentUser currentUser, ApplicationDto dto);
}
