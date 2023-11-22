package qa.playwright;

import com.microsoft.playwright.BrowserType;

public class WebkitPlaywrightLauncher extends PlaywrightBrowserLauncher {

    @Override
    protected void setBrowser() {

        browser = playwright
                .webkit()
                .launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
    }
}
