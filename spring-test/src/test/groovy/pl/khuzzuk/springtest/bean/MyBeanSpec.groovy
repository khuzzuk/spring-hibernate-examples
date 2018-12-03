package pl.khuzzuk.springtest.bean


import org.spockframework.spring.SpringBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@ContextConfiguration(classes = [MyBean])
class MyBeanSpec extends Specification {
    @Autowired
    MyBean myBean

    @SpringBean
    MyOtherBean myOtherBean = Mock()

    def "check context"() {
        when:
        myBean.warnTest()

        then: "bean has mock in dependencies"
        1 *  myOtherBean.warnTest()
    }
}
