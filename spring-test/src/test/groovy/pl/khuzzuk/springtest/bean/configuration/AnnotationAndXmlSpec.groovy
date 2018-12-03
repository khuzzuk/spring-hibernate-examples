package pl.khuzzuk.springtest.bean.configuration

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.ImportResource
import org.springframework.context.annotation.Profile
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.TestPropertySource
import pl.khuzzuk.springtest.bean.MyBean
import pl.khuzzuk.springtest.bean.XmlConfiguredBean
import spock.lang.Specification

@ContextConfiguration(classes = AnnotationConfiguration) //have to explicitly declare, no defaults in mixing configurations
@TestPropertySource(properties = ['some.property=xml value'])
@ActiveProfiles('annotation-xml-test')
class AnnotationAndXmlSpec extends Specification {
    @Autowired
    MyBean myBean

    @Autowired
    XmlConfiguredBean xmlConfiguredBean

    def "test component scanning"() {
        expect: "scanned myBean"
        with(myBean) {
            myOtherBean != null
        }

        with (xmlConfiguredBean) {
            someValue == 'xml value'
        }
    }

    @Configuration
    @ComponentScan('pl.khuzzuk.springtest.bean')
    @ImportResource('/pl/khuzzuk/springtest/bean/configuration/AnnotationAndXmlSpec-context.xml')
    @Profile('annotation-xml-test')
    static class AnnotationConfiguration {
    }
}
