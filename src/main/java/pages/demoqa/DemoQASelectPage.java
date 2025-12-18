package pages.demoqa;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class DemoQASelectPage extends DemoQABasePage {


    private final Locator singleSelect;
    private final Locator multiSelect;
    private static final String PATH_KEY = "select.menu.path";

    public DemoQASelectPage(Page page) {
        super(page);
        this.singleSelect = page.locator("#oldSelectMenu");
        this.multiSelect = page.locator("select#cars");
    }

    public void open() {
        openByPath(PATH_KEY);
    }

    public void selectSingleOption(String value) {
        singleSelect.selectOption(value);
    }

    public void selectMultipleOptions(String[] values) {
        multiSelect.selectOption(values);
    }

    public String getSingleValue() {
        return singleSelect.inputValue();
    }

    public String[] getMultipleValues() {
        return multiSelect.locator("option:checked")
                .allTextContents()
                .toArray(new String[0]);
    }
}
