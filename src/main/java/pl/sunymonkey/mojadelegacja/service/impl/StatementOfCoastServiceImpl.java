package pl.sunymonkey.mojadelegacja.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sunymonkey.mojadelegacja.exceptions.ApplicationFailedException;
import pl.sunymonkey.mojadelegacja.model.CountriesDiet;
import pl.sunymonkey.mojadelegacja.model.StatementOfCosts;
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

@Service
public class StatementOfCoastServiceImpl implements StatementOfCoastService {

    private final StatementOfCostsRepository statementOfCostsRepository;

    private final CountriesDietRepository countriesDietRepository;

    @Autowired
    DelegationCostsService delegationCostsService;

    @Autowired
    DokumentDetailsService dokumentDetailsService;

    private final UserRepository userRepository;

    public StatementOfCoastServiceImpl(StatementOfCostsRepository statementOfCostsRepository, CountriesDietRepository countriesDietRepository, DelegationCostsRepository delegationCostsRepository, UserRepository userRepository) {
        this.statementOfCostsRepository = statementOfCostsRepository;
        this.countriesDietRepository = countriesDietRepository;
        this.userRepository = userRepository;
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
}
