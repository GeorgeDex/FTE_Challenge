package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageObjects.HomePage;

public class HomeSteps extends BaseSteps{
    public HomeSteps(WebDriver webDriver) {
        super(webDriver);
    }

    HomePage homePage = PageFactory.initElements(webDriver, HomePage.class);

}
