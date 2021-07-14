package pl.sunymonkey.mojadelegacja.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import pl.sunymonkey.mojadelegacja.model.Role;
import pl.sunymonkey.mojadelegacja.model.User;
import pl.sunymonkey.mojadelegacja.security.CurrentUser;

import java.util.HashSet;
import java.util.Set;

public class SpringDataUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public CurrentUser loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userService.findByUserLogin(s);
        if (user == null) {
            throw new UsernameNotFoundException(s);
        }
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Role role : user.getRoles()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        return new CurrentUser(user.getLogin(), user.getPassword(), grantedAuthorities, user);
    }
}
