package pl.sunymonkey.mojadelegacja.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sunymonkey.mojadelegacja.model.Application;

import java.util.List;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {
    List<Application> findByApplicantId(Long id);
}
