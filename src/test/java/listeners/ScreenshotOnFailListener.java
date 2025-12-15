package listeners;
import base.PlaywrightTestBase;


import com.microsoft.playwright.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.nio.file.Paths;

import static utils.ScreenshotUtils.createFolderIfNotExists;
import static utils.ScreenshotUtils.getScreenshotPath;

public class ScreenshotOnFailListener implements ITestListener {

    private static final Logger logger = LoggerFactory.getLogger(ScreenshotOnFailListener.class);

    @Override
    public void onTestFailure(ITestResult result) {
        Object testClass = result.getInstance();

        if (testClass instanceof PlaywrightTestBase) {
            PlaywrightTestBase base = (PlaywrightTestBase) testClass;
            Page page = base.getPage();

            createFolderIfNotExists();

            String path = getScreenshotPath("FAIL_" + result.getName());
            page.screenshot(new Page.ScreenshotOptions()
                    .setPath(Paths.get(path))
                    .setFullPage(true));

            logger.info("Screenshot is saved: {}", path);
        }
    }

    @Override public void onTestStart(ITestResult result) {}
    @Override public void onTestSuccess(ITestResult result) {}
    @Override public void onTestSkipped(ITestResult result) {}
    @Override public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}
    @Override public void onStart(ITestContext context) {}
    @Override public void onFinish(ITestContext context) {}

}

