package pl.sunymonkey.mojadelegacja.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import pl.sunymonkey.mojadelegacja.model.User;

@Data
@Entity
public class Delegation extends Application{

    @OneToOne
    @JoinColumn(name="mandatory_id")
    private User mandatory;
}
