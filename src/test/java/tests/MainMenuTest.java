package tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import pages.sections.Header;
import qa.base.BaseTest;
import utils.Function;

public class MainMenuTest extends BaseTest {

    private static Header header;

    @BeforeClass
    public static void init() {

        header = new Header(getPage());
    }

    private void clickItem(Function function, String[] items) {


        for (String item : items) {

            function.run(item);
        }
    }

    @Test
    public void womenDropdownList() {

        String[] items = {"View All Women", "New Arrivals", "Tops & Blouses", "Pants & Denim", "Dresses & Skirts"};

        clickItem((x)->{ header.getMainMenu().hoverParent("Women");
                         header.getMainMenu().clickWomenItem(x); }, items);
    }

    @Test
    public void menDropdownList() {

        String[] items = {"View All Men", "New Arrivals", "Shirts", "Tees, Knits and Polos", "Pants & Denim", "Blazers"};

        clickItem((x)->{ header.getMainMenu().hoverParent("Men");
                         header.getMainMenu().clickMenItem(x); }, items);
    }

    @Test
    public void accessoriesDropdownList() {

        String[] items = {"View All Accessories", "Eyewear", "Jewelry", "Shoes", "Bags & Luggage"};

        clickItem((x)->{ header.getMainMenu().hoverParent("Accessories");
                         header.getMainMenu().clickAccessoriesItem(x); }, items);
    }

    @Test
    void homeAndDecorDropdownList() {

        String[] items = {"View All Home & Decor", "Books & Music", "Bed & Bath", "Electronics", "Decorative Accents"};

        clickItem((x)->{ header.getMainMenu().hoverParent("Home & Decor");
                         header.getMainMenu().clickHomeAndDecorItem(x); }, items);
    }

    @Test
    void saleDropdownList() {

        String[] items = {"View All Sale", "Women", "Men", "Accessories", "Home & Decor"};

        clickItem((x)->{ header.getMainMenu().hoverParent("Sale");
                         header.getMainMenu().clickSaleItem(x); }, items);
    }

    @Test
    void vipLink() {

        header.getMainMenu().clickVip();
    }
}
