package site.nomoreparties.stellarburgers.page_objects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    //--LOCATORS--

    //Main Page URL
    private static String mainPageUrl = "https://stellarburgers.nomoreparties.site/";

    public String getMainPageUrl() {
        return mainPageUrl;
    }

    //'Account' button locator
    private final By accountButton = By
            .xpath(".//p[text() ='Личный Кабинет']");

    //'Login to Account' button locator
    private final By logInToAccountButton = By
            .xpath(".//button[text() ='Войти в аккаунт']");

    //'Buns' tab
    private final By bunsTab = By
            .xpath(".//span[text() = 'Булки']/..");

    //'Sauce' tab
    private final By sauceTab = By
            .xpath(".//span[text() = 'Соусы']/..");

    //'Main' tab
    private final By mainTab = By
            .xpath(".//span[text() = 'Начинки']/..");

    //Selected tab locator
    private final By selectedTab = By
            .cssSelector(".tab_tab__1SPyG.tab_tab_type_current__2BEPc.pt-4.pr-10.pb-4.pl-10.noselect");

    //'Соберите бургер' text locator
    private final By constructBurgerText = By
            .xpath(".//main/section/h1[text() = 'Соберите бургер']");

    //--ACTIONS--

    //Click on 'Login to Account' button
    @Step("Click on 'Login to Account' button")
    public void clickLoginToAccountButton() {
        WebElement logInToAccountButtonElement = driver.findElement(logInToAccountButton);
        logInToAccountButtonElement.click();
    }

    //Click on 'Buns' tab
    @Step("Click on 'Buns' tab")
    public void clickBunsTab() {
        WebElement bunsTabElement = driver.findElement(bunsTab);
        bunsTabElement.click();
    }

    //Click on 'Sauce' tab
    @Step("Click on 'Sauce' tab")
    public void clickSauceTab() {
        WebElement sauceTabElement = driver.findElement(sauceTab);
        sauceTabElement.click();
    }

    //Click on 'Main' tab
    @Step("Click on 'Main' tab")
    public void clickMainTab() {
        WebElement mainTabElement = driver.findElement(mainTab);
        mainTabElement.click();
    }

    //Get text from selected tab
    @Step("Get text from selected tab")
    public String getSelectedTab() {
        WebElement selectedTabElement = driver.findElement(selectedTab);
        return selectedTabElement.getText();
    }

    //Verify that 'Вход' text is presented on screen
    @Step("Check that 'Соберите бургер' text is presented on screen")
    public boolean verifyConstructBurgerTextPresentedOnScreen() {
        WebElement enterTextElement = driver.findElement(constructBurgerText);
        return checkElementIsVisible(enterTextElement);
    }

    //Verify that 'Buns' section is opened on screen
    @Step("Check that 'Buns' section is opened on screen")
    public boolean verifyBunsSectionHeaderOpenedOnScreen() {
        return getSelectedTab().equals("Булки");
    }

    //Verify that 'Sauce' section is opened on screen
    @Step("Check that 'Sauce' section is opened on screen")
    public boolean verifySauceSectionHeaderOpenedOnScreen() {
        return getSelectedTab().equals("Соусы");
    }

    //Verify that 'Main' section is opened on screen
    @Step("Check that 'Main' section is opened on screen")
    public boolean verifyMainSectionHeaderOpenedOnScreen() {
        return getSelectedTab().equals("Начинки");
    }
}
