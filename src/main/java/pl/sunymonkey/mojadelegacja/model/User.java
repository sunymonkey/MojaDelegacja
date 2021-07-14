package pl.sunymonkey.mojadelegacja.model;
import lombok.*;
import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@ToString
public class User extends BaseEntity {


    private String firstName;
    private String lastName;
    private String login;
    private String password;
    private String email;
    private boolean enabled;

    @ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.MERGE)
    private Set<Role> roles;

    public User() {
    }

    public User(String firstName, String lastName, String login, String password, String email, boolean enabled, Set<Role> roles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.email = email;
        this.enabled = enabled;
        this.roles = roles;
    }
}
