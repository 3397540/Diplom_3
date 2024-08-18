package site.nomoreparties.stellarburgers.page_objects;

import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    //Scroll to Element if it is not visible
    public void checkVisibilityAndScroll(WebElement element) {
        checkElementIsVisible(element);
        scrollToElement(element);
    }

    //Scrolling to Element
    public void scrollToElement(WebElement element) {
        WebElement elementToShow = element;
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", elementToShow);
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(elementToShow));
    }

    //Deleting cookies and closing browser
    @Step("Deleting cookies and closing browser")
    public void closeBrowser() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }

    //Check if Element is Visible
    @Step("Check if element {element} is visible")
    public boolean checkElementIsVisible(WebElement element) {
        return element.isDisplayed();
    }

    //Wait for element is visible
    @Step("Wait {timeout} seconds until {element} element is visible")
    public void waitForElement(int timeout, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
