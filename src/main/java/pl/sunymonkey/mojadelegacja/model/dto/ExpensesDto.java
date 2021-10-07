package pl.sunymonkey.mojadelegacja.model.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;
import pl.sunymonkey.mojadelegacja.model.DBFile;
import pl.sunymonkey.mojadelegacja.model.StatementOfCosts;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class ExpensesDto {

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateExpenses;

    private Long kmOrNumber;
    private double amount;

    @NotNull
    private Long currency;

    private String description;

    @NotNull
    private Long paymentMethod;

    private Long type;


    private MultipartFile dbFile;

}
