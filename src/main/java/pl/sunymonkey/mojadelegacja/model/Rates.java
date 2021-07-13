package pl.sunymonkey.mojadelegacja.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Embeddable;

@Data
@AllArgsConstructor
@Embeddable
public class Rates {
    private String no;
    private String effectiveDate;
    private double mid;

    public Rates() {
    }
}
