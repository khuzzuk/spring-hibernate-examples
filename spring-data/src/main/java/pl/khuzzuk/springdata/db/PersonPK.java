package pl.khuzzuk.springdata.db;

import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class PersonPK implements Serializable {
    private Long id;
    private String firstName;
    private String secondName;
    private String lastName;
}
