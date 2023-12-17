package qa.base;

import com.microsoft.playwright.Page;
import org.json.simple.parser.ParseException;
import org.testng.annotations.*;
import qa.enums.Browser;
import qa.json.JSONReader;
import qa.playwright.PlaywrightBrowserLauncher;
import qa.playwright.PlaywrightProvider;
import qa.enums.URLs;

import java.io.IOException;


public class BaseTest {

    private PlaywrightBrowserLauncher launcher;

    @BeforeClass
    public void init() throws IOException, ParseException {

        JSONReader.read();
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
