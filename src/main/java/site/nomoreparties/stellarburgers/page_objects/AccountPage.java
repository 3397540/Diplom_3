package site.nomoreparties.stellarburgers.page_objects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountPage extends BasePage {

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    //--LOCATORS--

    //Account text locator
    private final By userAccountText = By
            .xpath(".//p[text() = 'В этом разделе вы можете изменить свои персональные данные']");

    //--ACTIONS--

    //Verify that Account text is presented on page
    @Step("Check if User Account is opened")
    public boolean verifyUserAccountText() {
        WebElement userAccountTextElement = driver.findElement(userAccountText);
        return checkElementIsVisible(userAccountTextElement);
    }
}
