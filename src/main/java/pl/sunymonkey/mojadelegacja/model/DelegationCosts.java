package pl.sunymonkey.mojadelegacja.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

/*
totalCostsOfTheDelegation = ryczałt diety + wydatki (hotel+inne+transport bez samochodu służbowego i zaliczki)
paidByEmployee = ryczałt diety  + wydatki zapłacone przez pracownika
returnedToTheEmployee = ryczałt diety  - zaliczki(advancesCollected)

sumAdvancesCollected-suma wszystkich zaliczek
sumExpendedFirm-suma wydatków przez firmę
sumExpendedEmployee-suma wydatków zapłaconych przez pracownika

dailyDiet-ryczałt diety
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class DelegationCosts extends BaseEntity{
    private double totalCostsOfTheDelegation; //łączny koszt delegacji
    private double paidByEmployee; //zapłacone przez pracownika (ryczałt diety)
    private double returnedToTheEmployee; //do zwrotu pracownikowi
    private double sumAdvancesCollected; //suma wszystkich zaliczek
    private double sumExpendedFirmCard; //suma wydatków przez firmę karta firmowa
    private double sumExpendedFirmTransfer; //suma wydatków przez firmę przelewem
    private double sumExpendedEmployee; //suma wydatków zapłaconych przez pracownika
    private double dailyDiet; //ryczałt diety
    private int fullDay;
    private int halfDay;
    private int miniDay;



}
