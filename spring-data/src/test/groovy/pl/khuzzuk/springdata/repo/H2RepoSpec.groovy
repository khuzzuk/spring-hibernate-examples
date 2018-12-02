package pl.khuzzuk.springdata.repo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import spock.lang.Specification

@DataJpaTest
class H2RepoSpec extends Specification {
    @Autowired
    PersonRepo personRepo

    def "check spring data configuration"() {
        expect:
        personRepo.findAll().size() == 0
    }
}
