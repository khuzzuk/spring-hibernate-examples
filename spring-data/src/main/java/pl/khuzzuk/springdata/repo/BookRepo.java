package pl.khuzzuk.springdata.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.khuzzuk.springdata.db.elementcollection.Book;

public interface BookRepo extends JpaRepository<Book, Long> {
}
