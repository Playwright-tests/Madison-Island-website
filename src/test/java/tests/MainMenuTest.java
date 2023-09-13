package tests;

import dataProvider.Provider;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import pages.sections.Header;
import qa.base.BaseTest;
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

        String[] items = {"View All Women", "New Arrivals", "Tops & Blouses", "Pants & Denim", "Dresses & Skirts"};

        clickItem((x)->{ header.getMainMenu().hoverParent("Women");
                         header.getMainMenu().clickWomenItem(x); }, items, URLs);
    }

    @Test(dataProvider = "mainMenuMen", dataProviderClass = Provider.class)
    public void menDropdownList(String[] URLs) {

        String[] items = {"View All Men", "New Arrivals", "Shirts", "Tees, Knits and Polos", "Pants & Denim", "Blazers"};

        clickItem((x)->{ header.getMainMenu().hoverParent("Men");
                         header.getMainMenu().clickMenItem(x); }, items, URLs);
    }

    @Test(dataProvider = "mainMenuAccessories", dataProviderClass = Provider.class)
    public void accessoriesDropdownList(String[] URLs) {

        String[] items = {"View All Accessories", "Eyewear", "Jewelry", "Shoes", "Bags & Luggage"};

        clickItem((x)->{ header.getMainMenu().hoverParent("Accessories");
                         header.getMainMenu().clickAccessoriesItem(x); }, items, URLs);
    }

    @Test(dataProvider = "mainMenuHomeDecor", dataProviderClass = Provider.class)
    void homeAndDecorDropdownList(String[] URLs) {

        String[] items = {"View All Home & Decor", "Books & Music", "Bed & Bath", "Electronics", "Decorative Accents"};

        clickItem((x)->{ header.getMainMenu().hoverParent("Home & Decor");
                         header.getMainMenu().clickHomeAndDecorItem(x); }, items, URLs);
    }

    @Test(dataProvider = "mainMenuSale", dataProviderClass = Provider.class)
    void saleDropdownList(String[] URLs) {

        String[] items = {"View All Sale", "Women", "Men", "Accessories", "Home & Decor"};

        clickItem((x)->{ header.getMainMenu().hoverParent("Sale");
                         header.getMainMenu().clickSaleItem(x); }, items, URLs);
    }

    @Test
    void vipLink() {

        header.getMainMenu().clickVip();
    }
}
