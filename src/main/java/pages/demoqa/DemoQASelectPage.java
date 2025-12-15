package pages.demoqa;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import config.Config;
import pages.BasePage;

public class DemoQASelectPage extends BasePage {


    private final Locator singleSelect;
    private final Locator multiSelect;

    public DemoQASelectPage(Page page) {
        super(page, Config.get("demoqa.base.url"));
        this.singleSelect = page.locator("#oldSelectMenu");
        this.multiSelect = page.locator("select#cars");
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
