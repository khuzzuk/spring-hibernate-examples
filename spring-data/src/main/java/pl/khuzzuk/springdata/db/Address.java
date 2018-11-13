package pl.khuzzuk.springdata.db;

import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class Address {
    private String city;
    private String street;
    private String houseNumber;
    private String flatNumber;
    private String postalCode;
}
