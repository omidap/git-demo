package IReport;

import com.aventstack.extentreports.ExtentTest;

public class ExtentTestManager {

    private static final ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    public static ExtentTest getTest() {
        return test.get();
    }

    public static void startTest(String testName) {
        ExtentTest extentTest = ExtentManager.getExtent().createTest(testName);
        test.set(extentTest);
    }
}