package tests;

import org.testng.annotations.Test;

public class CreatePostsTests extends BaseTests {

    @Test(description = "Scenario 1: User Creates posts")
    public void testUserCreatesPost() throws InterruptedException {
        String title = "My First Post!";
        String subtitle = "by: Jorge Martinez";
        String body = "This is my first ever post for my automation challenge!";

        loginSteps.logIn();
        newPostSteps.createNewPost(title, subtitle, body);
        newPostSteps.checkCreatedPost(title, subtitle, body);

        Thread.sleep(5000);
    }

    @Test(description = "Scenario 2: Fails to create post due to missing title")
    public void testFailsPostDueToMissingTitle() throws InterruptedException {
        String subtitle = "by: Jorge Martinez";
        String body = "This is my second post for my automation challenge!";

        loginSteps.logIn();
        newPostSteps.createNewPost("", subtitle, body);
        newPostSteps.checkTitleValidationMsg();

        Thread.sleep(5000);
    }

    @Test(description = "Scenario 3: Fails to create post due to missing subtitle")
    public void testFailsPostDueToMissingSubtitle() throws InterruptedException {
        String title = "This is my third title";
        String body = "This is my third post for my automation challenge!";

        loginSteps.logIn();
        newPostSteps.createNewPost(title, "", body);
        newPostSteps.checkSubtitleValidationMsg();

        Thread.sleep(5000);
    }

}
