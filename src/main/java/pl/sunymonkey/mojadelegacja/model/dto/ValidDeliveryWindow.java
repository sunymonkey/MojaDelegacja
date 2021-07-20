package pl.sunymonkey.mojadelegacja.model.dto;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = OrderDeliveryWindowValidator.class)
public @interface ValidDeliveryWindow {
    String message() default "Powrót musi być po wyjeździe";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
