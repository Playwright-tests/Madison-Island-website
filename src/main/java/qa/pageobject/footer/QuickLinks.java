package qa.pageobject.footer;

import com.microsoft.playwright.Page;

public class QuickLinks extends FooterLinksSection {

    public QuickLinks(Page page) {

        super(page);
    }

    public void clickSiteMapLink() {

        clickLink("Site Map");
    }

    public void clickSearchTermsLink() {

        clickLink("Search Terms");
    }

    public void clickAdvancedSearchLink() {

        clickLink("Advanced Search");
    }
}
