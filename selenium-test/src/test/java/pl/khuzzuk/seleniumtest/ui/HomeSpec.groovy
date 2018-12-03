package pl.khuzzuk.seleniumtest.ui

import io.github.bonigarcia.wdm.WebDriverManager
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.PageFactory
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Shared
import spock.lang.Specification

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class HomeSpec extends Specification {
    @Shared
    WebDriver webDriver

    void setupSpec() {
        WebDriverManager.chromedriver().setup()
        webDriver = new ChromeDriver()
    }

    void setup() {
        webDriver.get("http://localhost:8080/home")
    }

    void cleanupSpec() {
        webDriver.quit()
    }

    def "check loaded home page"() {
        when:
        def homePage = PageFactory.initElements(webDriver, HomePage)

        then:
        homePage.label
    }
}
