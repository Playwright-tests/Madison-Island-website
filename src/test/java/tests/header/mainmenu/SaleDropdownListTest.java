package tests.header.mainmenu;

import org.testng.annotations.Test;
import tests.base.MainMenuBaseTest;

public class SaleDropdownListTest extends MainMenuBaseTest {

    public SaleDropdownListTest() {

        setTriggerElement("Sale");
    }

    @Test(groups = "withExpandedList")
    public void viewAllSaleLink() {

        actionsWithExpandedList("View All Sale", "http://demo-store.seleniumacademy.com/sale.html");
    }

    @Test(groups = "withExpandedList")
    public void womenLink() {

        actionsWithExpandedList("Women", "http://demo-store.seleniumacademy.com/sale/women.html");
    }

    @Test(groups = "withExpandedList")
    public void menLink() {

        actionsWithExpandedList("Men", "http://demo-store.seleniumacademy.com/sale/men.html");
    }

    @Test(groups = "withExpandedList")
    public void accessories() {

        actionsWithExpandedList("Accessories", "http://demo-store.seleniumacademy.com/sale/accessories.html");
    }

    @Test(groups = "withExpandedList")
    public void homeAndDecorLink() {

        actionsWithExpandedList("Home & Decor", "http://demo-store.seleniumacademy.com/sale/home-decor.html");
    }
}
