package qa.testlistener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import qa.extentreportsmanager.ExtentReportsManager;

public class Listener implements ITestListener {

    private final Logger logger = LoggerFactory.getLogger(Listener.class);
    @Override
    public void onStart(ITestContext context) {

        logger.info("Starting test on suite: " + context.getSuite().getName());

        ExtentReportsManager.initialize(
                context.getSuite().getName() + "-" + context.getStartDate().getTime(),
                "Suite: " + context.getSuite().getName()
                );
    }

    @Override
    public void onFinish(ITestContext context) {

        logger.info("Test finish");
        logger.info("-".repeat(50));

        ExtentReportsManager.setEnvironment();
        ExtentReportsManager.flush();
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        logger.info("Test PASSED on method: " + result.getMethod().toString());

        ExtentReportsManager.setTestPassed("Test passed on \"" + result.getMethod() + "\" method from \"" +
                result.getInstanceName() + "\" instance and \"" +
                result.getTestClass() + "\" test class");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        logger.info("Test FAILED on method: " + result.getMethod().toString());

        ExtentReportsManager.setTestFailed(result.getThrowable().toString() +
                "\n \"" + result.getMethod() + "\" method from \"" +
                result.getInstanceName() + "\" instance and \"" +
                result.getTestClass() + "\" test class");
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        logger.info("Test SKIPPED on method: " + result.getMethod().toString());

        ExtentReportsManager.setTestSkipped("Test skipped on \"" + result.getMethod() + "\" method from \"" +
                result.getInstanceName() + "\" instance and \"" +
                result.getTestClass() + "\" test class");
    }
}
