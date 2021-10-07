package pl.sunymonkey.mojadelegacja.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Delegation extends BaseEntity{

    private String purpose;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fromDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate toDate;

    @OneToOne
    @JoinColumn(name="countries_id")
    private CountriesDiet countriesDiet;

    @OneToOne
    @JoinColumn(name = "dokument_details")
    private DokumentDetails dokumentDetails;
    private String description;

    @ManyToOne
    private User mandatory;
}
