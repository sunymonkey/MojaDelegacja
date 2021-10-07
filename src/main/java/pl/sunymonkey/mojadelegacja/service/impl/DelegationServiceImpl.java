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
import pl.sunymonkey.mojadelegacja.service.CountriesDietService;
import pl.sunymonkey.mojadelegacja.service.DelegationService;
import pl.sunymonkey.mojadelegacja.service.DokumentDetailsService;
import pl.sunymonkey.mojadelegacja.service.UserService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class DelegationServiceImpl implements DelegationService {

    private final DelegationRepository delegationRepository;

    @Autowired
    CountriesDietService countriesDietService;

    @Autowired
    DokumentDetailsService dokumentDetailsService;

    @Autowired
    UserService userService;


    public DelegationServiceImpl(DelegationRepository delegationRepository) {
        this.delegationRepository = delegationRepository;
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
        CountriesDiet countriesDiet = countriesDietService.getById(dto.getCountry());
        delegation.setCountriesDiet(countriesDiet);
        if(dto.getDescription()!=null){
            delegation.setDescription(dto.getDescription());
        }
        User user = userService.getById(dto.getMandatory());
        delegation.setMandatory(user);

        delegation.setDokumentDetails(dokumentDetailsService.newDokument(currentUser));

        return delegationRepository.save(delegation);
    }

    @Override
    public List<Delegation> findByMandatoryId(Long id) {
        return delegationRepository.findByMandatoryId(id);
    }
}
