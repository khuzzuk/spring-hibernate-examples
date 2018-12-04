package pl.khuzzuk.springtest.bean.configuration

import org.springframework.beans.factory.groovy.GroovyBeanDefinitionReader
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.support.GenericApplicationContext
import pl.khuzzuk.springtest.bean.MyBean
import pl.khuzzuk.springtest.bean.XmlConfiguredBean
import spock.lang.Specification

class DefinitionReaderSpec extends Specification {
    def "check multiple readers in one context"() {
        when:
        GenericApplicationContext context = new AnnotationConfigApplicationContext()
        context.getEnvironment().setActiveProfiles('groovy1')

        new GroovyBeanDefinitionReader(context).loadBeanDefinitions('/pl/khuzzuk/springtest/bean/configuration/GroovyConfigurationSpecContext.groovy')
        new XmlBeanDefinitionReader(context).loadBeanDefinitions('/pl/khuzzuk/springtest/bean/configuration/AnnotationAndXmlSpec-context.xml')

        context.refresh()
        def bean = context.getBean(MyBean)
        def xmlConfiguredBean = context.getBean(XmlConfiguredBean)

        then:
        with(bean) {
            myOtherBean != null
            myOtherBean.myValue == 'groovy value'
        }

        xmlConfiguredBean
    }
}
