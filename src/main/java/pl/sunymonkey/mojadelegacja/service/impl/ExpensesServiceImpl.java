package pl.sunymonkey.mojadelegacja.service.impl;

import org.springframework.stereotype.Service;
import pl.sunymonkey.mojadelegacja.exceptions.ExpensesFailedException;
import pl.sunymonkey.mojadelegacja.model.*;
import pl.sunymonkey.mojadelegacja.model.dto.ExpensesDto;
import pl.sunymonkey.mojadelegacja.repository.CurrencyRepository;
import pl.sunymonkey.mojadelegacja.repository.ExpensesRepository;
import pl.sunymonkey.mojadelegacja.repository.PaymentMethodRepository;
import pl.sunymonkey.mojadelegacja.repository.TypeOfExpensesRepository;
import pl.sunymonkey.mojadelegacja.service.ExpensesService;

import java.util.HashSet;
import java.util.Set;

@Service
public class ExpensesServiceImpl implements ExpensesService {

    private final ExpensesRepository expensesRepository;

    private final PaymentMethodRepository paymentMethodRepository;

    private final CurrencyRepository currencyRepository;

    private final TypeOfExpensesRepository typeOfExpensesRepository;

    public ExpensesServiceImpl(ExpensesRepository expensesRepository, PaymentMethodRepository paymentMethodRepository, CurrencyRepository currencyRepository, TypeOfExpensesRepository typeOfExpensesRepository) {
        this.expensesRepository = expensesRepository;
        this.paymentMethodRepository = paymentMethodRepository;
        this.currencyRepository = currencyRepository;
        this.typeOfExpensesRepository = typeOfExpensesRepository;
    }

    @Override
    public Expenses save(Expenses expenses) {
        return expensesRepository.save(expenses);
    }

    @Override
    public Expenses save(ExpensesDto dto, DBFile dbFile, StatementOfCosts statementOfCoast) {
        if(dto.getDateExpenses()==null || dto.getType()==null ||
           dto.getCurrency()==null) {
            throw new ExpensesFailedException("Expenses not correct");
        }

        Expenses expenses = new Expenses();
        expenses.setDateExpenses(dto.getDateExpenses());
        expenses.setAmount(dto.getAmount());
        Currency currency = currencyRepository.getById(dto.getCurrency());
        expenses.setCurrency(currency);
        expenses.setDescription(dto.getDescription());
        TypeOfExpenses typeOfExpenses = typeOfExpensesRepository.getById(dto.getType());
        expenses.setType(typeOfExpenses);
        expenses.setKmOrNumber(dto.getKmOrNumber());
        PaymentMethod paymentMethod = paymentMethodRepository.getById(dto.getPaymentMethod());
        expenses.setPaymentMethod(paymentMethod);
        expenses.setStatementOfCosts(statementOfCoast);
        expenses.setFiles(dbFile);

        expensesRepository.save(expenses);

        return expenses;

    }
}
