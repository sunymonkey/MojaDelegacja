package pl.sunymonkey.mojadelegacja.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sunymonkey.mojadelegacja.exceptions.ApplicationFailedException;
import pl.sunymonkey.mojadelegacja.model.*;
import pl.sunymonkey.mojadelegacja.model.dto.StatementOfCostsDto;
import pl.sunymonkey.mojadelegacja.repository.CountriesDietRepository;
import pl.sunymonkey.mojadelegacja.repository.DelegationCostsRepository;
import pl.sunymonkey.mojadelegacja.repository.StatementOfCostsRepository;
import pl.sunymonkey.mojadelegacja.repository.UserRepository;
import pl.sunymonkey.mojadelegacja.security.CurrentUser;
import pl.sunymonkey.mojadelegacja.service.DelegationCostsService;
import pl.sunymonkey.mojadelegacja.service.DokumentDetailsService;
import pl.sunymonkey.mojadelegacja.service.StatementOfCoastService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StatementOfCoastServiceImpl implements StatementOfCoastService {

    private final StatementOfCostsRepository statementOfCostsRepository;

    private final CountriesDietRepository countriesDietRepository;

    @Autowired
    DelegationCostsService delegationCostsService;

    @Autowired
    DokumentDetailsService dokumentDetailsService;


    public StatementOfCoastServiceImpl(StatementOfCostsRepository statementOfCostsRepository, CountriesDietRepository countriesDietRepository) {
        this.statementOfCostsRepository = statementOfCostsRepository;
        this.countriesDietRepository = countriesDietRepository;
    }

    @Override
    public StatementOfCosts save(StatementOfCosts statementOfCosts) {
        return statementOfCostsRepository.save(statementOfCosts);
    }

    @Override
    public StatementOfCosts save(CurrentUser currentUser, StatementOfCostsDto dto) {
        if(dto.getCountry()==null || dto.getPurpose()==null
                || dto.getFromDate()==null || dto.getToDate()==null || dto.getFromTime()==null
                || dto.getToTime()==null || dto.getExchangeRateDay()==null){
            throw new ApplicationFailedException("Declaration not correct");
        }

        StatementOfCosts statementOfCosts = new StatementOfCosts();
        statementOfCosts.setPurpose(dto.getPurpose());
        statementOfCosts.setFromDate(dto.getFromDate());
        statementOfCosts.setFromTime(dto.getFromTime());
        statementOfCosts.setToDate(dto.getToDate());
        statementOfCosts.setToTime(dto.getToTime());
        CountriesDiet countriesDiet = countriesDietRepository.getById(dto.getCountry());
        statementOfCosts.setCountriesDiet(countriesDiet);
        statementOfCosts.setStatus("OPEN");
        statementOfCosts.setExchangeRateDay(dto.getExchangeRateDay());
        statementOfCosts.setCountBreakfast(dto.getCountBreakfast());
        statementOfCosts.setCountDinner(dto.getCountDinner());
        statementOfCosts.setCountSupper(dto.getCountSupper());
        statementOfCosts.setDelegationMember(currentUser.getUser());

        statementOfCosts.setDelegationCosts(delegationCostsService.calculateAndSave(statementOfCosts));

        statementOfCosts.setDokumentDetails(dokumentDetailsService.newDokument(currentUser));

        return statementOfCostsRepository.save(statementOfCosts);
    }

    @Override
    public StatementOfCosts findById(long id) {
        return statementOfCostsRepository.getById(id);
    }

    @Override
    public void sendDokument(StatementOfCosts statementOfCosts, CurrentUser currentUser) {
        DokumentDetails dokumentDetails = statementOfCosts.getDokumentDetails();
        dokumentDetailsService.sendDokument(currentUser, dokumentDetails);
    }

    @Override
    public List<StatementOfCosts> allStatus(String status) {
        return statementOfCostsRepository.allStatus(status);
    }

    @Override
    public void acceptDokument(StatementOfCosts statementOfCosts, CurrentUser currentUser) {
        DokumentDetails dokumentDetails = statementOfCosts.getDokumentDetails();
        dokumentDetailsService.acceptDokument(currentUser, dokumentDetails);
    }

    @Override
    public void rejectDokument(StatementOfCosts statementOfCosts, CurrentUser currentUser) {
        DokumentDetails dokumentDetails = statementOfCosts.getDokumentDetails();
        dokumentDetailsService.rejectDokument(currentUser, dokumentDetails);
    }

    @Override
    public List<StatementOfCosts> findByUser(String user) {
        return statementOfCostsRepository.findByUser(user);
    }

    @Override
    public StatementOfCostsDto newApplication(Application application) {
        StatementOfCostsDto statementOfCostsDto = new StatementOfCostsDto();
        statementOfCostsDto.setFromDate(application.getFromDate());
        statementOfCostsDto.setToDate(application.getToDate());
        statementOfCostsDto.setCountry(application.getCountriesDiet().getId());
        statementOfCostsDto.setPurpose(application.getPurpose());
        statementOfCostsDto.setDocumentType(application.getClass().getName());
        statementOfCostsDto.setDocumentID(application.getId());
        return statementOfCostsDto;
    }

    @Override
    public StatementOfCostsDto newApplication(Delegation delegation) {
        StatementOfCostsDto statementOfCostsDto = new StatementOfCostsDto();
        statementOfCostsDto.setFromDate(delegation.getFromDate());
        statementOfCostsDto.setToDate(delegation.getToDate());
        statementOfCostsDto.setCountry(delegation.getCountriesDiet().getId());
        statementOfCostsDto.setPurpose(delegation.getPurpose());
        statementOfCostsDto.setDocumentType(delegation.getClass().getName());
        statementOfCostsDto.setDocumentID(delegation.getId());
        return statementOfCostsDto;
    }
}
