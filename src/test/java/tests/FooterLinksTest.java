package tests;

import qa.dataProviders.DataProviders;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.localtestdata.LocalTestdata;
import qa.pageobject.sections.Footer;
import qa.base.BaseTest;
import qa.records.LinkData;


public class FooterLinksTest extends BaseTest {

    private Footer footer;

    public FooterLinksTest() { }

    @BeforeMethod
    public void create() {

        footer = new Footer(getPage());
    }

    private void check(LinkData linkData) {

        footer.getFooterLinks().clickElementList(linkData.getLink());
        Assert.assertEquals(getPage().url(), linkData.getUrl(),
                "The page with address \"" + linkData.getUrl() + "\" has not been opened");
    }

    @Test(dataProvider = LocalTestdata.FOOTER_COMPANY, dataProviderClass = DataProviders.class)
    public void companySection(LinkData linkData) {

        check(linkData);
    }

    @Test(dataProvider = LocalTestdata.FOOTER_QUICK_LINKS, dataProviderClass = DataProviders.class)
    public void quickLinksSection(LinkData linkData) {

        check(linkData);
    }

    @Test(dataProvider = LocalTestdata.FOOTER_ACCOUNT, dataProviderClass = DataProviders.class)
    public void accountSection(LinkData linkData) {

        check(linkData);
    }

    @Test(dataProvider = LocalTestdata.FOOTER_CONNECT_WITH_US, dataProviderClass = DataProviders.class)
    public void connectWithUsSection(LinkData linkData) {

        check(linkData);
    }
}
