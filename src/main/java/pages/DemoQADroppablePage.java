package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class DemoQADroppablePage extends BasePage{


    private static final String DRAGGABLE = "#draggable";

    public DemoQADroppablePage(Page page) {
        super(page);    }

    public void dragToDrop() {
        Locator source = page.locator(DRAGGABLE);

        Locator target = page.getByLabel("Simple").locator("#droppable");
        source.dragTo(target);
    }

    public String getDropText() {
        return page.getByLabel("Simple").locator("#droppable").textContent();
    }
}
