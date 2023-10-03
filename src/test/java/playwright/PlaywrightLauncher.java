package playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightLauncher {

    private static Page page;
    public static void launch() {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
        page = browser.newPage();
        page.navigate("http://demo-store.seleniumacademy.com/");
    }

    public static Page getPage() {

        return page;
    }
}
