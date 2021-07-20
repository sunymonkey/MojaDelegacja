package pl.sunymonkey.mojadelegacja.model.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@ValidDeliveryWindow
public class ApplicationDto {

    @NotNull
    @Size(min=5)
    private String purpose;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fromDate;


    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate toDate;

    @NotNull
    private Long country;

    private String description;
}
