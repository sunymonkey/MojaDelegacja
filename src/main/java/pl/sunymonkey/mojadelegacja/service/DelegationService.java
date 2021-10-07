package pl.sunymonkey.mojadelegacja.service;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import pl.sunymonkey.mojadelegacja.model.Delegation;
import pl.sunymonkey.mojadelegacja.model.dto.DelegationDto;
import pl.sunymonkey.mojadelegacja.security.CurrentUser;

import java.util.List;
import java.util.Optional;

public interface DelegationService {
    Delegation save(CurrentUser currentUser, Delegation delegation);
    List<Delegation> findAll();
    Optional<Delegation> findById(Long id);
    Delegation save(CurrentUser currentUser, DelegationDto dto);

    List<Delegation> findByMandatoryId(Long id);
}
