package pl.khuzzuk.springdata.db;

import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class PersonNames {
    private String firstName;
    private String secondName;
    private String surname;
}
