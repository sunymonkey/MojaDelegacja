package pl.sunymonkey.mojadelegacja.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sunymonkey.mojadelegacja.model.Expenses;

@Repository
public interface ExpensesRepository extends JpaRepository<Expenses, Long> {
}
