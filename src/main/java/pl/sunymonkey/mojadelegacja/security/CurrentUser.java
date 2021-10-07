package pl.sunymonkey.mojadelegacja.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class CurrentUser extends User {

    private final pl.sunymonkey.mojadelegacja.model.User user;


    public CurrentUser(String login, String password,
                       Collection<? extends GrantedAuthority> authorities,
                       pl.sunymonkey.mojadelegacja.model.User user) {
        super(login, password, authorities);
        this.user = user;
    }

    public pl.sunymonkey.mojadelegacja.model.User getUser() {
        return user;
    }


}
