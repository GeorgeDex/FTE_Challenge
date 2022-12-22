package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageObjects.HomePage;
import pageObjects.PostPage;
import tests.CustomAssertions;

public class UpdatePostSteps extends BaseSteps{
    public UpdatePostSteps(WebDriver webDriver) {
        super(webDriver);
    }

    PostPage postPage = PageFactory.initElements(webDriver, PostPage.class);
    HomePage homePage = PageFactory.initElements(webDriver, HomePage.class);

    public void editPost(String selector, String title, String subtitle, String body) {
        homePage.getPostMenu().click();
        webDriver.findElement(By.xpath("//body/div[1]/div["+selector+"]/div[1]/div[1]/a[1]")).click();
        postPage.getEditPost().click();

        if (!title.isEmpty()) {
            postPage.getTitleBox().clear();
            postPage.getTitleBox().sendKeys(title);
        }
        if (!subtitle.isEmpty()) {
            postPage.getSubtitleBox().clear();
            postPage.getSubtitleBox().sendKeys(subtitle);
        }
        if (!body.isEmpty()) {
            postPage.getBodyBox().clear();
            postPage.getBodyBox().sendKeys(body);
        }

        postPage.getCreateButton().click();
    }

    public void searchForeignPost(String username, String title, String subtitle, String body) {
        homePage.getPostMenu().click();
        CustomAssertions.isUsernameNotPresent(!webDriver.findElement(By.partialLinkText(username)).isDisplayed(),
                "Post view");
        postPage.getEditPost().click();
    }
}
