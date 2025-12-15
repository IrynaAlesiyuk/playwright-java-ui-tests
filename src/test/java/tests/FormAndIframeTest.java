package tests;

import base.PlaywrightTestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FormPage;

public class FormAndIframeTest extends PlaywrightTestBase {

    @Test
    public void formSubmissionTest() {
        FormPage formPage = new FormPage(page);

        formPage.openFormPage();
        formPage.fillFirstName("Irina");
        formPage.fillLastName("QA");
        formPage.submitForm();

        String headerText = formPage.getHeaderText();
        Assert.assertNotNull(headerText, "Header text should not be null");
        Assert.assertFalse(headerText.isEmpty(), "Header text should not be empty");
    }

    @Test
    public void iframeTextTest() {
        FormPage formPage = new FormPage(page);

        String iframeText = formPage.getIframeText();
        Assert.assertNotNull(iframeText, "Iframe text should not be null");
        Assert.assertFalse(iframeText.isEmpty(), "Iframe text should not be empty");
    }
}
