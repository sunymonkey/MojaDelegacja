package pl.sunymonkey.mojadelegacja.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.sunymonkey.mojadelegacja.model.DelegationCosts;
import pl.sunymonkey.mojadelegacja.model.Expenses;
import pl.sunymonkey.mojadelegacja.model.StatementOfCosts;
import pl.sunymonkey.mojadelegacja.model.TypeOfExpenses;
import pl.sunymonkey.mojadelegacja.repository.DelegationCostsRepository;
import pl.sunymonkey.mojadelegacja.service.DelegationCostsService;
import pl.sunymonkey.mojadelegacja.service.DelegationService;
import pl.sunymonkey.mojadelegacja.service.NBPService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Set;

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
    @Transactional
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
        double exchangeRate = nbpService.getExchangeRate(currency, statementOfCosts.getExchangeRateDay());
        double resultPLN = exchangeRate * resultForeignCurrency;

        DelegationCosts delegationCosts = new DelegationCosts();
        delegationCosts.setDailyDiet(resultPLN); // suma ryczałtu
        delegationCosts.setTotalCostsOfTheDelegation(resultPLN);
        delegationCosts.setReturnedToTheEmployee(resultPLN);
        delegationCosts.setFullDay(fullDay);
        delegationCosts.setHalfDay(halfDay);
        delegationCosts.setMiniDay(miniDay);
        statementOfCosts.setRate(exchangeRate);
        delegationCostsRepository.save(delegationCosts);

        return delegationCosts;
    }

    @Override
    @Transactional
    public DelegationCosts finishCalculateAndSave(StatementOfCosts statementOfCosts) {
        List<Expenses> expenses = statementOfCosts.getExpenses();
        DelegationCosts delegationCosts = statementOfCosts.getDelegationCosts();
        double sumAdvancesCollected = 0;//suma zaliczek
        double sumExpendedFirmCard = 0;//suma wydatków przez firmę
        double sumExpendedFirmTransfer = 0;//suma wydatków przez firmę
        double sumExpendedEmployee = 0;//suma wydatków przez pracownika
        double sumExpended = 0;

        for (int i = 0; i < expenses.size(); i++) {
            String currency = expenses.get(i).getCurrency().getCurrency();
            LocalDate date = expenses.get(i).getDateExpenses();
            double exchangeRate = nbpService.getExchangeRate(currency, date);

            double expended;
            if(currency.equals("PLN")){
                expended = expenses.get(i).getAmount();
            } else {
                expended = expenses.get(i).getAmount() * exchangeRate;
            }

            sumExpended += expended;
            String typeOfExpenses = expenses.get(i).getType().getType();
            String methodPay = expenses.get(i).getPaymentMethod().getMethod();

            if(typeOfExpenses.equals("Zaliczka")){
                sumAdvancesCollected += expended;
                continue;
            }

            if(typeOfExpenses.equals("Samochód służbowy")) {
                continue;
            }
            if(methodPay.equals("Pracownik")){
                sumExpendedEmployee += expended;
            } else if(methodPay.equals("Przelew")) {
                sumExpendedFirmTransfer += expended;
            } else {
                sumExpendedFirmCard += expended;
            }
        }

        delegationCosts.setSumAdvancesCollected(sumAdvancesCollected);
        delegationCosts.setSumExpendedEmployee(sumExpendedEmployee);
        delegationCosts.setSumExpendedFirmCard(sumExpendedFirmCard);
        delegationCosts.setSumExpendedFirmTransfer(sumExpendedFirmTransfer);
        delegationCosts.setTotalCostsOfTheDelegation(delegationCosts.getDailyDiet() + sumExpended);
        delegationCosts.setPaidByEmployee(delegationCosts.getDailyDiet() + sumExpendedEmployee);
        delegationCosts.setReturnedToTheEmployee(delegationCosts.getDailyDiet() - sumAdvancesCollected);
        delegationCostsRepository.save(delegationCosts);
        return delegationCosts;
    }
}
