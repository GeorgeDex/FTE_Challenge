package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageObjects.HomePage;
import pageObjects.PostPage;
import tests.CustomAssertions;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class NewPostSteps extends BaseSteps {
    public NewPostSteps(WebDriver webDriver) {
        super(webDriver);
    }

    PostPage postPage = PageFactory.initElements(webDriver, PostPage.class);
    HomePage homePage = PageFactory.initElements(webDriver, HomePage.class);

    public void createNewPost(String title, String subtitle, String body) {

        homePage.getNewPostMenu().click();

        if (!title.isEmpty())
            postPage.getTitleBox().sendKeys(title);
        if (!subtitle.isEmpty())
            postPage.getSubtitleBox().sendKeys(subtitle);
        if (!body.isEmpty())
            postPage.getBodyBox().sendKeys(body);

        postPage.getCreateButton().click();

    }

    public void checkCreatedPost(String title, String subtitle, String body) {
        String username = "jm0921";
        //Assertion of input text
        if(!title.isEmpty())
            CustomAssertions.isTextEquals(title, postPage.getTitleLabel().getText());
        if(!subtitle.isEmpty())
            CustomAssertions.isTextEquals(subtitle, postPage.getSubtitleLabel().getText());
        if(!body.isEmpty())
            CustomAssertions.isTextEquals(body, postPage.getBodyLabel().getText());

        //assert of username
        String actualDate = postPage.getDate().getText();
        String[] arrDate = actualDate.split(" ");
        actualDate = actualDate.substring(12); //cuts "Created by: "
        CustomAssertions.isTextEquals(username, actualDate.split(" ")[0]); //assert of username

        //assert of today's date
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMM. dd, yyyy,");
        LocalDateTime now = LocalDateTime.now();
        String today = dtf.format(now);
        actualDate = arrDate[5]+" "+arrDate[6]+" "+arrDate[7];
        CustomAssertions.isTextEquals(today, actualDate);

    }

    public void checkAuthor(String username) {
        String actualText = postPage.getDate().getText();
        actualText = actualText.substring(12); //cuts "Created by: "
        CustomAssertions.isTextEquals(username, actualText.split(" ")[0]); //assert of username
    }

    public void checkTitleValidationMsg() {
        String expectedMsg = "Please fill out this field.";
        String missingTitleMsg = webDriver.findElement(By.name("title")).getAttribute("validationMessage");
        CustomAssertions.isTextEquals(expectedMsg ,missingTitleMsg);
        //asserts if user is still in create a post view.
        CustomAssertions.isElementDisplayed(postPage.getTitleBox().isDisplayed(), "New Post view");
    }

    public void checkSubtitleValidationMsg() {
        String expectedMsg = "Please fill out this field.";
        String missingTitleMsg = webDriver.findElement(By.name("subtitle")).getAttribute("validationMessage");
        CustomAssertions.isTextEquals(expectedMsg ,missingTitleMsg);
        //asserts if user is still in create a post view.
        CustomAssertions.isElementDisplayed(postPage.getSubtitleBox().isDisplayed(), "New Post view");
    }
}