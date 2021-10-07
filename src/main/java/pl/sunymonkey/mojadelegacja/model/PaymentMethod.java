package pl.sunymonkey.mojadelegacja.model;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class PaymentMethod extends BaseEntity {
    private String method;

}
