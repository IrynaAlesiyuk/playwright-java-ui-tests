package pages;

import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.WaitForSelectorState;

public class FormPage {
    private final Page page;

    private static final String FIRSTNAME_INPUT = "input[name='firstname']";
    private static final String LASTNAME_INPUT = "input[name='lastname']";
    private static final String SUBMIT_BUTTON = "input[type='submit']";
    private static final String HEADER = "h2";
    private static final String IFRAME_URL = "https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_iframe";

    public FormPage(Page page) {
        this.page = page;
    }

    public void openFormPage() {
        page.navigate("https://www.w3schools.com/html/html_forms.asp");
    }

    public void fillFirstName(String firstName) {
        page.fill(FIRSTNAME_INPUT, firstName);
    }

    public void fillLastName(String lastName) {
        page.fill(LASTNAME_INPUT, lastName);
    }

    public void submitForm() {
        page.click(SUBMIT_BUTTON);
    }

    public String getHeaderText() {
        return page.textContent(HEADER);
    }

    public String getIframeText() {
        page.navigate(IFRAME_URL);
        Frame frame = page.frame("iframeResult");
        if (frame != null) {
            return frame.textContent("h1");
        }
        return null;
    }

}
