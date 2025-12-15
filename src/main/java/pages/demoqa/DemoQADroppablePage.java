package pages.demoqa;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import config.Config;
import pages.BasePage;

public class DemoQADroppablePage extends BasePage {


    private final Locator draggable;
    private final Locator simpleDroppable;

    public DemoQADroppablePage(Page page) {
        super(page, Config.get("demoqa.base.url"));
        this.draggable = page.locator("#draggable");
        this.simpleDroppable = page.getByLabel("Simple").locator("#droppable").first();
    }

    public void dragToDrop() {
        draggable.dragTo(simpleDroppable);
    }

    public String getDropText() {
        return simpleDroppable.textContent();
    }
}
