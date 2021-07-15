package pl.sunymonkey.mojadelegacja.model;
import lombok.*;
import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Data
@ToString
//@NoArgsConstructor
//@AllArgsConstructor
public class User extends BaseEntity {


    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;
    private boolean enabled;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private Set<Role> roles;

    @OneToMany(mappedBy = "mandatory")
    private List<Delegation> delegationList;

    public User() {
    }

    public User(String firstName, String lastName, String username, String password, String email, boolean enabled, Set<Role> roles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.enabled = enabled;
        this.roles = roles;
    }
}
