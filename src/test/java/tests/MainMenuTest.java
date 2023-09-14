package tests;

import dataProvider.Provider;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import pages.sections.Header;
import qa.base.BaseTest;
import qa.base.constans.MainMenuButtonNames;

import java.util.function.Consumer;

public class MainMenuTest extends BaseTest {

    private static Header header;

    @BeforeClass
    public static void init() {

        header = new Header(getPage());
    }

    private void clickItem(Consumer<String> consumer, String[] items, String[] URLs) {

        for (int i = 0; i < items.length; i++) {

            consumer.accept(items[i]);

            Assert.assertEquals(getPage().url(), URLs[i]);
        }
    }

    @Test(dataProvider = "mainMenuWomen", dataProviderClass = Provider.class)
    public void womenDropdownList(String[] URLs) {

        clickItem((x)->{ header.getMainMenu().hoverParent("Women");
                         header.getMainMenu().clickWomenItem(x); }, MainMenuButtonNames.women, URLs);
    }

    @Test(dataProvider = "mainMenuMen", dataProviderClass = Provider.class)
    public void menDropdownList(String[] URLs) {

        clickItem((x)->{ header.getMainMenu().hoverParent("Men");
                         header.getMainMenu().clickMenItem(x); }, MainMenuButtonNames.men, URLs);
    }

    @Test(dataProvider = "mainMenuAccessories", dataProviderClass = Provider.class)
    public void accessoriesDropdownList(String[] URLs) {

        clickItem((x)->{ header.getMainMenu().hoverParent("Accessories");
                         header.getMainMenu().clickAccessoriesItem(x); }, MainMenuButtonNames.accessories, URLs);
    }

    @Test(dataProvider = "mainMenuHomeDecor", dataProviderClass = Provider.class)
    void homeAndDecorDropdownList(String[] URLs) {

        clickItem((x)->{ header.getMainMenu().hoverParent("Home & Decor");
                         header.getMainMenu().clickHomeAndDecorItem(x); }, MainMenuButtonNames.homeAndDecor, URLs);
    }

    @Test(dataProvider = "mainMenuSale", dataProviderClass = Provider.class)
    void saleDropdownList(String[] URLs) {

        clickItem((x)->{ header.getMainMenu().hoverParent("Sale");
                         header.getMainMenu().clickSaleItem(x); }, MainMenuButtonNames.sale, URLs);
    }

    @Test(dataProvider = "mainMenuVIP", dataProviderClass = Provider.class)
    void vipLink(String[] URLs) {

        header.getMainMenu().clickVip();

        Assert.assertEquals(getPage().url(), URLs[0]);
    }
}
