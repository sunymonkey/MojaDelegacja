package pl.sunymonkey.mojadelegacja.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class BaseEntity {

    @Id
    @GeneratedValue
    private Long id;
}
