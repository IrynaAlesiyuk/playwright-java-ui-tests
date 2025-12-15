package pages;

import com.microsoft.playwright.Page;

public class DemoQASelectPage extends BasePage {


    private static final String SINGLE_SELECT = "#oldSelectMenu";
    private static final String MULTI_SELECT = "select#cars";

    public DemoQASelectPage(Page page) {
        super(page);
    }

    public void selectSingleOption(String value) {
        page.locator(SINGLE_SELECT).selectOption(value);
    }

    public void selectMultipleOptions(String[] values) {
        page.locator(MULTI_SELECT).selectOption(values);
    }


    public String getSingleValue() {
        return page.locator(SINGLE_SELECT).inputValue();
    }

    public String[] getMultipleValues() {
        return page.locator(MULTI_SELECT + " option:checked").allTextContents().toArray(new String[0]);
    }
}
