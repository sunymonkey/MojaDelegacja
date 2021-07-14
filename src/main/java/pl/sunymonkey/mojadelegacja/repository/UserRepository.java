package pl.sunymonkey.mojadelegacja.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sunymonkey.mojadelegacja.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByLogin(String userLogin);
}
