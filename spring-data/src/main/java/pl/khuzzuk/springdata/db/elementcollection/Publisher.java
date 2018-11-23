package pl.khuzzuk.springdata.db.elementcollection;

import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class Publisher {
    private String name;
    private int since;
}
