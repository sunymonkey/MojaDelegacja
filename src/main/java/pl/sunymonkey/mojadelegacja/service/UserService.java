package pl.sunymonkey.mojadelegacja.service;

import pl.sunymonkey.mojadelegacja.exceptions.RegisterFailedException;
import pl.sunymonkey.mojadelegacja.model.User;
import pl.sunymonkey.mojadelegacja.model.dto.RegisterDto;

import java.util.List;

public interface UserService {

    User save(User user);
    User saveAdmin(User user);
    List<User> findAll();
    User findByUsername(String username);
    User registerUser(RegisterDto dto) throws RegisterFailedException;
}
