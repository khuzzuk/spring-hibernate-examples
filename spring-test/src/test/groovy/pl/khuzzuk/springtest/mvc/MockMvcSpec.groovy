package pl.khuzzuk.springtest.mvc

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.mock.web.MockHttpSession
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import pl.khuzzuk.springtest.bean.MyOtherBean
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post

@ContextConfiguration(classes = [TestController, MockMvcConfiguration])
class MockMvcSpec extends Specification {
    @Autowired
    MockMvc mockMvc

    def "check mvc get"() {
        when:
        def response = mockMvc.perform(get("/test/get")).andReturn().response

        then:
        response.status == 200
    }

    def "check mvc post"() {
        given:
        MyOtherBean myOtherBean = new MyOtherBean()
        myOtherBean.myValue = 'test value'
        ObjectMapper mapper = new ObjectMapper()
        String content = mapper.writeValueAsString(myOtherBean)

        when:
        def response = mockMvc.perform(post("/test/post")
                .content(content)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andReturn().response

        then:
        with(response) {
            response.status == 200
        }
    }

    def "repeat tests"() {
        when:
        def servletPath = get("/test/get")
        def action = mockMvc.perform(servletPath)

        then:
        action.andExpect(MockMvcResultMatchers.status().isOk())
        action.andExpect(MockMvcResultMatchers.status().isOk()) //from cache
        action.andExpect(MockMvcResultMatchers.status().isOk())
        action.andExpect(MockMvcResultMatchers.status().isOk())
    }

    @Configuration
    static class MockMvcConfiguration {
        @Bean
        MockMvc mockMvc(TestController testController) {
            return MockMvcBuilders.standaloneSetup(testController).build()
        }

        MockHttpServletRequestBuilder requestPrepare(MockMvc mockMvc) {
            return get().contextPath("test").accept(MediaType.APPLICATION_JSON_UTF8)
        }
    }
}
