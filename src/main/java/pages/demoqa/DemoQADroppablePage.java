package pages.demoqa;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class DemoQADroppablePage extends DemoQABasePage {


    private final Locator draggable;
    private final Locator simpleDroppable;
    private static final String PATH_KEY = "droppable.path";


    public DemoQADroppablePage(Page page) {
        super(page);
        this.draggable = page.locator("#draggable");
        this.simpleDroppable = page.getByLabel("Simple").locator("#droppable").first();
    }

    public void open() {
        openByPath(PATH_KEY);
    }

    public void dragToDrop() {
        draggable.dragTo(simpleDroppable);
    }

    public String getDropText() {
        return simpleDroppable.textContent();
    }
}
