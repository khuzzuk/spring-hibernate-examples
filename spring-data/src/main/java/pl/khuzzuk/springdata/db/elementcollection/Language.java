package pl.khuzzuk.springdata.db.elementcollection;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(schema = "bibliography")
@Entity
public class Language {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String name;
}
