package tests;

import dataProvider.Provider;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject.sections.Header;
import qa.base.BaseTest;
import utils.Pair;
import static playwright.PlaywrightLauncher.*;

public class MainMenuTest extends BaseTest {

    private Header header;

    @BeforeMethod
    public void create() {

        header = new Header(getPage());
    }

    private void check(String button, Pair<String, String> data) {

        header.getMainMenu().hoverParent(button);
        header.getMainMenu().clickItem(data.getFirst());

        Assert.assertEquals(getPage().url(), data.getSecond());
    }

    @Test(dataProvider = "mainMenuWomen", dataProviderClass = Provider.class)
    public void women(Pair<String, String> data) {

        check("Women", data);
    }

    @Test(dataProvider = "mainMenuMen", dataProviderClass = Provider.class)
    public void men(Pair<String, String> data) {

        check("Men", data);
    }

    @Test(dataProvider = "mainMenuAccessories", dataProviderClass = Provider.class)
    public void accessories(Pair<String, String> data) {

        check("Accessories", data);
    }

    @Test(dataProvider = "mainMenuHomeDecor", dataProviderClass = Provider.class)
    void homeAndDecor(Pair<String, String> data) {

        check("Home & Decor", data);
    }

    @Test(dataProvider = "mainMenuSale", dataProviderClass = Provider.class)
    void sale(Pair<String, String> data) {

        check("Sale", data);
        //check((MainMenu mm)->{ mm.clickSaleItem(data.getFirst()); }, "Sale", data.getSecond());
    }

    @Test(dataProvider = "mainMenuVIP", dataProviderClass = Provider.class)
    void vip(String expectedURL) {

        header.getMainMenu().clickVip();

        Assert.assertEquals(getPage().url(), expectedURL);
    }
}
