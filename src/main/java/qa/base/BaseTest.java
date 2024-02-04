package qa.base;

import com.microsoft.playwright.Page;
import org.testng.annotations.*;
import qa.enums.Browser;
import qa.exceptions.MockarooRequestException;
import qa.playwright.PlaywrightBrowserLauncher;
import qa.playwright.PlaywrightProvider;
import qa.enums.URLs;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;


public class BaseTest {

    private PlaywrightBrowserLauncher launcher;

    @Parameters({"fileName", "downloadMode"})
    @BeforeClass
    public void loadTestdata(@Optional("noFile") String fileName, @Optional("noDownloadMode") String downloadMode) throws MalformedURLException, FileNotFoundException, URISyntaxException, MockarooRequestException {

        if (!fileName.equals("nofile") && !downloadMode.equals("noDownloadMode")) {
            BaseDataProviders.loadTestdata(fileName, downloadMode);
        }
    }

    @AfterSuite
    public void clearTestdata() {

        BaseDataProviders.clear();
    }

    @BeforeMethod
    public void launch() {

        launcher = PlaywrightProvider.get(Browser.CHROME);
        launcher.create();
        launcher.goToPage(URLs.HOME_PAGE.getName());
    }

    @AfterMethod
    public void tearDown() {

        launcher.close();
    }

    protected void goToPage(String url) {

        launcher.goToPage(url);
    }

    protected Page getPage() {

        return PlaywrightBrowserLauncher.getPage();
    }
}
