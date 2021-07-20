package pl.sunymonkey.mojadelegacja.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sunymonkey.mojadelegacja.model.Currency;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Long> {
    Currency findByCurrency(String currency);
}
