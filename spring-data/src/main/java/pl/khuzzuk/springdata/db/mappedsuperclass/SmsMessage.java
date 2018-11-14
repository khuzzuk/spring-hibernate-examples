package pl.khuzzuk.springdata.db.mappedsuperclass;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Table(name = "sms")
@Entity
public class SmsMessage extends Message {
    private String phoneNumber;
}
