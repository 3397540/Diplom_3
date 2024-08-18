package site.nomoreparties.stellarburgers.page_objects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage extends BasePage {

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    //--LOCATORS--

    //Register Page URL
    private String registerPageUrl = "https://stellarburgers.nomoreparties.site/register";

    public String getRegisterPageUrl() {
        return registerPageUrl;
    }

    //'Name' input field locator
    private final By nameInputField = By
            .xpath(".//label[text() = 'Имя']/../input");

    //'Email' input field locator
    private final By emailInputField = By
            .xpath(".//label[text() = 'Email']/../input");

    //'Password' input field locator
    private final By passwordInputField = By
            .xpath(".//label[text() = 'Пароль']/../input");

    //'Register' button locator
    private final By registerButton = By
            .xpath(".//button[text() = 'Зарегистрироваться']");

    //'Log in' button locator
    private final By logInButton = By
            .xpath(".//a[text() = 'Войти']");

    //'Invalid password' error text
    private final By invalidPasswordError = By
            .xpath(".//p[text() ='Некорректный пароль']");

    //--ACTIONS--

    //Click on 'Register' button
    @Step("Click on 'Register' button")
    public void clickOnRegisterButton() {
        WebElement registerButtonElement = driver.findElement(registerButton);
        registerButtonElement.click();
    }

    //Click on 'Log in' button
    @Step("Click on 'Log in' button")
    public void clickOnLogInButton() {
        driver.findElement(logInButton).click();
    }

    //Enter name to 'Name' input field
    @Step("Enter name {incomingName} to 'Name' input field")
    public void enterName(String incomingName) {
        WebElement emailInputFieldElement = driver.findElement(nameInputField);
        emailInputFieldElement.sendKeys(incomingName);
    }

    //Enter email to 'Email' input field
    @Step("Enter email {incomingEmail} to 'Email' input field")
    public void enterEmail(String incomingEmail) {
        WebElement emailInputFieldElement = driver.findElement(emailInputField);
        emailInputFieldElement.sendKeys(incomingEmail);
    }

    //Enter password to 'Password' input field
    @Step("Enter password {incomingPassword} to 'Password' input field")
    public void enterPassword(String incomingPassword) {
        WebElement emailInputFieldElement = driver.findElement(passwordInputField);
        emailInputFieldElement.sendKeys(incomingPassword);
    }

    //Verify that 'Invalid password' error is presented on page
    @Step("Trying to find 'Invalid password' error")
    public boolean verifyInvalidPasswordError() {
        WebElement invalidPasswordErrorElement = driver.findElement(invalidPasswordError);
        return checkElementIsVisible(invalidPasswordErrorElement);
    }
}
