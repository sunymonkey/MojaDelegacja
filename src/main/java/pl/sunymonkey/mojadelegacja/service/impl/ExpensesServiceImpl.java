package pl.sunymonkey.mojadelegacja.service.impl;

import org.springframework.stereotype.Service;
import pl.sunymonkey.mojadelegacja.exceptions.ExpensesFailedException;
import pl.sunymonkey.mojadelegacja.model.DBFile;
import pl.sunymonkey.mojadelegacja.model.Expenses;
import pl.sunymonkey.mojadelegacja.model.StatementOfCosts;
import pl.sunymonkey.mojadelegacja.model.TypeOfExpenses;
import pl.sunymonkey.mojadelegacja.model.dto.ExpensesDto;
import pl.sunymonkey.mojadelegacja.repository.ExpensesRepository;
import pl.sunymonkey.mojadelegacja.repository.TypeOfExpensesRepository;
import pl.sunymonkey.mojadelegacja.service.ExpensesService;

import java.util.HashSet;
import java.util.Set;

@Service
public class ExpensesServiceImpl implements ExpensesService {

    private final ExpensesRepository expensesRepository;

    private final TypeOfExpensesRepository typeOfExpensesRepository;

    public ExpensesServiceImpl(ExpensesRepository expensesRepository, TypeOfExpensesRepository typeOfExpensesRepository) {
        this.expensesRepository = expensesRepository;
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
        expenses.setCurrency(dto.getCurrency());
        expenses.setDescription(dto.getDescription());
        TypeOfExpenses typeOfExpenses = typeOfExpensesRepository.getById(dto.getType());
        Set<TypeOfExpenses> typeSet = new HashSet<>();
        typeSet.add(typeOfExpenses);
        expenses.setType(typeSet);
        expenses.setKmOrNumber(dto.getKmOrNumber());
        expenses.setPaymentMethod(dto.getPaymentMethod());
        expenses.setStatementOfCosts(statementOfCoast);
        expenses.setFiles(dbFile);

        expensesRepository.save(expenses);

        return expenses;

    }
}
