package pl.khuzzuk.springdata.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.khuzzuk.springdata.db.Person;
import pl.khuzzuk.springdata.db.PersonPK;

public interface PersonRepo extends JpaRepository<Person, PersonPK> {
}
