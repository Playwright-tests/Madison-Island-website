package qa.extentreportsmanager;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import qa.playwright.PlaywrightLauncher;

public class ExtentReportsManager {

    private static ExtentReports extentReports;
    private static ExtentTest extentTest;

    private static ExtentSparkReporter getSparkReporter(String filename, String reportName) {

        String path = "./reports/";

        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(path + filename);
        sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setDocumentTitle("Madison Island website E2E tests");
        sparkReporter.config().setReportName(reportName);

        return sparkReporter;
    }

    public static void initialize(String filename, String reportName) {

        extentReports = new ExtentReports();

        extentReports.attachReporter(getSparkReporter(filename, reportName));
    }

    public static void setEnvironment() {

        extentReports.setSystemInfo("Available processors (cores)", String.valueOf(Runtime.getRuntime().availableProcessors()));
        extentReports.setSystemInfo("Total memory", String.valueOf(Runtime.getRuntime().totalMemory()));
        extentReports.setSystemInfo("Maximum memory", String.valueOf(Runtime.getRuntime().maxMemory()));
        extentReports.setSystemInfo("Free memory", String.valueOf(Runtime.getRuntime().freeMemory()));
        extentReports.setSystemInfo("System property", System.getProperty("user.dir"));
        extentReports.setSystemInfo("Operating system", System.getProperty("os.name") + " " + System.getProperty("os.arch"));
        extentReports.setSystemInfo("Browser", PlaywrightLauncher.getPage().context().browser().browserType().name() + " " +
                PlaywrightLauncher.getPage().context().browser().version());
        extentReports.setSystemInfo("Java runtime version", System.getProperty("java.runtime.version"));
    }

    public static void createTest(String testName, String testDescription) {

        extentTest = extentReports
                .createTest(testName, testDescription)
                .assignAuthor("Paweł Aksman")
                .assignCategory("Functional tests");
    }

    public static void setTestInfo(String info) {

        extentTest.log(Status.INFO, info);
    }

    public static void setTestPassed(String info) {

        extentTest.log(Status.PASS, info);
    }

    public static void setTestFailed(String info) {

        extentTest.log(Status.FAIL, info);
    }

    public static void setTestSkipped(String info) {

        extentTest.log(Status.SKIP, info);
    }

    public static void flush() {

        extentReports.flush();
    }
}
