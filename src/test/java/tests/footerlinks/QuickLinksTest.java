package tests.footerlinks;

import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.pageobject.footer.QuickLinks;
import qa.support.URLs;
import tests.base.BaseTest;

@Epic("E2E")
@Feature("The \"Quick Links\" section links")
public class QuickLinksTest extends BaseTest {

    private QuickLinks quickLinks;

    @BeforeMethod
    public void prepare() {

        quickLinks = new QuickLinks(getPage());
    }

    @Test(priority = 1)
    @Owner("Paweł Aksman")
    @Tag("Links")
    @Tag("Footer")
    @Link(name = "Home page", url = "http://demo-store.seleniumacademy.com/")
    @Description("The \"Site Map\" link")
    public void siteMapLink() {

        clickAndVerifyPageUrl(QuickLinks::clickSiteMapLink, quickLinks, URLs.SITE_MAP_PAGE);
    }

    @Test(priority = 2)
    @Owner("Paweł Aksman")
    @Tag("Links")
    @Tag("Footer")
    @Link(name = "Home page", url = "http://demo-store.seleniumacademy.com/")
    @Description("The \"Search Terms\" link")
    public void searchTermsLink() {

        clickAndVerifyPageUrl(QuickLinks::clickSearchTermsLink, quickLinks, URLs.SEARCH_TERMS_PAGE);
    }

    @Test(priority = 3)
    @Owner("Paweł Aksman")
    @Tag("Links")
    @Tag("Footer")
    @Link(name = "Home page", url = "http://demo-store.seleniumacademy.com/")
    @Description("The \"Advanced Search\" link")
    public void advancedSearch() {

        clickAndVerifyPageUrl(QuickLinks::clickAdvancedSearchLink, quickLinks, URLs.ADVANCED_SEARCH_PAGE);
    }
}
