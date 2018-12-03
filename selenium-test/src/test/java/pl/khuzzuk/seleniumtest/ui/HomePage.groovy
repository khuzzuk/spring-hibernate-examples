package pl.khuzzuk.seleniumtest.ui

import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class HomePage {
    @FindBy(tagName = "label")
    WebElement label
}
