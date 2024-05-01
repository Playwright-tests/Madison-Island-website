package tests.header.mainmenu;

import org.testng.annotations.Test;
import qa.support.URLs;
import tests.base.MainMenuBaseTest;

public class SaleDropdownListTest extends MainMenuBaseTest {

    public SaleDropdownListTest() {

        setTriggerElement("Sale");
    }

    @Test(groups = "withExpandedList")
    public void viewAllSaleLink() {

        actionsForDropdownLists("View All Sale", URLs.SALE_PAGE);
    }

    @Test(groups = "withExpandedList")
    public void womenLink() {

        actionsForDropdownLists("Women", URLs.SALE_WOMEN_PAGE);
    }

    @Test(groups = "withExpandedList")
    public void menLink() {

        actionsForDropdownLists("Men", URLs.SALE_MEN_PAGE);
    }

    @Test(groups = "withExpandedList")
    public void accessories() {

        actionsForDropdownLists("Accessories", URLs.SALE_ACCESSORIES_PAGE);
    }

    @Test(groups = "withExpandedList")
    public void homeAndDecorLink() {

        actionsForDropdownLists("Home & Decor", URLs.SALE_HOME_DECOR_PAGE);
    }
}
