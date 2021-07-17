package pl.sunymonkey.mojadelegacja.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Delegation extends Application{

    @ManyToOne
    private User mandatory;
}
