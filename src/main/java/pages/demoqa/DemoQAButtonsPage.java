package pages.demoqa;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import config.Config;
import pages.BasePage;

public class DemoQAButtonsPage extends BasePage {

    private final Locator doubleClickButton;
    private final Locator doubleClickMessage;

    public DemoQAButtonsPage(Page page) {
        super(page, Config.get("demoqa.base.url"));
        this.doubleClickButton = page.locator("#doubleClickBtn");
        this.doubleClickMessage = page.locator("#doubleClickMessage");
    }

    public void doubleClickButton() {
        doubleClickButton.dblclick();
    }

    public boolean isDoubleClickMessageVisible() {
        return doubleClickMessage.isVisible();
    }
}
