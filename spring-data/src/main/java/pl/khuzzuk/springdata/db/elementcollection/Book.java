package pl.khuzzuk.springdata.db.elementcollection;

import lombok.Data;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.SortNatural;

import javax.persistence.*;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;

@NamedQuery(name = "Book.getByTitle", query = "SELECT b FROM Book b WHERE b.title = :title")
@Data
@Table(schema = "bibliography")
@Entity
public class Book {
    @SequenceGenerator(name = "book_id_gen", schema = "bibliography", sequenceName = "book_seq", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_id_gen")
    private Long id;
    @NaturalId
    private String title;
    @ElementCollection
    @JoinTable(schema = "bibliography")
    private List<String> tags;
    @ElementCollection
    @JoinTable(schema = "bibliography")
    private List<Publisher> publishers;
    @ElementCollection
    @MapKeyColumn(name = "editions_key")
    @JoinTable(schema = "bibliography")
    private Map<Integer, Integer> editions;
    @OneToMany
    @SortNatural
    private SortedMap<Language, Country> translations;
    @ElementCollection
    @MapKeyEnumerated(EnumType.STRING)
    private Map<ISBNType, String> isbns;
}
