package site.nomoreparties.stellarburgers;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import site.nomoreparties.stellarburgers.constants.URLS;
import site.nomoreparties.stellarburgers.dto.ExtendedUser;
import site.nomoreparties.stellarburgers.dto.User;
import site.nomoreparties.stellarburgers.page_objects.LoginPage;
import site.nomoreparties.stellarburgers.page_objects.MainPage;
import site.nomoreparties.stellarburgers.page_objects.RegisterPage;
import site.nomoreparties.stellarburgers.utils.HTTPRequestRequestClient;

public class UserRegisterTest extends BaseTest {

    private User user;
    private ExtendedUser existingExtendedUser;

    //Set user data for tests
    private final String browser = "chrome";
    private final String email = RandomStringUtils.randomAlphabetic(7).toLowerCase() + "@" + RandomStringUtils
            .randomAlphabetic(7).toLowerCase() + ".com";
    private final String password = RandomStringUtils.random(10, true, true);
    private final String name = RandomStringUtils.randomAlphabetic(10).toLowerCase();

    public UserRegisterTest() {
        driver = getWebDriver();
        MainPage mainPage = new MainPage(driver);
        setUpDriver(mainPage.getMainPageUrl());
    }

    @Test
    @DisplayName("User could register with valid password (more than 5 symbols)")
    @Description("Try to register new user with valid password (more than 5 symbols) and check that Login page is opened")
    public void registerUserWithValidPassword() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginToAccountButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickOnRegisterButton();
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.enterName(name);
        registerPage.enterEmail(email);
        registerPage.enterPassword(password);
        registerPage.clickOnRegisterButton();
        Assert.assertTrue(loginPage.verifyLoginTextPresentedOnScreen());
    }

    @Test
    @DisplayName("User could not register with invalid password (less than 6 symbols)")
    @Description("Try to register new user with invalid password (less than 6 symbols) and check that Error is shown")
    public void registerUserWithInvalidPassword() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginToAccountButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickOnRegisterButton();
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.enterName(name);
        registerPage.enterEmail(email);
        registerPage.enterPassword(RandomStringUtils.random(5, true, true));
        registerPage.clickOnRegisterButton();
        Assert.assertTrue(registerPage.verifyInvalidPasswordError());
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
