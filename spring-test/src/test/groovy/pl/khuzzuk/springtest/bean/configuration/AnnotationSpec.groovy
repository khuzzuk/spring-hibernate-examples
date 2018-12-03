package pl.khuzzuk.springtest.bean.configuration

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.test.context.ContextConfiguration
import pl.khuzzuk.springtest.bean.MyBean
import spock.lang.Specification

@ContextConfiguration
class AnnotationSpec extends Specification {
    @Autowired
    MyBean myBean

    def "test component scanning"() {
        expect: "scanned myBean"
        myBean
    }

    @Configuration
    @ComponentScan('pl.khuzzuk.springtest.bean')
    static class AnnotationConfiguration {
    }
}
