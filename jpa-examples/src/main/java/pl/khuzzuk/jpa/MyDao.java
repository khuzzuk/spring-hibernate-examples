package pl.khuzzuk.jpa;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

@Component
public class MyDao {
    @PersistenceContext(unitName = "primarySource")
    private EntityManagerFactory primarySource;

    public Person savePerson(Person person) {
        EntityManager entityManager = primarySource.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.persist(person);

        transaction.commit();

        return person;
    }
}
