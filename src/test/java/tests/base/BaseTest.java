package tests.base;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;
import org.testng.Assert;
import org.testng.annotations.*;
import qa.support.TestDataLoader;
import qa.enums.Browser;
import qa.playwright.PlaywrightBrowserLauncher;
import qa.playwright.PlaywrightProvider;
import qa.support.URLs;

import java.io.FileNotFoundException;
import java.util.function.Consumer;


public class BaseTest {

    private PlaywrightBrowserLauncher launcher;

    @Parameters({"fileName"})
    @BeforeClass
    public void loadTestData(@Optional("noFile") String fileName) throws FileNotFoundException {

        if (!fileName.equals("noFile")) {
            TestDataLoader.load(fileName);
        }
    }

    @Parameters({"fileName"})
    @BeforeMethod
    public void launch(@Optional("noFile") String fileName) {

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

    protected <T> void clickAndCheckDropdownState(Consumer<T> consumer, T object, WaitForSelectorState selectorState, String selector, String expectedState) {

        consumer.accept(object);

        try {
            getPage().waitForSelector(selector, new Page.WaitForSelectorOptions().setTimeout(2000)
                    .setState(selectorState));
        } catch (Exception e) {
            Assert.fail("The dropdown list has not been " + expectedState);
        }
    }
}
