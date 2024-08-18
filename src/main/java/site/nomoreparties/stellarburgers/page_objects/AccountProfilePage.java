package site.nomoreparties.stellarburgers.page_objects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountProfilePage extends BasePage {

    public AccountProfilePage(WebDriver driver) {
        super(driver);
    }

    //--LOCATORS--

    //Account-Profile Page URL
    private String accountProfilePageUrl = "https://stellarburgers.nomoreparties.site/account/profile";

    public String getRegisterPageUrl() {
        return accountProfilePageUrl;
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

    //'Name' input field 'Edit' button locator
    private final By nameInputFieldEditButton = By
            .xpath(".//label[text() = 'Имя']/../div");

    //'Email' input field 'Edit' button locator
    private final By emailInputFieldEditButton = By
            .xpath(".//label[text() = 'Email']/../div");

    //'Password' input field 'Edit' button locator
    private final By passwordInputFieldEditButton = By
            .xpath(".//label[text() = 'Пароль']/../div");

    //'Save' button locator
    private final By saveButton = By
            .xpath(".//button[text() = 'Сохранить']");

    //'Cancel' button locator
    private final By cancelButton = By
            .xpath(".//button[text() = 'Отмена']");

    //'Profile section' button locator
    private final By profileSectionButton = By
            .xpath(".//a[text() = 'Профиль']");

    //'Order history section' button locator
    private final By orderHistorySectionButton = By
            .xpath(".//a[text() = 'История заказов']");

    //'Log out' button locator
    private final By logOutButton = By
            .xpath(".//button[text() = 'Выход']");

    //--ACTIONS--

    //Click on 'Save' button
    @Step("Click on 'Save' button")
    public void clickOnSaveButton() {
        WebElement saveButtonElement = driver.findElement(saveButton);
        saveButtonElement.click();
    }

    //Click on 'Cancel' button
    @Step("Click on 'Cancel' button")
    public void clickOnCancelButton() {
        driver.findElement(cancelButton).click();
    }

    //Click 'Edit' button for 'Name' input field
    @Step("EClick 'Edit' button for 'Name' input field")
    public void clickNameEditButton() {
        WebElement nameEditButtonElement = driver.findElement(nameInputFieldEditButton);
        nameEditButtonElement.click();
    }

    //Click 'Edit' button for 'Email' input field
    @Step("EClick 'Edit' button for 'Email' input field")
    public void clickEmailEditButton() {
        WebElement emailEditButtonElement = driver.findElement(emailInputFieldEditButton);
        emailEditButtonElement.click();
    }

    //Click 'Edit' button for 'Password' input field
    @Step("EClick 'Edit' button for 'Password' input field")
    public void clickPasswordEditButton() {
        WebElement passwordEditButtonElement = driver.findElement(passwordInputFieldEditButton);
        passwordEditButtonElement.click();
    }

    //Enter name to 'Name' input field
    @Step("Enter name {incomingName} to 'Name' input field")
    public void enterName(String incomingName) {
        WebElement nameInputFieldElement = driver.findElement(nameInputField);
        nameInputFieldElement.sendKeys(incomingName);
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
        WebElement passwordInputFieldElement = driver.findElement(passwordInputField);
        passwordInputFieldElement.sendKeys(incomingPassword);
    }

    //Get text from 'Name' input field
    @Step("Get text from 'Name' input field")
    public String getTextFromName() {
        WebElement nameInputFieldElement = driver.findElement(nameInputField);
        return nameInputFieldElement.getText();
    }

    //Get text from 'Email' input field
    @Step("Get text from 'Email' input field")
    public String getTextFromEmail() {
        WebElement emailInputFieldElement = driver.findElement(emailInputField);
        return emailInputFieldElement.getText();
    }

    //Click on 'Profile section' button
    @Step("Click on 'Profile section' button")
    public void clickOnProfileSectionButton() {
        WebElement profileSectionButtonElement = driver.findElement(profileSectionButton);
        profileSectionButtonElement.click();
    }

    //Click on 'Order history section' button
    @Step("Click on 'Order history section' button")
    public void clickOnOrderHistorySectionButton() {
        WebElement orderHistorySectionButtonElement = driver.findElement(orderHistorySectionButton);
        orderHistorySectionButtonElement.click();
    }

    //Click on 'Log out' button
    @Step("Click on 'Log out' button")
    public void clickOnLogOutButton() {
        WebElement logOutButtonElement = driver.findElement(logOutButton);
        logOutButtonElement.click();
    }
}
