package pl.khuzzuk.springtest.jpa;

import lombok.Data;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

@Data
@Entity
@Table(schema = "test")
public class LinkedEntity {
    @SequenceGenerator(name = "linked_entity_gen", schema = "test", sequenceName = "linked_entity_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "linked_entity_gen")
    @Id
    private Long id;
    @NaturalId
    private String name;
}
