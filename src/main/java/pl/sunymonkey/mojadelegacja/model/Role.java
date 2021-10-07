package pl.sunymonkey.mojadelegacja.model;



import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Role extends BaseEntity {

    private String name;

    @ManyToMany(mappedBy = "roles")
    Set<User> users;
}
