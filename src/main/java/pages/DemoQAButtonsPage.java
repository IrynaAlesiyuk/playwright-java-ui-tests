package pages;

import com.microsoft.playwright.Page;

public class DemoQAButtonsPage extends BasePage{


    private static final String DOUBLE_CLICK_BTN = "#doubleClickBtn";
    private static final String DOUBLE_CLICK_MESSAGE = "#doubleClickMessage";

    public DemoQAButtonsPage(Page page) {
        super(page);
    }

    public void doubleClickButton() {
        page.locator(DOUBLE_CLICK_BTN).dblclick();
    }

    public boolean isDoubleClickMessageVisible() {
        return page.locator(DOUBLE_CLICK_MESSAGE).isVisible();
    }
}
