package pl.khuzzuk.springtest

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import pl.khuzzuk.springtest.bean.MyBean
import spock.lang.Specification

import javax.persistence.EntityManager

@ContextConfiguration(classes = SpringTestApplication)
class ApplicationInheritConfigurationSpec extends Specification {
    @Autowired
    MyBean myBean

    @Autowired
    private EntityManager entityManager

    def "test global context from config"() {
        expect: "my bean in the context"
        myBean
    }

    def "test entity manager properly configured"() {
        expect: "entity manager configured and injected"
        entityManager
    }
}
