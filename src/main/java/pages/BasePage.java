package pages;

import com.microsoft.playwright.Page;
import config.Config;
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

    public void open(String pathKey) {
        String url = baseUrl + Config.get(pathKey);
        logger.info("Navigating to URL: {}", url);
        page.navigate(url);
    }

    public void open() {
        logger.info("Navigating to base URL: {}", baseUrl);
        page.navigate(baseUrl);
    }
}
