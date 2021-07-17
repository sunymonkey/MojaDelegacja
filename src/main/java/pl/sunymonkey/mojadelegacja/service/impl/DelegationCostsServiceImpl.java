package pl.sunymonkey.mojadelegacja.service.impl;

import org.springframework.stereotype.Service;
import pl.sunymonkey.mojadelegacja.model.DelegationCosts;
import pl.sunymonkey.mojadelegacja.model.StatementOfCosts;
import pl.sunymonkey.mojadelegacja.repository.DelegationCostsRepository;
import pl.sunymonkey.mojadelegacja.service.DelegationCostsService;
import pl.sunymonkey.mojadelegacja.service.DelegationService;
import pl.sunymonkey.mojadelegacja.service.NBPService;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Service
public class DelegationCostsServiceImpl implements DelegationCostsService {

    private final DelegationCostsRepository delegationCostsRepository;

    NBPService nbpService = new NBPService();

    public DelegationCostsServiceImpl(DelegationCostsRepository delegationCostsRepository) {
        this.delegationCostsRepository = delegationCostsRepository;
    }


    @Override
    public DelegationCosts save(DelegationCosts delegationCosts) {
        return delegationCostsRepository.save(delegationCosts);
    }

    @Override
    public DelegationCosts calculateAndSave(StatementOfCosts statementOfCosts) {
        LocalDateTime fromDate = LocalDateTime.of(statementOfCosts.getFromDate(), statementOfCosts.getFromTime());
        LocalDateTime toDate = LocalDateTime.of(statementOfCosts.getToDate(), statementOfCosts.getToTime());

        long minutes = ChronoUnit.MINUTES.between(fromDate, toDate);
        long hours = minutes/60;
        minutes = minutes - (hours * 60);
        long day = hours/24;
        hours = hours - (day * 24);
        int fullDay = (int) day;
        int halfDay = 0;
        int miniDay = 0;
        if(hours >= 12){
            fullDay++;
        }

        if(hours < 12 && hours >= 8){
            halfDay++;
        }

        if(hours < 8){
            miniDay++;
        }

        double lumpSum = statementOfCosts.getCountriesDiet().getLumpSum();
        String currency = statementOfCosts.getCountriesDiet().getCurrency();

        double resultForeignCurrency = lumpSum * fullDay + 0.5 * lumpSum * halfDay + (lumpSum / 3) * miniDay;

        double resultPLN = nbpService.getExchangeRate(currency, statementOfCosts.getExchangeRateDay()) * resultForeignCurrency;

        DelegationCosts delegationCosts = new DelegationCosts();
        delegationCosts.setTotalCostsOfTheDelegation(resultPLN);
        delegationCosts.setReturnedToTheEmployee(resultPLN);
        delegationCosts.setFullDay(fullDay);
        delegationCosts.setHalfDay(halfDay);
        delegationCosts.setMiniDay(miniDay);
        delegationCostsRepository.save(delegationCosts);

        return delegationCosts;
    }
}
