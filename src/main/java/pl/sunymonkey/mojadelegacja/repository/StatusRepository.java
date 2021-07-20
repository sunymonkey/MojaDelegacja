package pl.sunymonkey.mojadelegacja.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sunymonkey.mojadelegacja.model.Status;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {

    Status findByStatus(String status);
}
