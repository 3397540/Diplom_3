package site.nomoreparties.stellarburgers.page_objects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Header extends BasePage {

    public Header(WebDriver driver) {
        super(driver);
    }

    //--LOCATORS--

    //'Constructor' button
    private final By constructorButton = By
            .xpath(".//p[text() = 'Конструктор']/..");

    //'Feed' button
    private final By feedButton = By
            .xpath(".//p[text() = 'Лента Заказов']/..");

    //'Stellar Burgers' logo
    private final By logoButton = By
            .xpath(".//div[@class = 'AppHeader_header__logo__2D0X2']/a[@href ='/']");

    //'Account' button locator
    private final By accountButton = By
            .xpath(".//p[text() ='Личный Кабинет']");

    //--ACTIONS--

    //Click on 'Account' button
    @Step("Click on 'Account' button")
    public void clickAccountButton() {
        WebElement accountButtonElement = driver.findElement(accountButton);
        accountButtonElement.click();
    }

    //Click on 'Logo' button
    @Step("Click on 'Logo' button")
    public void clickLogoButton() {
        WebElement accountButtonElement = driver.findElement(logoButton);
        accountButtonElement.click();
    }

    //Click on 'Feed' button
    @Step("Click on 'Feed' button")
    public void clickFeedButton() {
        WebElement feedButtonElement = driver.findElement(feedButton);
        feedButtonElement.click();
    }

    //Click on 'Constructor' button
    @Step("Click on 'Constructor' button")
    public void clickConstructorButton() {
        WebElement constructorButtonElement = driver.findElement(constructorButton);
        constructorButtonElement.click();
    }
}
