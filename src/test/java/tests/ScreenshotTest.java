package tests;

import base.PlaywrightTestBase;
import base.listeners.ScreenshotOnFailListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.ExamplePage;

@Listeners(ScreenshotOnFailListener.class)
public class ScreenshotTest extends PlaywrightTestBase {

    @Test
    public void failingTest() {
        ExamplePage examplePage = new ExamplePage(page);
        examplePage.open();
        String title = examplePage.getTitle();

        Assert.assertTrue(title.contains("NonExistingText"),
                "Expected page title to contain 'NonExistingText', but got: " + title
        );
    }

    @Test
    public void passingTest() {
        ExamplePage examplePage = new ExamplePage(page);
        examplePage.open();
        String title = examplePage.getTitle();

        Assert.assertTrue(title.contains("Example Domain"),
                "Expected correct title, but got: " + title
        );
    }
}
