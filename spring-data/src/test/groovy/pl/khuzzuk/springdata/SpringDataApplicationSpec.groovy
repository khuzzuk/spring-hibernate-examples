package pl.khuzzuk.springdata

import io.zonky.test.db.AutoConfigureEmbeddedDatabase
import org.flywaydb.test.annotation.FlywayTest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.context.SpringBootTest
import pl.khuzzuk.springdata.db.Address
import pl.khuzzuk.springdata.db.Person
import pl.khuzzuk.springdata.db.PersonPK
import pl.khuzzuk.springdata.db.elementcollection.Book
import pl.khuzzuk.springdata.db.elementcollection.Publisher
import pl.khuzzuk.springdata.repo.BookRepo
import pl.khuzzuk.springdata.repo.PersonRepo
import spock.lang.Specification

import javax.persistence.EntityManager
import javax.persistence.Query

@SpringBootTest
@AutoConfigureEmbeddedDatabase
class SpringDataApplicationSpec extends Specification {
    @Autowired
    private PersonRepo personRepo
    @Autowired
    private BookRepo bookRepo
    @Autowired
    private EntityManager entityManager

    def "check person"() {
        given: 'creating repository data'
        Person person = new Person()
        PersonPK personPK = new PersonPK()
        personPK.id = 1
        personPK.firstName = 'first name'
        personPK.secondName = 'second name'
        personPK.lastName = 'last name'
        person.personPK = personPK
        Address address = new Address()
        address.city = 'city'
        address.street = 'street'
        address.houseNumber = '1'
        address.flatNumber = '2'
        address.postalCode = '12-123'

        when: 'save data to repository'
        personRepo.save(person)

        Optional<Person> result = personRepo.findById(personPK)

        saveBook('Title1', 'classic', 'fantasy', 'tolkien')
        saveBook('Title2', 'recent', 'fantasy', 'howard')
        saveBook('Title3', 'recent', 'fantasy', 'martin')
        saveBook('Title4', 'recent', 'fantasy')

        String sql = "from Book"
        Query query = entityManager.createQuery(sql)
        List resultList = query.getResultList()
        //resultList.iterator().forEachRemaining({ System.out.println(it) })

        def namedQuery = entityManager.createNamedQuery("Book.getByTitle")
        namedQuery.setParameter("title", "Title")
        namedQuery.getResultList().forEach({ System.out.println(it) })

        def list = entityManager.createQuery("""
                    SELECT new pl.khuzzuk.springdata.db.elementcollection.BookView(b.title) 
                    FROM Book b
            """).getResultList()
        printResults(list)

        def publishers = entityManager.createQuery("""
                    SELECT new pl.khuzzuk.springdata.db.elementcollection.PublisherView(MIN(p.since)) 
                    FROM Book b
                        JOIN b.publishers p
                    WHERE b.title = 'Title1'
                    GROUP BY b.title
            """).getResultList()

        def tagsResult = entityManager.createQuery("""
                FROM Book b
                    JOIN b.tags t
                GROUP BY b
                HAVING COUNT(t) > 2
            """).getResultList()

        def tagsNativeQuery = entityManager.createNativeQuery("""
                  SELECT b.title
                  FROM bibliography.book b
                    JOIN bibliography.book_tags t ON b.id = t.book_id
                  GROUP BY b.title
                  HAVING array_agg(CAST(t.tags AS TEXT)) @> ARRAY ['recent', 'fantasy'];
            """).getResultList()

        def tagsAntijoin = entityManager.createNativeQuery("""
                  SELECT b.title
                  FROM bibliography.book b
                  WHERE NOT EXISTS(SELECT 1 FROM bibliography.book_tags inner_tag 
                                   WHERE inner_tag.tags IN ('recent', 'fantasy')
                                    AND NOT inner_tag.tags IN (SELECT ii_tag.tags FROM bibliography.book_tags ii_tag
                                                               WHERE ii_tag.book_id = b.id))
            """).getResultList()


        then: 'check data from db'
        result.isPresent()
        result.get() == person

    }

    private void printResults(List list) {
        list.forEach({ System.out.println(it) })
    }

    private int counter = 1900
    private void saveBook(String title, String... tags) {
        Publisher publisher1 = new Publisher()
        publisher1.name = 'publisher'
        publisher1.since = counter++
        Publisher publisher2 = new Publisher()
        publisher2.name = 'publisher'
        publisher2.since = counter++

        Book book = new Book()
        book.setTitle(title)
        book.setTags(Arrays.asList(tags))
        book.setPublishers(List.of(publisher1, publisher2))
        bookRepo.save(book);
    }
}
