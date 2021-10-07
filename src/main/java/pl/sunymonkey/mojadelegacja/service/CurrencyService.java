package pl.sunymonkey.mojadelegacja.service;

import pl.sunymonkey.mojadelegacja.model.Currency;

public interface CurrencyService {
    Currency save(Currency currency);
    Currency findByCurrency(String currency);

    Currency getById(Long id);
}
