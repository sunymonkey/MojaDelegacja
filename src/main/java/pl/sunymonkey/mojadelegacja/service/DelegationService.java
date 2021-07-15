package pl.sunymonkey.mojadelegacja.service;

import pl.sunymonkey.mojadelegacja.model.Delegation;
import pl.sunymonkey.mojadelegacja.model.dto.DelegationDto;

import java.util.List;
import java.util.Optional;

public interface DelegationService {
    Delegation save(Delegation delegation);
    List<Delegation> findAll();
    Optional<Delegation> findById(Long id);
    Delegation save(DelegationDto dto);
}
