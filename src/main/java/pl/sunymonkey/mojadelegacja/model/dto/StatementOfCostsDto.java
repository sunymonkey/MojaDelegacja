package pl.sunymonkey.mojadelegacja.model.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class StatementOfCostsDto {
    @NotNull
    private String purpose;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fromDate;

    @NotNull
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime fromTime;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate toDate;

    @NotNull
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime toTime;

    @NotNull
    private Long country;

    private int countBreakfast;
    private int countDinner;
    private int countSupper;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past
    private LocalDate exchangeRateDay;
}
