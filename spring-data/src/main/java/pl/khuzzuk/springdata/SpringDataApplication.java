package pl.khuzzuk.springdata;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.khuzzuk.springdata.db.Person;
import pl.khuzzuk.springdata.db.PersonPK;
import pl.khuzzuk.springdata.repo.PersonRepo;

@SpringBootApplication
public class SpringDataApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataApplication.class, args);
    }
}
