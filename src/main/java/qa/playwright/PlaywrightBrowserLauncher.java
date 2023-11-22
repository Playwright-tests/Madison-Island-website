package qa.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public abstract class PlaywrightBrowserLauncher {

    protected Playwright playwright;
    protected Browser browser;
    protected static Page page;

    protected void setPlaywright() {

        playwright = Playwright.create();
    }

    protected void setPage(String url) {

        page = browser.newPage();
        page.navigate(url);
    }
    protected abstract void setBrowser();


    public void launch(String url) {

        setPlaywright();
        setBrowser();
        setPage(url);
    }

    public static Page getPage() {

        return page;
    }

    public void close() {

        page.close();
        browser.close();
        playwright.close();
    }
}
