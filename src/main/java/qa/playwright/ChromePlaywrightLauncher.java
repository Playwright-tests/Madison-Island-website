package qa.playwright;

import com.microsoft.playwright.BrowserType;

public class ChromePlaywrightLauncher extends PlaywrightBrowserLauncher {

    @Override
    protected void setBrowser() {

        browser = playwright
                .chromium()
                .launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false).setSlowMo(50));
    }
}
