package pl.khuzzuk.jpa.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.khuzzuk.jpa.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@RequiredArgsConstructor
@Component
public class MySecondDao {
    private final EntityManagerFactory secondarySource;
    private EntityManager currentEntityManager;

    public Person savePersonWithoutClosing(Person person) {
        currentEntityManager = secondarySource.createEntityManager();
        currentEntityManager.getTransaction().begin();
        currentEntityManager.persist(person);
        return person;
    }

    public void commitTransaction() {
        currentEntityManager.getTransaction().commit();
        currentEntityManager.close();
    }

    public Person find(Long id) {
        EntityManager entityManager = secondarySource.createEntityManager();
        Person person = entityManager.find(Person.class, id);
        entityManager.close();
        return person;
    }
}
