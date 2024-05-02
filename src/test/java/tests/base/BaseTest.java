package tests.base;

import com.microsoft.playwright.Page;
import org.testng.Assert;
import org.testng.annotations.*;
import qa.base.BaseDataProviders;
import qa.enums.Browser;
import qa.exceptions.MockarooRequestException;
import qa.playwright.PlaywrightBrowserLauncher;
import qa.playwright.PlaywrightProvider;
import qa.support.URLs;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.function.Consumer;


public class BaseTest {

    private PlaywrightBrowserLauncher launcher;

    @Parameters({"fileName", "downloadMode"})
    @BeforeClass
    public void loadTestdata(@Optional("noFile") String fileName, @Optional("noDownloadMode") String downloadMode) throws MalformedURLException, FileNotFoundException, URISyntaxException, MockarooRequestException {

        if (!fileName.equals("noFile") && !downloadMode.equals("noDownloadMode")) {
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
        launcher.goToPage(URLs.HOME_PAGE);
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

    protected <T> void clickAndVerifyPageUrl(Consumer<T> consumer, T object, String expectedUrl) {

        consumer.accept(object);
        Assert.assertEquals(getPage().url(), expectedUrl, "The page " + expectedUrl + " has not been opened");
    }
}
