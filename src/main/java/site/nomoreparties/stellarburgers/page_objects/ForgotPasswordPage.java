package site.nomoreparties.stellarburgers.page_objects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPasswordPage extends BasePage {

    private String email;

    public void setEmail(String email) {
        this.email = email;
    }

    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
    }

    //Register Page URL
    private String forgotPasswordPageUrl = "https://stellarburgers.nomoreparties.site/forgot-password";

    public String getForgotPasswordPageUrl() {
        return forgotPasswordPageUrl;
    }

    //--LOCATORS--

    //'Email' input field locator
    private final By emailInputField = By
            .xpath(".//label[text() = 'Email']/../input");

    //'Recover' button locator
    private final By recoverButton = By
            .xpath(".//button[text() = 'Восстановить']");

    //'Log in' button locator
    private final By logInButton = By
            .xpath(".//a[text() = 'Войти']");

    //--ACTIONS--

    //Enter email to 'Email' input field
    @Step("Enter email {incomingEmail} to 'Email' input field")
    public void enterEmail(String incomingEmail) {
        WebElement emailInputFieldElement = driver.findElement(emailInputField);
        emailInputFieldElement.sendKeys(incomingEmail);
    }

    //Click 'Recover' button
    @Step("Click 'Recover' button")
    public void clickRecoverButton() {
        driver.findElement(recoverButton).click();
    }

    //Click 'Log in' button
    @Step("Click 'Log in' button")
    public void clickLogInButton() {
        driver.findElement(logInButton).click();
    }
}
