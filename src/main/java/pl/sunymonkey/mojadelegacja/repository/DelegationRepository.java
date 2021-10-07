package pl.sunymonkey.mojadelegacja.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sunymonkey.mojadelegacja.model.Delegation;

import java.util.List;

@Repository
public interface DelegationRepository extends JpaRepository<Delegation, Long> {
    List<Delegation> findByMandatoryId(Long id);
}
