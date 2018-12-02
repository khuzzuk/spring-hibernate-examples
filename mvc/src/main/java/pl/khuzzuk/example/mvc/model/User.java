package pl.khuzzuk.example.mvc.model;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class User {
    private @Length(min = 6) String name;
    private String password;
}
