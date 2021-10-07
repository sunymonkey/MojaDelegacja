package pl.sunymonkey.mojadelegacja.model.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class DelegationDto extends ApplicationDto{

    @NotNull
    private Long mandatory;
}
