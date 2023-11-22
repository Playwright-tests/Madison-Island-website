package qa.base;

import com.microsoft.playwright.Page;
import org.json.simple.parser.ParseException;
import org.testng.annotations.*;
import qa.enums.Browser;
import qa.json.JSONReader;
import qa.playwright.PlaywrightBrowserLauncher;
import qa.playwright.PlaywrightProvider;

import java.io.IOException;


public class BaseTest {

    private PlaywrightBrowserLauncher launcher;

    @BeforeClass
    public void init() throws IOException, ParseException {

        JSONReader.read();
    }

    @BeforeMethod
    public void launch() {

        launcher = PlaywrightProvider.get(Browser.WEBKIT);
        launcher.launch("http://demo-store.seleniumacademy.com/");
    }

    @AfterMethod
    public void tearDown() {

        launcher.close();
    }

    protected Page getPage() {

        return PlaywrightBrowserLauncher.getPage();
    }
}
