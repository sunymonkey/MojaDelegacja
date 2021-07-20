package pl.sunymonkey.mojadelegacja.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class Status extends BaseEntity{

    private String status;
}
