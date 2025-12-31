package IReport;

import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTestManager.startTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentTestManager.getTest().pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentTestManager.getTest().fail("Test Failed: " + result.getThrowable());

        Object testClass = result.getInstance();
        WebDriver driver = ((WebDriver) ((BaseTest) testClass).driver);

        String screenshotPath = takeScreenshot(driver, result.getMethod().getMethodName());

        ExtentTestManager.getTest().fail(
                "Screenshot:",
                MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build()
        );
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentTestManager.getTest().skip("Test Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentManager.getExtent().flush();
    }

    private String takeScreenshot(WebDriver driver, String testName) {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String path = "test-output/screenshots/" + testName + ".png";

        try {
            Files.createDirectories(new File("test-output/screenshots").toPath());
            Files.copy(src.toPath(), new File(path).toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return path;
    }
}