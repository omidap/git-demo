package IReport;

import org.testng.ITestContext;
import org.testng.ITestResult;

public interface ITestListeners {
    void onTestStart(ITestResult result);

    void onTestSuccess(ITestResult result);

    void onTestFailure(ITestResult result);

    void onTestSkipped(ITestResult result);

    void onTestFailedButWithinSuccessPercentage(ITestResult result);

    void onStart(ITestContext testContext);

    void onFinish(ITestContext testContext);

}
