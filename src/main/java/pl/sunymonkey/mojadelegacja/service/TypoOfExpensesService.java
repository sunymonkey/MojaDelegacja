package pl.sunymonkey.mojadelegacja.service;

import pl.sunymonkey.mojadelegacja.model.TypeOfExpenses;

public interface TypoOfExpensesService {
    TypeOfExpenses findByName(String name);
    TypeOfExpenses save(TypeOfExpenses typeOfExpenses);

    TypeOfExpenses getById(Long id);
}
