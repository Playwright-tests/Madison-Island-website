package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.dataProviders.FooterDataProviders;
import qa.support.dataprovidernames.DataProviderNames;
import qa.pageobject.sections.Footer;
import qa.base.BaseTest;
import qa.records.LinkData;

public class FooterLinksTest extends BaseTest {

    private Footer footer;

    @BeforeMethod
    public void create() {

        footer = new Footer(getPage());
    }

    private void check(LinkData linkData) {

        footer.getFooterLinks().clickElementList(linkData.getLink());
        Assert.assertEquals(getPage().url(), linkData.getUrl(),
                "The page with address \"" + linkData.getUrl() + "\" has not been opened");
    }

    @Test(dataProvider = DataProviderNames.COMPANY, dataProviderClass = FooterDataProviders.class)
    public void company(LinkData linkData) {

        check(linkData);
    }

    @Test(dataProvider = DataProviderNames.QUICK_LINKS, dataProviderClass = FooterDataProviders.class)
    public void quickLinks(LinkData linkData) {

        check(linkData);
    }

    @Test(dataProvider = DataProviderNames.ACCOUNT, dataProviderClass = FooterDataProviders.class)
    public void account(LinkData linkData) {

        check(linkData);
    }

    @Test(dataProvider = DataProviderNames.CONNECT_WITH_US, dataProviderClass = FooterDataProviders.class)
    public void connectWithUs(LinkData linkData) {

        check(linkData);
    }
}
