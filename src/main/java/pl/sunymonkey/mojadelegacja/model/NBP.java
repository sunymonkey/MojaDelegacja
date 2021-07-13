package pl.sunymonkey.mojadelegacja.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Embedded;


@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class NBP {

    private String table;
    private String currency;
    private String code;
    @Embedded
    private Rates[] rates;
}
