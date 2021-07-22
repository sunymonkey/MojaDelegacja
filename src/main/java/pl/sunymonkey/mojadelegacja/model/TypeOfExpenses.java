package pl.sunymonkey.mojadelegacja.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.Set;

@Entity
@Getter
@Setter
public class TypeOfExpenses extends BaseEntity {

    private String type;
}
