package site.nomoreparties.stellarburgers;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    WebDriver driver;

    WebDriver getWebDriver(){
        String browser = System.getProperty("browser", "chrome");
        switch (browser){
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "/Users/noname/WebDriver/bin/chromedriver");
                return new ChromeDriver();
            case "yandex":
                System.setProperty("webdriver.chrome.driver","/Users/noname/WebDriver/bin/yandexdriver");
                ChromeOptions options = new ChromeOptions().setBinary("/Applications/Yandex.app/Contents/MacOS/Yandex");
                return new ChromeDriver(options);
            default:
                throw new RuntimeException("Incorrect BrowserName");
        }
    }

    public void setUpDriver(String url) {
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        driver.manage().timeouts().pageLoadTimeout(30000, TimeUnit.MILLISECONDS);
        driver.manage().timeouts().setScriptTimeout(10000, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();
        driver.get(url);
    }
}
