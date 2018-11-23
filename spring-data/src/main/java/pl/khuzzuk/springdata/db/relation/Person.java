package pl.khuzzuk.springdata.db.relation;

import java.util.List;
import java.util.SortedSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(schema = "relation")
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany
    @JoinTable(name = "person_addresses",
            schema = "relation",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "addresses_id"))
    @OrderBy("street DESC")
    private List<Address> addresses;
    @ManyToMany
    @JoinTable(name = "person_projects",
            schema = "project",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "project_id"))
    @OrderBy("name")
    private SortedSet<Project> projects;
}
