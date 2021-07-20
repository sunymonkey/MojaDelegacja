package pl.sunymonkey.mojadelegacja.service.impl;

import org.springframework.stereotype.Service;
import pl.sunymonkey.mojadelegacja.model.Currency;
import pl.sunymonkey.mojadelegacja.repository.CurrencyRepository;
import pl.sunymonkey.mojadelegacja.service.CurrencyService;

@Service
public class CurrencyServiceImpl implements CurrencyService {
    private final CurrencyRepository currencyRepository;

    public CurrencyServiceImpl(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    @Override
    public Currency save(Currency currency) {
        return currencyRepository.save(currency);
    }

    @Override
    public Currency findByCurrency(String currency) {
        return currencyRepository.findByCurrency(currency);
    }
}
