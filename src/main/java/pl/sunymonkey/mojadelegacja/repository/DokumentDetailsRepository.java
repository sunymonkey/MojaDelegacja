package pl.sunymonkey.mojadelegacja.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sunymonkey.mojadelegacja.model.DokumentDetails;

public interface DokumentDetailsRepository extends JpaRepository<DokumentDetails, Long> {
}
