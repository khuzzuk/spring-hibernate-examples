package pl.khuzzuk.springtest.jpa;

import lombok.Data;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "entity", schema = "test")
public class MyEntity {
    @SequenceGenerator(name = "entity_gen", schema = "test", sequenceName = "entity_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "entity_gen")
    @Id
    private Long id;
    @NaturalId
    private String name;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(schema = "test")
    private Set<LinkedEntity> linked;
}
