package pl.sunymonkey.mojadelegacja.service;

import pl.sunymonkey.mojadelegacja.exceptions.RegisterFailedException;
import pl.sunymonkey.mojadelegacja.model.User;
import pl.sunymonkey.mojadelegacja.model.dto.RegisterDto;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User save(User user);
    User saveAdmin(User user);
    List<User> findAll();
    User findByUsername(String username);
    User registerUser(RegisterDto dto) throws RegisterFailedException;

    User getById(Long id);

    List<User> allEmployee(String role);

    Optional<User> findById(Long id);
}
