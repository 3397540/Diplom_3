package site.nomoreparties.stellarburgers.page_objects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //--LOCATORS--

    //Login Page URL
    private String loginPageUrl = "https://stellarburgers.nomoreparties.site/login";

    public String getLoginPageUrl() {
        return loginPageUrl;
    }

    //'Вход' text locator
    private final By enterText = By
            .xpath(".//main/div/h2[text() = 'Вход']");

    //'Email' input field locator
    private final By emailInputField = By
            .xpath(".//input[@type = 'text']");

    //'Password' input field locator
    private final By passwordInputField = By
            .xpath(".//input[@type = 'password']");

    //'Show password' button locator
    private final By showPasswordButton = By
            .xpath(".//label[text() = 'Пароль']/../div");

    //'Log in' button locator
    private final By logInButton = By
            .xpath(".//button[text() = 'Войти']");

    //'Register' button locator
    private final By registerButton = By
            .xpath(".//a[text() = 'Зарегистрироваться']");

    //'Forgot password' button locator
    private final By forgotPasswordButton = By
            .xpath(".//a[text() = 'Восстановить пароль']");

    //--ACTIONS--

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

    //Click on 'Show password' button
    @Step("Click on 'Show password' button")
    public void clickOnShowPasswordButton() {
        driver.findElement(showPasswordButton).click();
    }

    //Click on 'Log in' button
    @Step("Click on 'Log in' button")
    public void clickOnLogInButton() {
        driver.findElement(logInButton).click();
    }

    //Click on 'Register' button
    @Step("Click on 'Register' button")
    public void clickOnRegisterButton() {
        driver.findElement(registerButton).click();
    }

    //Click on 'Forgot password' button
    @Step("Click on 'Forgot password' button")
    public void clickOnForgotPasswordButton() {
        driver.findElement(forgotPasswordButton).click();
    }

    //Get text from 'Email' field
    @Step("Get text from 'Email' field")
    public String getTextFromEmailField() {
        return driver.findElement(emailInputField).getText();
    }

    //Get text from 'Password' field
    @Step("Get text from 'Password' field")
    public String getTextFromPasswordField() {
        return driver.findElement(passwordInputField).getText();
    }

    //Verify that 'Вход' text is presented on screen
    @Step("Check that 'Вход' text is presented on screen")
    public boolean verifyLoginTextPresentedOnScreen() {
        WebElement enterTextElement = driver.findElement(enterText);
        return checkElementIsVisible(enterTextElement);
    }
}
