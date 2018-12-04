import org.springframework.core.io.ClassPathResource
import pl.khuzzuk.springtest.bean.MyBean
import pl.khuzzuk.springtest.bean.MyOtherBean

def properties = new Properties()
properties.load(new ClassPathResource('some.properties').inputStream)

beans {
    myOtherBean(MyOtherBean) {
        if (environment.activeProfiles.contains('groovy1')) {
            myValue = properties.get('groovy.property')
        } else {
            myValue = 'my value'
        }
    }
    myBean(MyBean, myOtherBean)
}