package pl.khuzzuk.springdata.db.mappedsuperclass;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Table(name = "system_email")
@Entity
public class SystemEmailMessage extends EmailMessage {
    private boolean fromSystem;
}
