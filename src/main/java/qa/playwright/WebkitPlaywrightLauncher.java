package qa.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;

public class WebkitPlaywrightLauncher extends PlaywrightBrowserLauncher {

    @Override
    public Browser launch() {

        Playwright playwright = Playwright.create();

        return playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
    }
}
