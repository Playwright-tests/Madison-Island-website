package qa.playwright;

import com.microsoft.playwright.BrowserType;

public class EdgePlaywrightLauncher extends PlaywrightBrowserLauncher {

    @Override
    protected void setBrowser() {

        browser = playwright
                .chromium()
                .launch(new BrowserType.LaunchOptions().setChannel("msedge").setHeadless(false).setSlowMo(50));

        setBrowserInfo();

    }
}
