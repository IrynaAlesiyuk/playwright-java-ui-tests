package pages.demoqa;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class DemoQAButtonsPage extends DemoQABasePage {

    private final Locator doubleClickButton;
    private final Locator doubleClickMessage;
    private static final String PATH_KEY = "buttons.path";

    public DemoQAButtonsPage(Page page) {
        super(page);
        this.doubleClickButton = page.locator("#doubleClickBtn");
        this.doubleClickMessage = page.locator("#doubleClickMessage");
    }

    public void open() {
        openByPath(PATH_KEY);
    }

    public void doubleClickButton() {
        doubleClickButton.dblclick();
    }

    public boolean isDoubleClickMessageVisible() {
        return doubleClickMessage.isVisible();
    }
}
