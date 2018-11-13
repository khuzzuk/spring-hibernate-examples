package pl.khuzzuk.springdata.db;

import lombok.Data;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Data
@Entity
public class Person {
    @EmbeddedId
    private PersonPK personPK;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "city", column = @Column(name = "person_address_city")),
            @AttributeOverride(name = "street", column = @Column(name = "person_address_street")),
            @AttributeOverride(name = "houseNumber", column = @Column(name = "person_address_house")),
            @AttributeOverride(name = "flatNumber", column = @Column(name = "person_address_flat")),
            @AttributeOverride(name = "postalCode", column = @Column(name = "person_address_postal_code")),
    })
    private Address address;
}
