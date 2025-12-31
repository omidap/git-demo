package listeners;

import org.testng.*;
import org.testng.annotations.ITestAnnotation;
import org.testng.IAnnotationTransformer;
import org.testng.xml.XmlSuite;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.List;

public class MasterListener implements
        ITestListener,
        ISuiteListener,
        IExecutionListener,
        IInvokedMethodListener,
        IAnnotationTransformer,
        IAlterSuiteListener,
        IConfigurationListener,
        IDataProviderListener,
        IHookable,
        IReporter {

    // 1.ITestListener

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("TEST STARTED: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("TEST PASSED: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("TEST FAILED: " + result.getName());
        // screenshot logic goes here.
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("TEST SKIPPED: " + result.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("FINISHED TEST CONTEXT: " + context.getName());
    }

    //2.ISuiteListener

    @Override
    public void onStart(ISuite suite) {
        System.out.println("SUITE STARTED: " + suite.getName());
    }

    @Override
    public void onFinish(ISuite suite) {
        System.out.println("SUITE FINISHED: " + suite.getName());
    }

    //3.IExecuteListener

    @Override
    public void onExecutionStart() {
        System.out.println("TEST EXECUTION STARTED");
    }

    @Override
    public void onExecutionFinish() {
        System.out.println("TEST EXECUTION FINISHED");
    }

    //4.IInvokedMethodListener


    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        System.out.println("BEFORE METHOD: " + method.getTestMethod().getMethodName());
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        System.out.println("AFTER METHOD: " + method.getTestMethod().getMethodName());
    }

    //5.IAnnotationTransformer


    @Override
    public void transform(ITestAnnotation annotation, Class testClass,
                          Constructor testConstructor, Method testMethod) {
        System.out.println("ANNOTATION TRANSFORMED FOR: " + testMethod.getName());
        // Example: Add retry logic dynamically
    }

    //6.IAlterSuiteListener

    @Override
    public void alter(List<XmlSuite> suites) {
        System.out.println("SUITE ALTERED BEFORE EXECUTION");
        // Example: Add/remove tests dynamically
    }

    //7.IConfigurationListener

    @Override
    public void onConfigurationSuccess(ITestResult tr) {
        System.out.println("CONFIGURATION SUCCESS: " + tr.getName());
    }

    @Override
    public void onConfigurationFailure(ITestResult tr) {
        System.out.println("CONFIGURATION FAILED: " + tr.getName());
    }

    //8.IDataProviderListener

    @Override
    public void beforeData(IDataProviderMethod method, ITestNGMethod testMethod) {
        System.out.println("DATA_PROVIDER STARTED: " + method.getName());
    }

    @Override
    public void afterDataProviderExecution(IDataProviderMethod method,
                                           ITestNGMethod testMethod, ITestResult result) {
        System.out.println("DATAPROVIDER FINISHED: " + method.getName() + " | "
                + testMethod.getMethodName() + " | " + result.getName());

    }
    //9.IHookable

    @Override
    public void run(IHookCallBack callBack, ITestResult testResult) {
        System.out.println("HOOKABLE WRAPPER AROUND TEST: " + testResult.getName());
    }

    //10.IReporter

    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
        System.out.println("CUSTOM REPORT GENERATED");
        //Example: Create your own HTML/JASON report
    }
}
