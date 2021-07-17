package pl.sunymonkey.mojadelegacja.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class DelegationCosts extends BaseEntity{
    private double totalCostsOfTheDelegation;
    private double paidByEmployee;
    private double advancesCollected;
    private double returnedToTheEmployee;
    private int fullDay;
    private int halfDay;
    private int miniDay;

}
