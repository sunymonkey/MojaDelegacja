package pl.sunymonkey.mojadelegacja.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Delegation extends Application{

    @ManyToOne
    private User mandatory;
}
