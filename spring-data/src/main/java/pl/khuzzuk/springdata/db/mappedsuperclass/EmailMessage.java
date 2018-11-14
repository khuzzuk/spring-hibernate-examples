package pl.khuzzuk.springdata.db.mappedsuperclass;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Data
@Table(name = "email")
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class EmailMessage extends Message {
    private String email;
    private String subject;
}
