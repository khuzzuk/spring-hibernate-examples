package pl.khuzzuk.springtest.jpa

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.jdbc.core.JdbcTemplate
import spock.lang.Specification

import javax.persistence.EntityManager

@DataJpaTest
class MyEntityRepoSpec extends Specification {
    @Autowired
    MyEntityRepo myEntityRepo

    @Autowired
    EntityManager entityManager

    @Autowired
    JdbcTemplate jdbcTemplate

    def "check entity"() {
        given:
        MyEntity myEntity = new MyEntity()
        myEntity.name = 'name'
        myEntity.linked = [
                create('1'),
                create('2'),
                create('3'),
                create('4'),
        ] as Set

        when:
        myEntityRepo.save(myEntity)

        entityManager.flush()

        then:
        def entities = myEntityRepo.findAll()

        with(entities) {
            size() == 1
            with(entities.get(0)) {
                linked.size() == 4
            }
        }
    }

    private static LinkedEntity create(String name) {
        LinkedEntity linkedEntity = new LinkedEntity()
        linkedEntity.name = name
        linkedEntity
    }
}
