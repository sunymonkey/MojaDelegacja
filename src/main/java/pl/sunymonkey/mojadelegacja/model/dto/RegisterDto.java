package pl.sunymonkey.mojadelegacja.model.dto;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class RegisterDto {

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @Min(4)
    private String login;

    @Min(4)
    private String email;

    @Min(4)
    private String password;

    @Min(4)
    private String confirm_password;
}
