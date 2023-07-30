package qa.base;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.BeforeClass;
import utils.JSONReader;

public class BaseTest {

    private static Playwright playwright;
    private static Browser browser;
    private static Page page;

    @BeforeClass
    public static void launch() {

        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
        page = browser.newPage();
        page.navigate("http://demo-store.seleniumacademy.com/");

        JSONReader.read();
    }

    public static Page getPage() {

        return page;
    }
}
