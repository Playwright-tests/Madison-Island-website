package tests;

import qa.dataProviders.DataProviders;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.localtestdata.LocalTestdata;
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

    @Test(dataProvider = LocalTestdata.MAIN_MENU_WOMEN, dataProviderClass = DataProviders.class)
    public void women(LinkData linkData) {

        check("Women", linkData);
    }

    @Test(dataProvider = LocalTestdata.MAIN_MENU_MEN, dataProviderClass = DataProviders.class)
    public void men(LinkData linkData) {

        check("Men", linkData);
    }

    @Test(dataProvider = LocalTestdata.MAIN_MENU_ACCESSORIES, dataProviderClass = DataProviders.class)
    public void accessories(LinkData linkData) {

        check("Accessories", linkData);
    }

    @Test(dataProvider = LocalTestdata.MAIN_MENU_HOME_DECOR, dataProviderClass = DataProviders.class)
    void homeAndDecor(LinkData linkData) {

        check("Home & Decor", linkData);
    }

    @Test(dataProvider = LocalTestdata.MAIN_MENU_SALE, dataProviderClass = DataProviders.class)
    void sale(LinkData linkData) {

        check("Sale", linkData);
    }

    @Test(dataProvider = LocalTestdata.MAIN_MENU_VIP, dataProviderClass = DataProviders.class)
    void vip(LinkData linkData) {

        header.getMainMenu().clickVip();

        Assert.assertEquals(getPage().url(), linkData.getUrl(),
                "The page with address \"" + linkData.getUrl() + "\" has not been opened");
    }
}
