package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PostPage extends BasePage{
    public PostPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(how = How.NAME, using = "title")
    private WebElement titleBox;

    @FindBy(how = How.XPATH, using = "//input[@id='id_subtitle']")
    private WebElement subtitleBox;

    @FindBy(how = How.NAME, using = "body")
    private WebElement bodyBox;

    @FindBy(how = How.XPATH, using = "//body/div[1]/div[1]/div[2]/form[1]/input[2]")
    private WebElement createButton;


    //Created post view
    @FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/h1[1]")
    private WebElement titleLabel;
    @FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/h5[1]")
    private WebElement subtitleLabel;
    @FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/p[1]")
    private WebElement bodyLabel;
    @FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/small[1]")
    private WebElement date;
    @FindBy(how = How.XPATH, using = "//body/div[1]/div[1]/div[2]")
    private WebElement editPost;

    //Posts view
    @FindBy(how = How.XPATH, using = "//body/div[1]/div[1]/div[1]/div[1]/a[1]")
    private WebElement readMoreButton;

    public WebElement getTitleBox() { return titleBox; }
    public WebElement getSubtitleBox() { return subtitleBox; }
    public WebElement getBodyBox() { return bodyBox; }
    public WebElement getCreateButton() { return createButton; }
    public WebElement getTitleLabel() { return titleLabel; }
    public WebElement getSubtitleLabel() { return subtitleLabel; }
    public WebElement getBodyLabel() { return bodyLabel; }
    public WebElement getDate() { return date; }
    public WebElement getEditPost() { return editPost; }
    public WebElement getReadMoreButton() { return readMoreButton; }
}
