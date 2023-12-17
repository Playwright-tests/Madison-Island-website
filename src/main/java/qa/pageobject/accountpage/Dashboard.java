package qa.pageobject.accountpage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import qa.base.BasePage;

public class Dashboard extends BasePage {

    private final Locator title;

    public Dashboard(Page page) {

        super(page);

        title = page.locator(".page-title");
    }

    public String getTitle() {

        return title.textContent().trim();
    }
}
