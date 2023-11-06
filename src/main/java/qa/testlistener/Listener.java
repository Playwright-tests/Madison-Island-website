package qa.testlistener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import qa.extentreportsmanager.ExtentReportsManager;

public class Listener implements ITestListener {

    @Override
    public void onStart(ITestContext context) {

        ExtentReportsManager.initialize(
                context.getSuite().getName() + "-" + context.getStartDate().getTime(),
                "Suite: " + context.getSuite().getName()
                );
    }

    @Override
    public void onFinish(ITestContext context) {

        ExtentReportsManager.setEnvironment();
        ExtentReportsManager.flush();
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        ExtentReportsManager.setTestPassed("Test passed on \"" + result.getMethod() + "\" method from \"" +
                result.getInstanceName() + "\" instance and \"" +
                result.getTestClass() + "\" test class");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        ExtentReportsManager.setTestFailed(result.getThrowable().toString() +
                "\n \"" + result.getMethod() + "\" method from \"" +
                result.getInstanceName() + "\" instance and \"" +
                result.getTestClass() + "\" test class");
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        ExtentReportsManager.setTestSkipped("Test skipped on \"" + result.getMethod() + "\" method from \"" +
                result.getInstanceName() + "\" instance and \"" +
                result.getTestClass() + "\" test class");
    }
}
