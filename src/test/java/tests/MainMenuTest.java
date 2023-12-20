package tests;

import qa.dataProvider.Provider;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.extentreportsmanager.ExtentReportsManager;
import qa.pageobject.sections.Header;
import qa.base.BaseTest;
import qa.records.LinkData;


public class MainMenuTest extends BaseTest {

    private Header header;

    @BeforeMethod
    public void create() {

        header = new Header(getPage());
    }

    private void check(String button, LinkData linkData) {

        header.getMainMenu().hoverParent(button);
        header.getMainMenu().clickItem(linkData.getLink());

        Assert.assertEquals(getPage().url(), linkData.getUrl(),
                "The page with address \"" + linkData.getUrl() + "\" has not been opened");
    }

    @Test(dataProvider = "mainMenuWomen", dataProviderClass = Provider.class)
    public void women(LinkData linkData) {

        ExtentReportsManager.createTest("Clicking the \"" + linkData.getLink() + "\" link in the \"Women\" section",
                "Checking whether the page with the address \"" + linkData.getUrl() +  "\" opens after clicking the \"" + linkData.getLink() + "\" link.");

        check("Women", linkData);
    }

    @Test(dataProvider = "mainMenuMen", dataProviderClass = Provider.class)
    public void men(LinkData linkData) {

        ExtentReportsManager.createTest("Clicking the \"" + linkData.getLink() + "\" link in the \"Men\" section",
                "Checking whether the page with the address \"" + linkData.getUrl() +  "\" opens after clicking the \"" + linkData.getLink() + "\" link.");

        check("Men", linkData);
    }

    @Test(dataProvider = "mainMenuAccessories", dataProviderClass = Provider.class)
    public void accessories(LinkData linkData) {

        ExtentReportsManager.createTest("Clicking the \"" + linkData.getLink() + "\" link in the \"Accessories\" section",
                "Checking whether the page with the address \"" + linkData.getUrl() +  "\" opens after clicking the \"" + linkData.getLink() + "\" link.");

        check("Accessories", linkData);
    }

    @Test(dataProvider = "mainMenuHomeDecor", dataProviderClass = Provider.class)
    void homeAndDecor(LinkData linkData) {

        ExtentReportsManager.createTest("Clicking the \"" + linkData.getLink() + "\" link in the \"Home and Decor\" section",
                "Checking whether the page with the address \"" + linkData.getUrl() +  "\" opens after clicking the \"" + linkData.getLink() + "\" link.");

        check("Home & Decor", linkData);
    }

    @Test(dataProvider = "mainMenuSale", dataProviderClass = Provider.class)
    void sale(LinkData linkData) {

        ExtentReportsManager.createTest("Clicking the \"" + linkData.getLink() + "\" link in the \"Sale\" section",
                "Checking whether the page with the address \"" + linkData.getUrl() +  "\" opens after clicking the \"" + linkData.getLink() + "\" link.");

        check("Sale", linkData);
    }

    @Test(dataProvider = "mainMenuVIP", dataProviderClass = Provider.class)
    void vip(LinkData linkData) {

        ExtentReportsManager.createTest("Clicking the \"" + linkData.getLink() + "\" link in the \"CONNECT WITH US\" section",
                "Checking whether the page with the address \"" + linkData.getUrl() +  "\" opens after clicking the \"" + linkData.getLink() + "\" link.");

        header.getMainMenu().clickVip();

        Assert.assertEquals(getPage().url(), linkData.getUrl(),
                "The page with address \"" + linkData.getUrl() + "\" has not been opened");
    }
}
