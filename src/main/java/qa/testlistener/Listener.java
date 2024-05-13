package qa.testlistener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {

    private final Logger logger = LoggerFactory.getLogger(Listener.class);
    @Override
    public void onStart(ITestContext context) {

        logger.info("Starting test on suite: " + context.getSuite().getName());
    }

    @Override
    public void onFinish(ITestContext context) {

        logger.info("Test finish");
        logger.info("-".repeat(50));
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        logger.info("Test PASSED on method: " + result.getMethod().toString());
    }

    @Override
    public void onTestFailure(ITestResult result) {

        logger.error("Test FAILED on method: " + result.getMethod().toString());
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        logger.info("Test SKIPPED on method: " + result.getMethod().toString());
    }
}
