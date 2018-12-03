package pl.khuzzuk.springtest.bean.configuration

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import pl.khuzzuk.springtest.bean.MyBean
import spock.lang.Specification

@ContextConfiguration
class GroovyConfigurationSpec extends Specification {
    @Autowired
    MyBean myBean

    def "test component scanning"() {
        expect: "scanned myBean"
        myBean
        myBean.myOtherBean.myValue == 'my value'
    }
}
