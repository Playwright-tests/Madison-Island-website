package tests;

import qa.dataProvider.Provider;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.extentreportsmanager.ExtentReportsManager;
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

        footer.getFooterLinks().clickElementList(linkData.link());
        Assert.assertEquals(getPage().url(), linkData.url(),
                "The page with address \"" + linkData.url() + "\" has not been opened");
    }

    @Test(dataProvider = "footerCompany", dataProviderClass = Provider.class)
    public void companySection(LinkData linkData) {

        ExtentReportsManager.createTest("Clicking the \"" + linkData.link() + "\" link in the \"COMPANY\" section",
                "Checking whether the page with the address \"" + linkData.url() +  "\" opens after clicking the \"" + linkData.link() + "\" link.");

        check(linkData);
    }

    @Test(dataProvider = "footerQuickLinks", dataProviderClass = Provider.class)
    public void quickLinksSection(LinkData linkData) {

        ExtentReportsManager.createTest("Clicking the \"" + linkData.link() + "\" link in the \"QUICK LINKS\" section",
                "Checking whether the page with the address \"" + linkData.url() +  "\" opens after clicking the \"" + linkData.link() + "\" link.");

        check(linkData);
    }

    @Test(dataProvider = "footerAccount", dataProviderClass = Provider.class)
    public void accountSection(LinkData linkData) {

        ExtentReportsManager.createTest("Clicking the \"" + linkData.link() + "\" link in the \"ACCOUNT\" section",
                "Checking whether the page with the address \"" + linkData.url() +  "\" opens after clicking the \"" + linkData.link() + "\" link.");

        check(linkData);
    }

    @Test(dataProvider = "footerConnectWithUs", dataProviderClass = Provider.class)
    public void connectWithUsSection(LinkData linkData) {

        ExtentReportsManager.createTest("Clicking the \"" + linkData.link() + "\" link in the \"CONNECT WITH US\" section",
                "Checking whether the page with the address \"" + linkData.url() +  "\" opens after clicking the \"" + linkData.link() + "\" link.");

        check(linkData);
    }
}
