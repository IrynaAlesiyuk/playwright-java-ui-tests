package pages;

import com.microsoft.playwright.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasePage {

    protected static final Logger logger = LoggerFactory.getLogger(BasePage.class);

    protected final Page page;
    protected final String baseUrl;

    protected BasePage(Page page, String baseUrl) {
        this.page = page;
        this.baseUrl = baseUrl;
    }

    protected void navigateTo(String url) {
        logger.info("Navigating to URL: {}", url);
        page.navigate(url);
    }

    public String getTitle() {
        return page.title();
    }

    public void goBack() {
        page.goBack();
    }

    public void goForward() {
        page.goForward();
    }

    public void reload() {
        page.reload();
    }
}
