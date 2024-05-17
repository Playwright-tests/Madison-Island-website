package qa.pageobject.footer;

import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

public class QuickLinks extends FooterLinksSection {

    public QuickLinks(Page page) {

        super(page);
    }

    @Step("Click the \"Site Map\" link")
    public void clickSiteMapLink() {

        clickLink("Site Map");
    }

    @Step("Click the \"Search Terms\" link")
    public void clickSearchTermsLink() {

        clickLink("Search Terms");
    }

    @Step("Click the \"Advanced Search\" link")
    public void clickAdvancedSearchLink() {

        clickLink("Advanced Search");
    }
}
