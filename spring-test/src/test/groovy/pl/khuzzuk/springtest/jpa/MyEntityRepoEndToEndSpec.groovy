package pl.khuzzuk.springtest.jpa

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import spock.lang.Specification

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class MyEntityRepoEndToEndSpec extends Specification {
    @Autowired
    EntityController entityController

    @Autowired
    TestRestTemplate restTemplate

    @Autowired
    MyEntityRepo myEntityRepo

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
        def results = restTemplate.postForObject("http://localhost:8080/entity/create", myEntity, MyEntity)

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
