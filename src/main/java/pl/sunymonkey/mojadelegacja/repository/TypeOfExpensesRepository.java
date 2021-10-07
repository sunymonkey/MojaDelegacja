package pl.sunymonkey.mojadelegacja.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sunymonkey.mojadelegacja.model.TypeOfExpenses;

@Repository
public interface TypeOfExpensesRepository extends JpaRepository<TypeOfExpenses, Long> {

    TypeOfExpenses findByType(String name);
}
