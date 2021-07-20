package pl.sunymonkey.mojadelegacja.service.impl;

import org.springframework.stereotype.Service;
import pl.sunymonkey.mojadelegacja.model.TypeOfExpenses;
import pl.sunymonkey.mojadelegacja.repository.TypeOfExpensesRepository;
import pl.sunymonkey.mojadelegacja.service.TypoOfExpensesService;

@Service
public class TypoOfExpensesServiceImpl implements TypoOfExpensesService {

    private final TypeOfExpensesRepository typeOfExpensesRepository;

    public TypoOfExpensesServiceImpl(TypeOfExpensesRepository typeOfExpensesRepository) {
        this.typeOfExpensesRepository = typeOfExpensesRepository;
    }

    @Override
    public TypeOfExpenses findByName(String name) {
        return typeOfExpensesRepository.findByType(name);
    }

    @Override
    public TypeOfExpenses save(TypeOfExpenses typeOfExpenses) {
        return typeOfExpensesRepository.save(typeOfExpenses);
    }
}
