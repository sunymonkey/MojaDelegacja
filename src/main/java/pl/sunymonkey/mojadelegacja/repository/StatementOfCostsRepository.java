package pl.sunymonkey.mojadelegacja.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.sunymonkey.mojadelegacja.model.StatementOfCosts;

import java.util.List;

public interface StatementOfCostsRepository extends JpaRepository<StatementOfCosts, Long> {

    @Query(value = "SELECT s FROM StatementOfCosts s JOIN s.dokumentDetails.status sd WHERE sd.status = ?1")
    List<StatementOfCosts> allStatus(String status);

    @Query(value = "SELECT s FROM StatementOfCosts s JOIN s.dokumentDetails dD WHERE dD.createUser.username = ?1")
    List<StatementOfCosts> findByUser(String user);
}
