package qa.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class PlaywrightBrowserLauncher {

    protected Playwright playwright;
    protected Browser browser;

    protected static Page page;

    private final Logger logger = LoggerFactory.getLogger(PlaywrightBrowserLauncher.class);


    protected void setBrowserInfo() {

        logger.info("Browser: " + browser.browserType().name() + " " + browser.version());
    }

    protected void setPlaywright() {

        playwright = Playwright.create();
    }

    protected void setPage() {

        page = browser.newPage();
    }
    protected abstract void setBrowser();

    public void create() {

        setPlaywright();
        setBrowser();
        setPage();
    }

    public void goToPage(String url) {

        page.navigate(url);

        logger.info("Opening page...");
        logger.info("URL: " + url);
    }

    public static Page getPage() {

        return page;
    }

    public void close() {

        logger.info("Closing...");

        page.close();
        browser.close();
        playwright.close();
    }
}
