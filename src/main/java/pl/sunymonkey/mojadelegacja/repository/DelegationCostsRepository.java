package pl.sunymonkey.mojadelegacja.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sunymonkey.mojadelegacja.model.DelegationCosts;

public interface DelegationCostsRepository extends JpaRepository<DelegationCosts, Long> {
}
