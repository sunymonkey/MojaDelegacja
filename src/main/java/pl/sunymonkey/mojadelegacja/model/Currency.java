package pl.sunymonkey.mojadelegacja.model;

import lombok.Data;
import javax.persistence.Entity;

@Entity
@Data
public class Currency extends BaseEntity{

    private String currency;
}
