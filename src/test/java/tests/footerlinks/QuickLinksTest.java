package tests.footerlinks;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.pageobject.footer.QuickLinks;
import qa.support.URLs;
import tests.base.BaseTest;

public class QuickLinksTest extends BaseTest {

    private QuickLinks quickLinks;

    @BeforeMethod
    public void prepare() {

        quickLinks = new QuickLinks(getPage());
    }

    @Test
    public void siteMapLink() {

        clickAndVerifyPageUrl(QuickLinks::clickSiteMapLink, quickLinks, URLs.SITE_MAP_PAGE);
    }

    @Test
    public void searchTermsLink() {

        clickAndVerifyPageUrl(QuickLinks::clickSearchTermsLink, quickLinks, URLs.SEARCH_TERMS_PAGE);
    }

    @Test
    public void advancedSearch() {

        clickAndVerifyPageUrl(QuickLinks::clickAdvancedSearchLink, quickLinks, URLs.ADVANCED_SEARCH_PAGE);
    }
}
