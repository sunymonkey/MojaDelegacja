package pl.sunymonkey.mojadelegacja.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sunymonkey.mojadelegacja.model.StatementOfCosts;

public interface StatementOfCostsRepository extends JpaRepository<StatementOfCosts, Long> {
}
