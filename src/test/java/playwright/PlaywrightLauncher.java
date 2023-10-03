package playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightLauncher {

    private static Playwright playwright;
    private static Browser browser;
    private static Page page;
    private static final String url = "http://demo-store.seleniumacademy.com/";

    public static void launch() {

        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
        page = browser.newPage();
        page.navigate(url);
    }

    public static Page getPage() {

        return page;
    }

    public static void close() {

        page.close();
        browser.close();
        playwright.close();
    }

    public static String getUrl() {

        return url;
    }
}
