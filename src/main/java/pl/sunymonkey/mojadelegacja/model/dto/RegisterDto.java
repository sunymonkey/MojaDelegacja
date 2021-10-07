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

    @NotNull
    private String login;


    private String email;


    private String password;


    private String confirm_password;
}
