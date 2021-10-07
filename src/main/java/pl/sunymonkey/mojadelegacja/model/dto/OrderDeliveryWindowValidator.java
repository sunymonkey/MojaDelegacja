package pl.sunymonkey.mojadelegacja.model.dto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class OrderDeliveryWindowValidator implements ConstraintValidator<ValidDeliveryWindow, ApplicationDto> {

    public void initialize(ValidDeliveryWindow constraintAnnotation) {
    }

    public boolean isValid(ApplicationDto applicationDto, ConstraintValidatorContext constraintValidatorContext) {
        return applicationDto.getFromDate().isBefore(applicationDto.getToDate());
    }
}
