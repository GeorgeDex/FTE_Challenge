package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import steps.HomeSteps;
import steps.LoginSteps;
import steps.NewPostSteps;
import steps.UpdatePostSteps;

public class BaseTests {
    WebDriver driver = getDriver();
    LoginSteps loginSteps = new LoginSteps(driver);
    HomeSteps homeSteps = new HomeSteps(driver);
    NewPostSteps newPostSteps = new NewPostSteps(driver);
    UpdatePostSteps updatePostSteps = new UpdatePostSteps(driver);

    private WebDriver getDriver() {
        setupDriver();
        driver.get("https://sheltered-mesa-19374.herokuapp.com/");
        return driver;
    }

    private void setupDriver() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Test Begins!");
    }

    @AfterTest(alwaysRun = true)
    public void afterTest() {
        System.out.println("Quitting driver...");
        driver.quit();
    }
}
