package pl.sunymonkey.mojadelegacja.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sunymonkey.mojadelegacja.model.Delegation;

@Repository
public interface DelegationRepository extends JpaRepository<Delegation, Long> {
}
