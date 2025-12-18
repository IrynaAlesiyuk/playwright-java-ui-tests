package tests;

import base.PlaywrightTestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.demoqa.DemoQAButtonsPage;
import pages.demoqa.DemoQADroppablePage;
import pages.demoqa.DemoQASelectPage;

public class DemoQASelectTest extends PlaywrightTestBase {

    @Test
    public void navigateBetweenSelectAndButtonsPages() {
        // Arrange
        DemoQASelectPage selectPage = new DemoQASelectPage(page);
        selectPage.open("select.menu.path");
        String selectPageTitle = selectPage.getTitle();

        DemoQAButtonsPage buttonsPage = new DemoQAButtonsPage(page);
        buttonsPage.open("buttons.path");
        String buttonsPageTitle = buttonsPage.getTitle();

        // Act + Assert
        buttonsPage.goBack();
        Assert.assertEquals(selectPage.getTitle(), selectPageTitle,
                "Should return to Select page after going back"
        );

        selectPage.goForward();
        Assert.assertEquals(buttonsPage.getTitle(), buttonsPageTitle,
                "Should return to Buttons page after going forward"
        );

        buttonsPage.reload();
        Assert.assertEquals(buttonsPage.getTitle(), buttonsPageTitle,
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
