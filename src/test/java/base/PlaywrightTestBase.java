package base;

import com.microsoft.playwright.*;
import config.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import utils.BrowserFactory;

public class PlaywrightTestBase {

    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext context;
    protected Page page;

    protected static final Logger logger = LoggerFactory.getLogger(PlaywrightTestBase.class);

    @BeforeClass
    public void setup() {
        logger.info("Starting Playwright...");
        playwright = Playwright.create();

        String browserName = System.getProperty("browser", "chromium");
        browser = BrowserFactory.create(browserName, playwright);
        logger.info("Browser launched");

        Browser.NewContextOptions contextOptions = new Browser.NewContextOptions();

        Config.getOptional("base.url")
                .ifPresentOrElse(
                        url -> {
                            contextOptions.setBaseURL(url);
                            logger.info("Base URL configured: {}", url);
                        },
                        () -> logger.info("Base URL is not configured")
                );

        context = browser.newContext(contextOptions);
        logger.info("Browser context created");

        page = context.newPage();
        logger.info("New page opened");
    }

    @AfterClass
    public void teardown() {
        logger.info("Closing Playwright...");
        if (context != null) {
            context.close();
            logger.info("Browser context closed");
        }
        if (browser != null) {
            browser.close();
            logger.info("Browser closed");
        }
        if (playwright != null) {
            playwright.close();
            logger.info("Playwright stopped");
        }
    }

    /**
     * Public getter for Page so listener can access it
     */
    public Page getPage() {
        return page;
    }
}
