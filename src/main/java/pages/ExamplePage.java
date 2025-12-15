package pages;

import com.microsoft.playwright.Page;

public class ExamplePage {
    private final Page page;

    private static final String HEADING = "h1";

    public ExamplePage(Page page) {
        this.page = page;
    }

    public void open() {
        page.navigate("https://example.com");
    }

    public String getTitle() {
        return page.title();
    }

    public String getHeadingText() {
        return page.textContent(HEADING);
    }
}
