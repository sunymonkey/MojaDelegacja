package pl.sunymonkey.mojadelegacja.service;

import pl.sunymonkey.mojadelegacja.model.DBFile;
import pl.sunymonkey.mojadelegacja.model.Expenses;
import pl.sunymonkey.mojadelegacja.model.StatementOfCosts;
import pl.sunymonkey.mojadelegacja.model.TypeOfExpenses;
import pl.sunymonkey.mojadelegacja.model.dto.ExpensesDto;

public interface ExpensesService {
    Expenses save(Expenses expenses);

    Expenses save(ExpensesDto dto, DBFile dbFile, StatementOfCosts statementOfCoast);
}
