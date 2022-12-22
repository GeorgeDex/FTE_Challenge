package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageObjects.LoginPage;

public class LoginSteps extends BaseSteps{

    LoginPage loginPage = PageFactory.initElements(webDriver, LoginPage.class);

    public LoginSteps(WebDriver webDriver) {
        super(webDriver);
    }

    public void logIn() {
        loginPage.getUsername().sendKeys("jm0921");
        loginPage.getPassword().sendKeys(".jamvFTE@");
        loginPage.getLoginButton().click();
    }
}
