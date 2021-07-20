package pl.sunymonkey.mojadelegacja.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
public class Expenses extends BaseEntity{
    private LocalDate dateExpenses;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private Set<TypeOfExpenses> type;

    private Long kmOrNumber;
    private double amount;
    private String currency;
    private String description;

    private String paymentMethod;

    @OneToOne
    @JoinColumn(name = "files_id")
    private DBFile files;

    @ManyToOne
    private StatementOfCosts statementOfCosts;
}
