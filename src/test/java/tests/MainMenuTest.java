package tests;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import qa.dataProviders.MainMenuDataProviders;
import qa.enums.DataDownloadMode;
import qa.exceptions.MockarooRequestException;
import qa.support.dataprovidernames.DataProviderNames;
import qa.pageobject.sections.Header;
import qa.base.BaseTest;
import qa.records.LinkData;
import qa.support.testdatafilenames.TestdataFileNames;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;


public class MainMenuTest extends BaseTest {

    private Header header;

    @BeforeSuite
    public void loadTestdata() throws MalformedURLException, FileNotFoundException, URISyntaxException, MockarooRequestException {

        MainMenuDataProviders.loadTestdata(TestdataFileNames.LINKS, DataDownloadMode.LOCAL);
    }

    @AfterSuite
    public void clearTestdata() {

        MainMenuDataProviders.clear();
    }

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

    @Test(dataProvider = DataProviderNames.WOMEN, dataProviderClass = MainMenuDataProviders.class)
    public void women(LinkData linkData) {

        check("Women", linkData);
    }

    @Test(dataProvider = DataProviderNames.MEN, dataProviderClass = MainMenuDataProviders.class)
    public void men(LinkData linkData) {

        check("Men", linkData);
    }

    @Test(dataProvider = DataProviderNames.ACCESSORIES, dataProviderClass = MainMenuDataProviders.class)
    public void accessories(LinkData linkData) {

        check("Accessories", linkData);
    }

    @Test(dataProvider = DataProviderNames.HOME_DECOR, dataProviderClass = MainMenuDataProviders.class)
    void homeAndDecor(LinkData linkData) {

        check("Home & Decor", linkData);
    }

    @Test(dataProvider = DataProviderNames.SALE, dataProviderClass = MainMenuDataProviders.class)
    void sale(LinkData linkData) {

        check("Sale", linkData);
    }

    @Test(dataProvider = DataProviderNames.VIP, dataProviderClass = MainMenuDataProviders.class)
    void vip(LinkData linkData) {

        header.getMainMenu().clickVip();

        Assert.assertEquals(getPage().url(), linkData.getUrl(),
                "The page with address \"" + linkData.getUrl() + "\" has not been opened");
    }
}
