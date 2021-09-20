package pl.sunymonkey.mojadelegacja.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatementOfCosts extends BaseEntity{

    @OneToOne
    @JoinColumn(name = "member_id")
    private User delegationMember;

    private String documentType;
    private Long documentID;
    private String purpose;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fromDate;
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime fromTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate toDate;
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime toTime;

    @OneToOne
    @JoinColumn(name="countries_id")
    private CountriesDiet countriesDiet;

    private int countBreakfast;
    private int countDinner;
    private int countSupper;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate exchangeRateDay;
    private double rate;
    private String status;
    private String description;

    @OneToOne
    @JoinColumn(name = "delegation_cost_id")
    private DelegationCosts delegationCosts;

    @OneToOne
    @JoinColumn(name = "dokument_details")
    private DokumentDetails dokumentDetails;

    @OneToMany(mappedBy = "statementOfCosts")
    private List<Expenses> expenses = new ArrayList<>();
}
