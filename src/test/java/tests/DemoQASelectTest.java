package tests;

import base.PlaywrightTestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DemoQAButtonsPage;
import pages.DemoQADroppablePage;
import pages.DemoQASelectPage;

public class DemoQASelectTest extends PlaywrightTestBase {

    @Test
    public void navigationE2ETest() {
        DemoQASelectPage selectPage = new DemoQASelectPage(page);
        selectPage.open("select.menu.path");
        String selectPageTitle = page.title();

        DemoQAButtonsPage buttonsPage = new DemoQAButtonsPage(page);
        buttonsPage.open("buttons.path");
        String buttonsPageTitle = page.title();

        page.goBack();
        Assert.assertEquals(page.title(), selectPageTitle,
                "Should return to Select page after going back"
        );

        page.goForward();
        Assert.assertEquals(page.title(), buttonsPageTitle,
                "Should return to Buttons page after going forward"
        );

        page.reload();
        Assert.assertEquals(page.title(), buttonsPageTitle,
                "Title after reload should remain the same"
        );
    }

    @Test
    public void singleSelectTest() {
        DemoQASelectPage selectPage = new DemoQASelectPage(page);
        selectPage.open("select.menu.path");

        selectPage.selectSingleOption("red");
        String selectedValue = selectPage.getSingleValue();
        Assert.assertEquals(selectedValue, "red", "Single select value should be 'red'");
    }

    @Test
    public void multiSelectTest() {
        DemoQASelectPage selectPage = new DemoQASelectPage(page);
        selectPage.open("select.menu.path");

        String[] actualValues = {"Volvo", "Saab"};
        selectPage.selectMultipleOptions(actualValues);

        String[] selectedValues = selectPage.getMultipleValues();
        Assert.assertEqualsNoOrder(selectedValues, actualValues);
    }

    @Test
    public void doubleClickTest() {
        DemoQAButtonsPage buttonsPage = new DemoQAButtonsPage(page);
        buttonsPage.open("buttons.path");
        buttonsPage.doubleClickButton();

        Assert.assertTrue(buttonsPage.isDoubleClickMessageVisible(), "Message should appear after double click");
    }

    @Test
    public void dragAndDropTest() {
        DemoQADroppablePage droppablePage = new DemoQADroppablePage(page);
        droppablePage.open("droppable.path");
        droppablePage.dragToDrop();

        String text = droppablePage.getDropText();
        Assert.assertTrue(text.contains("Dropped!"), "Target text should be 'Dropped!'");
    }


}
