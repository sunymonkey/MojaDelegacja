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

    @ManyToOne
    @JoinColumn(name = "type_id")
    private TypeOfExpenses type;

    private Long kmOrNumber;
    private double amount;

    @ManyToOne
    @JoinColumn(name = "currency_id")
    private Currency currency;
    private String description;

    @ManyToOne
    @JoinColumn(name = "payment_method")
    private PaymentMethod paymentMethod;

    @OneToOne
    @JoinColumn(name = "files_id")
    private DBFile files;

    @ManyToOne
    private StatementOfCosts statementOfCosts;
}
