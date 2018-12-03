package pl.khuzzuk.springtest.bean.hierarchy

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.ContextHierarchy
import pl.khuzzuk.springtest.bean.MyBean
import pl.khuzzuk.springtest.bean.MyOtherBean
import spock.lang.Specification

@ContextHierarchy([
        @ContextConfiguration(classes = MyOtherBean),
        @ContextConfiguration(classes = MyBean),
])
class HierarchySpec extends Specification {
    @Autowired
    MyBean myBean

    def "check hierarchy"() {
        expect: "hierarchy match"
        myBean
        myBean.myOtherBean
    }
}
