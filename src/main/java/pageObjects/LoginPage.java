package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(how = How.XPATH, using = "//input[@id='id_username']")
    private WebElement textBoxUsername;

    @FindBy(how = How.NAME, using = "password")
    private WebElement passwordTextBox;

    @FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[1]/div[2]/form[1]/input[2]")
    private WebElement loginButton;

    public WebElement getUsername() { return textBoxUsername; }

    public WebElement getPassword() { return passwordTextBox; }

    public WebElement getLoginButton() { return loginButton; }
}
