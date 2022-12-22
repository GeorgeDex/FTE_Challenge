package tests;

import org.testng.Assert;

public class CustomAssertions extends Assert {

    public static void isTextEquals (String expectedText, String actualText) {
        String errorMsg = "Text " + actualText + " is not as expected. Expected was: " + expectedText;
        Assert.assertEquals(actualText, expectedText, errorMsg);
    }

    public static void isElementDisplayed (Boolean isElementDisplayed, String view) {
        String errorMessage = "The element is not displayed in view " + view;
        Assert.assertTrue(isElementDisplayed, errorMessage);
    }

    public static void isUsernameNotPresent (Boolean isUsernameCorrect, String view) {
        String errorMessage = "The username is not the same as yours in view " + view;
        Assert.assertTrue(!isUsernameCorrect, errorMessage);
    }
}
