package utils;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;

public class BrowserFactory {
    public static Browser create(String browserName, Playwright playwright) {
        BrowserType browserType;

        switch (browserName.toLowerCase()) {
            case "chrome":
            case "chromium":
                browserType = playwright.chromium();
                break;
            case "firefox":
                browserType = playwright.firefox();
                break;
            case "webkit":
                browserType = playwright.webkit();
                break;
            default:
                throw new IllegalArgumentException("Unknown browser: " + browserName);
        }

        return browserType.launch(new BrowserType.LaunchOptions()
                .setHeadless(true)); // можно вынести в config
    }
}
