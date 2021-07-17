package pl.sunymonkey.mojadelegacja.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;
import pl.sunymonkey.mojadelegacja.exceptions.ApplicationFailedException;
import pl.sunymonkey.mojadelegacja.model.CountriesDiet;
import pl.sunymonkey.mojadelegacja.model.Delegation;
import pl.sunymonkey.mojadelegacja.model.User;
import pl.sunymonkey.mojadelegacja.model.dto.DelegationDto;
import pl.sunymonkey.mojadelegacja.repository.CountriesDietRepository;
import pl.sunymonkey.mojadelegacja.repository.DelegationRepository;
import pl.sunymonkey.mojadelegacja.repository.UserRepository;
import pl.sunymonkey.mojadelegacja.security.CurrentUser;
import pl.sunymonkey.mojadelegacja.service.DelegationService;
import pl.sunymonkey.mojadelegacja.service.DokumentDetailsService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class DelegationServiceImpl implements DelegationService {

    private final DelegationRepository delegationRepository;

    private final CountriesDietRepository countriesDietRepository;

    @Autowired
    DokumentDetailsService dokumentDetailsService;

    private final UserRepository userRepository;

    public DelegationServiceImpl(DelegationRepository delegationRepository, CountriesDietRepository countriesDietRepository, UserRepository userRepository) {
        this.delegationRepository = delegationRepository;
        this.countriesDietRepository = countriesDietRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Delegation save(CurrentUser currentUser, Delegation delegation) {
        return delegationRepository.save(delegation);
    }

    @Override
    public List<Delegation> findAll() {
        return delegationRepository.findAll();
    }

    @Override
    public Optional<Delegation> findById(Long id) {
        return delegationRepository.findById(id);
    }

    @Override
    public Delegation save(CurrentUser currentUser, DelegationDto dto) {
        if(dto.getCountry()==null || dto.getPurpose()==null
                || dto.getFromDate()==null || dto.getToDate()==null || dto.getMandatory()==null){
            throw new ApplicationFailedException("Application not correct");
        }

        Delegation delegation = new Delegation();
        delegation.setPurpose(dto.getPurpose());
        delegation.setFromDate(dto.getFromDate());
        delegation.setToDate(dto.getToDate());
        CountriesDiet countriesDiet = countriesDietRepository.getById(dto.getCountry());
        delegation.setCountriesDiet(countriesDiet);
        delegation.setStatus("OPEN");
        if(dto.getDescription()!=null){
            delegation.setDescription(dto.getDescription());
        }
        User user=userRepository.getById(dto.getMandatory());
        delegation.setMandatory(user);

        delegation.setDokumentDetails(dokumentDetailsService.newDokument(currentUser));

        return delegationRepository.save(delegation);
    }

    @Override
    public List<Delegation> findByMandatoryId(Long id) {
        return delegationRepository.findByMandatoryId(id);
    }
}
