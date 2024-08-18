package site.nomoreparties.stellarburgers;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.constants.URLS;
import site.nomoreparties.stellarburgers.dto.ExtendedUser;
import site.nomoreparties.stellarburgers.dto.User;
import site.nomoreparties.stellarburgers.page_objects.*;
import site.nomoreparties.stellarburgers.utils.HTTPRequestRequestClient;

public class UserLogOutTest extends BaseTest {

    private User user;
    private ExtendedUser existingExtendedUser;

    //Set user data for tests
    private final String browser = "chrome";
    private final String email = RandomStringUtils.randomAlphabetic(7).toLowerCase() + "@" + RandomStringUtils
            .randomAlphabetic(7).toLowerCase() + ".com";
    private final String password = RandomStringUtils.random(10, true, true);
    private final String name = RandomStringUtils.randomAlphabetic(10).toLowerCase();

    public UserLogOutTest() {
        driver = getWebDriver();
        MainPage mainPage = new MainPage(driver);
        setUpDriver(mainPage.getMainPageUrl());
    }

    @Before
    @DisplayName("Creating user for test")
    @Description("Creating user for test")
    public void setup() {
        user = new User(email, password, name);
        HTTPRequestRequestClient httpRequestClient = new HTTPRequestRequestClient();
        Response response = httpRequestClient.sendPostRequest(URLS.USER_REGISTER, user);
        existingExtendedUser = httpRequestClient.deserializeResponseAsExtendedUserObject(response, password);
    }

    @Test
    @DisplayName("Logged in User could Log out")
    @Description("Log in as User, enter User Account and click on 'Log out' button and check that User is logged out")
    public void loggedInUserLogOutFromAccount() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginToAccountButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail(user.getEmail());
        loginPage.enterPassword(user.getPassword());
        loginPage.clickOnLogInButton();
        Header header = new Header(driver);
        header.clickAccountButton();
        AccountProfilePage accountProfilePage = new AccountProfilePage(driver);
        accountProfilePage.clickOnLogOutButton();
        Assert.assertTrue(loginPage.verifyLoginTextPresentedOnScreen());
    }

    @After
    @DisplayName("Closing browser and deleting user created for test")
    @Description("Closing browser and deleting user created for test")
    public void tearDown() {
        MainPage mainPage = new MainPage(driver);
        mainPage.closeBrowser();
        HTTPRequestRequestClient httpRequestClient = new HTTPRequestRequestClient();
        user = new User();
        user.setEmail(email);
        user.setPassword(password);

        try {
            Response response = httpRequestClient.sendPostRequest(URLS.USER_LOGIN, user);
            existingExtendedUser = httpRequestClient.deserializeResponseAsExtendedUserObject(response, password);
        } catch (Exception e) {
            System.out.println("User is not registered");
        }

        try {
            httpRequestClient.sendDeleteWAuthRequest(URLS.USER_RUD, existingExtendedUser.getValidAccessToken());
        } catch (Exception e){
            System.out.println("User could not be deleted");
        }
    }

}
