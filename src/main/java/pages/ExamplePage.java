package pages;

import com.microsoft.playwright.Page;
import config.Config;

public class ExamplePage extends BasePage {

    public ExamplePage(Page page) {
        super(page, Config.get("example.base.url"));
    }

    public void open() {
        navigateTo(baseUrl);
    }
}
