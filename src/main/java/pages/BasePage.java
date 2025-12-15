package pages;

import com.microsoft.playwright.Page;
import config.Config;

public abstract class BasePage {
    protected final Page page;

    protected BasePage(Page page) {
        this.page = page;
    }

    public void open(String pathKey) {
        String url = Config.get("base.url") + Config.get(pathKey);
        page.navigate(url);
    }
}
