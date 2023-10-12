package tests;

import dataProvider.Provider;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject.components.MainMenu;
import pageobject.sections.Header;
import qa.base.BaseTest;
import utils.Pair;
import java.util.function.Consumer;
import static playwright.PlaywrightLauncher.*;

public class MainMenuTest extends BaseTest {

    private Header header;

    @BeforeMethod
    public void create() {

        header = new Header(getPage());
    }

    private void check(Consumer<MainMenu> consumer, String menuButton, String expectedURL) {

        header.getMainMenu().hoverParent(menuButton);
        consumer.accept(header.getMainMenu());

        Assert.assertEquals(getPage().url(), expectedURL);
    }

    @Test(dataProvider = "mainMenuWomen", dataProviderClass = Provider.class)
    public void women(Pair<String, String> data) {

        check((MainMenu mm)->{ mm.clickWomenItem(data.getFirst()); }, "Women", data.getSecond());
    }

    @Test(dataProvider = "mainMenuMen", dataProviderClass = Provider.class)
    public void men(Pair<String, String> data) {

        check((MainMenu mm)->{ mm.clickMenItem(data.getFirst()); }, "Men", data.getSecond());
    }

    @Test(dataProvider = "mainMenuAccessories", dataProviderClass = Provider.class)
    public void accessories(Pair<String, String> data) {

        check((MainMenu mm)->{ mm.clickAccessoriesItem(data.getFirst()); }, "Accessories", data.getSecond());
    }

    @Test(dataProvider = "mainMenuHomeDecor", dataProviderClass = Provider.class)
    void homeAndDecor(Pair<String, String> data) {

        check((MainMenu mm)->{ mm.clickHomeAndDecorItem(data.getFirst()); }, "Home & Decor", data.getSecond());
    }

    @Test(dataProvider = "mainMenuSale", dataProviderClass = Provider.class)
    void sale(Pair<String, String> data) {

        check((MainMenu mm)->{ mm.clickSaleItem(data.getFirst()); }, "Sale", data.getSecond());
    }

    @Test(dataProvider = "mainMenuVIP", dataProviderClass = Provider.class)
    void vip(String expectedURL) {

        header.getMainMenu().clickVip();

        Assert.assertEquals(getPage().url(), expectedURL);
    }
}
