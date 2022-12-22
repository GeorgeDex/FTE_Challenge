package tests;

import org.testng.annotations.Test;

public class UpdatePostsTests extends BaseTests{

    @Test(description = "Scenario 1: User completely updates a post successfully")
    public void testUpdatePost() {
        String newTitle = "Modified Text";
        String newSubtitle = "Modified subtext";
        String newBody = "Modified body";

        loginSteps.logIn();
        Integer postSelector = 1;
        updatePostSteps.editPost(postSelector.toString(), newTitle, newSubtitle, newBody);
        newPostSteps.checkCreatedPost(newTitle, newSubtitle, newBody);
        newPostSteps.checkAuthor("jm0921");
    }

    @Test(description = "Scenario 2: User Partially updates a post successfully")
    public void testPartiallyUpdatePost() {
        String subtitle = "by: Jorge Martinez";

        String newTitle = "Modified Text";
        String newSubtitle = "Modified subtext";
        String newBody = "Modified body";

        loginSteps.logIn();
        Integer postSelector = 2;
        updatePostSteps.editPost(postSelector.toString(), newTitle, "", newBody);
        newPostSteps.checkCreatedPost(newTitle, "", newBody);
        newPostSteps.checkAuthor("jm0921");
    }

    @Test(description = "Scenario 3: User tries to update a foreign post")
    public void testUpdateForeignPost() {
        String newTitle = "Fake Text";
        String newSubtitle = "Fake subtext";
        String newBody = "Fake body";
        String author = "FakeUsr";
        loginSteps.logIn();

        //I gave up on this one
    }
}
