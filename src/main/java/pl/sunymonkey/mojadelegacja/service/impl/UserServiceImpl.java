package pl.sunymonkey.mojadelegacja.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.sunymonkey.mojadelegacja.exceptions.RegisterFailedException;
import pl.sunymonkey.mojadelegacja.model.Role;
import pl.sunymonkey.mojadelegacja.model.User;
import pl.sunymonkey.mojadelegacja.model.dto.RegisterDto;
import pl.sunymonkey.mojadelegacja.repository.RoleRepository;
import pl.sunymonkey.mojadelegacja.repository.UserRepository;
import pl.sunymonkey.mojadelegacja.service.RoleService;
import pl.sunymonkey.mojadelegacja.service.UserService;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    private UserRepository userRepository;

    @Autowired
    RoleService roleService;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User u) {
        u.setPassword(passwordEncoder.encode(u.getPassword()));
        u.setEnabled(true);
        Role userRole = roleService.findByName("ROLE_EMPLOYEE");
        u.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        return userRepository.save(u);
    }

    @Override
    public User saveAdmin(User u) {
        u.setPassword(passwordEncoder.encode(u.getPassword()));
        u.setEnabled(true);
        Role userRole = roleService.findByName("ROLE_EMPLOYEE");
        Role adminRole = roleService.findByName("ROLE_ADMIN");
        u.setRoles(new HashSet<Role>(Arrays.asList(userRole,adminRole)));
        return userRepository.save(u);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findByUsername(String userName) {
        return userRepository.findByUsername(userName);
    }

    @Override
    public User registerUser(RegisterDto dto) throws RegisterFailedException {
        if(!dto.getPassword().equals(dto.getConfirm_password()) || dto.getPassword()==null || dto.getPassword().isEmpty()
                || dto.getConfirm_password()==null || dto.getConfirm_password().isEmpty()){
            throw new RegisterFailedException("Password incorrect");
        }
        Role userRole = roleService.findByName("ROLE_EMPLOYEE");
        User user = new User(dto.getFirstName(),
                             dto.getLastName(),
                             dto.getLogin(),
                             passwordEncoder.encode(dto.getPassword()),
                             dto.getEmail(),
                             true,
                             new HashSet<Role>(Arrays.asList(userRole)));

        return userRepository.save(user);
    }

    @Override
    public User getById(Long id) {
        return userRepository.getById(id);
    }

    @Override
    public List<User> allEmployee(String role) {
        return userRepository.allEmployee(role);
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }
}
