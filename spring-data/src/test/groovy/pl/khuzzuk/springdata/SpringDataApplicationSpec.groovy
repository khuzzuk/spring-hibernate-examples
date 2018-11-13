package pl.khuzzuk.springdata

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import pl.khuzzuk.springdata.db.Address
import pl.khuzzuk.springdata.db.Person
import pl.khuzzuk.springdata.db.PersonPK
import pl.khuzzuk.springdata.repo.PersonRepo
import spock.lang.Specification

@DataJpaTest
class SpringDataApplicationSpec extends Specification {
    @Autowired
    private PersonRepo personRepo

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

        then: 'check data from db'
        result.isPresent()
        result.get() == person
    }
}
