package site.nomoreparties.stellarburgers;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import site.nomoreparties.stellarburgers.page_objects.MainPage;

public class ConstructorSectionsTest extends BaseTest {

    //Set user data for tests
    private final String browser = "chrome";

    public ConstructorSectionsTest() {
        driver = getWebDriver();
        MainPage mainPage = new MainPage(driver);
        setUpDriver(mainPage.getMainPageUrl());
    }

    @Test
    @DisplayName("'Buns' section could be opened by 'Buns' tab")
    @Description("Click on 'Buns' tab at Constructor and check that 'Buns' section is opened")
    public void bunsSectionOpenedByBunsTab() {
        MainPage mainPage = new MainPage(driver);
        //We need to click any other tab to activate 'Buns' tab
        mainPage.clickSauceTab();
        mainPage.clickBunsTab();
        Assert.assertTrue(mainPage.verifyBunsSectionHeaderOpenedOnScreen());
    }

    @Test
    @DisplayName("'Sauce' section could be opened by 'Sauce' tab")
    @Description("Click on 'Sauce' tab at Constructor and check that 'Sauce' section is opened")
    public void sauceSectionOpenedBySauceTab() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickSauceTab();
        Assert.assertTrue(mainPage.verifySauceSectionHeaderOpenedOnScreen());
    }

    @Test
    @DisplayName("'Main' section could be opened by 'Main' tab")
    @Description("Click on 'Main' tab at Constructor and check that 'Main' section is opened")
    public void mainSectionOpenedByBunsTab() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickMainTab();
        Assert.assertTrue(mainPage.verifyMainSectionHeaderOpenedOnScreen());
    }

    @After
    @DisplayName("Closing browser and deleting user created for test")
    @Description("Closing browser and deleting user created for test")
    public void tearDown() {
        MainPage mainPage = new MainPage(driver);
        mainPage.closeBrowser();
    }

}
