package pl.khuzzuk.springdata;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.khuzzuk.springdata.db.elementcollection.Book;
import pl.khuzzuk.springdata.repo.BookRepo;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@SpringBootApplication
public class SpringDataApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataApplication.class, args);
    }

    public CommandLineRunner dbRunner(EntityManager entityManager, BookRepo bookRepo) {
        return args -> {
            Book book = new Book();
            book.setTitle("Title");
            bookRepo.save(book);

            String sql = "from Book";
            Query query = entityManager.createQuery(sql);
            List resultList = query.getResultList();
            resultList.iterator().forEachRemaining(System.out::println);
        };
    }
}
