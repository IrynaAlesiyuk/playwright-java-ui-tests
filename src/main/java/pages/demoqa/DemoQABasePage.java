package pages.demoqa;

import com.microsoft.playwright.Page;
import config.Config;
import pages.BasePage;

public class DemoQABasePage extends BasePage {

    protected DemoQABasePage(Page page) {
        super(page, Config.get("demoqa.base.url"));
    }

    protected void openByPath(String pathKey) {
        String url = baseUrl + Config.get(pathKey);
        navigateTo(url);
    }
}
