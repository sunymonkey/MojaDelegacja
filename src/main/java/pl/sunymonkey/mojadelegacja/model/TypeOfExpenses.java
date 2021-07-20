package pl.sunymonkey.mojadelegacja.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
@Getter
@Setter
public class TypeOfExpenses extends BaseEntity {

    private String type;

    @ManyToMany(mappedBy = "type")
    private Set<Expenses> expenses;
}
