package pl.khuzzuk.springdata.db;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
@Entity
@Table(name = "phone_number",
        schema = "structure")
public class Phone {
    @SequenceGenerator(name = "phone_id_gen",
            schema = "structure",
            sequenceName = "phone_number_seq",
            allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "phone_id_gen")
    private Long id;
    private String number;
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;
    @Enumerated(EnumType.STRING)
    private PhoneType phoneType;
}
