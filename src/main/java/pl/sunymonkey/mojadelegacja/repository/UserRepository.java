package pl.sunymonkey.mojadelegacja.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.sunymonkey.mojadelegacja.model.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String userLogin);

    @Query(value = "SELECT u FROM User u JOIN u.roles r WHERE r.name = ?1")
    List<User> allEmployee(String role);
}
