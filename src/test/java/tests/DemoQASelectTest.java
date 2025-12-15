package tests;

import base.PlaywrightTestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DemoQASelectPage;

public class DemoQASelectTest extends PlaywrightTestBase {
    @Test
    public void singleSelectTest() {
        DemoQASelectPage selectPage = new DemoQASelectPage(page);
        selectPage.open();

        selectPage.selectSingleOption("red");
        String selectedValue = selectPage.getSingleValue();
        Assert.assertEquals(selectedValue, "red", "Single select value should be 'red'");
    }

    @Test
    public void multiSelectTest() {
        DemoQASelectPage selectPage = new DemoQASelectPage(page);
        selectPage.open();

        String[] actualValues = {"Volvo", "Saab"};
        selectPage.selectMultipleOptions(actualValues);

        String[] selectedValues = selectPage.getMultipleValues();
        Assert.assertEqualsNoOrder(selectedValues, actualValues);
    }
}
