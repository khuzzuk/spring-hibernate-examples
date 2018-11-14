package pl.khuzzuk.springdata.db;

import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@Entity
@DiscriminatorValue("EMPLOYEE")
public class Employee extends PersonInherited {
    private String jobPosition;
    private double salary;
}
