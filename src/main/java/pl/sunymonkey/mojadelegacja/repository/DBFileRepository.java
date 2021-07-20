package pl.sunymonkey.mojadelegacja.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sunymonkey.mojadelegacja.model.DBFile;

@Repository
public interface DBFileRepository extends JpaRepository<DBFile, String> {
}
