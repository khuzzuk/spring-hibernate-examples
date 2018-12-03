package pl.khuzzuk.springtest.bean

import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@ContextConfiguration(classes = [MyBean])
class MyBeanMockitoSpec extends Specification {
    @Autowired
    MyBean myBean

    @MockBean
    MyOtherBean myOtherBean

    def "check context"() {
        when:
        myBean.warnTest()

        then: "bean has mock in dependencies"
        Mockito.verify(myOtherBean).warnTest()
    }
}
