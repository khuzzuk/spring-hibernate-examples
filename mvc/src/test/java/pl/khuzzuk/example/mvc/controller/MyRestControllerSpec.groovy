package pl.khuzzuk.example.mvc.controller


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.web.server.LocalServerPort
import pl.khuzzuk.example.mvc.model.User
import spock.lang.Specification

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MyRestControllerSpec extends Specification {
    @LocalServerPort
    int localServerPort

    @Autowired
    MyRestController myRestController

    @Autowired
    TestRestTemplate restTemplate
    private static final String MAPPING_PREFIX = 'http://localhost:'

    def "check getUser"() {
        when:
        def result = restTemplate.getForObject(MAPPING_PREFIX + localServerPort + '/getUser', User)

        then:
        with(result) {
            name == 'Admin'
        }
    }

    def "check put mapping"() {
        given:
        User user = new User()
        user.name = 'new user'

        myRestController.resetCurrentUser()

        when:
        restTemplate.put(MAPPING_PREFIX + localServerPort + "/saveUser", user)

        then:
        with(myRestController.currentUser) {
            name == 'new user'
        }
    }
    def "check invalid current user not inserted"() {
        given:
        User user = new User()
        user.name = 'a'

        myRestController.resetCurrentUser()

        when:
        restTemplate.put(MAPPING_PREFIX + localServerPort + "/saveUser", user)

        then:
        myRestController.currentUser == null
    }

    def "check put mapping with path variable"() {
        given:
        myRestController.resetCurrentUser()

        when:
        def user = restTemplate.getForObject(MAPPING_PREFIX + localServerPort + "/simpleSaveUser/simpleUser", User)

        then:
        with(myRestController.currentUser) {
            name == 'simpleUser'
        }
        user == myRestController.currentUser
    }
}
