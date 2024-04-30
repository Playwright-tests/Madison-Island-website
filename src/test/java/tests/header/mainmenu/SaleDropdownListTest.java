package tests.header.mainmenu;

import org.testng.annotations.Test;
import tests.base.MainMenuBaseTest;

public class SaleDropdownListTest extends MainMenuBaseTest {

    public SaleDropdownListTest() {

        setTriggerElement("Sale");
    }

    @Test(groups = "withExpandedList")
    public void viewAllSaleLink() {

        actions("View All Sale", "http://demo-store.seleniumacademy.com/sale.html");
    }

    @Test(groups = "withExpandedList")
    public void womenLink() {

        actions("Women", "http://demo-store.seleniumacademy.com/sale/women.html");
    }

    @Test(groups = "withExpandedList")
    public void menLink() {

        actions("Men", "http://demo-store.seleniumacademy.com/sale/men.html");
    }

    @Test(groups = "withExpandedList")
    public void accessories() {

        actions("Accessories", "http://demo-store.seleniumacademy.com/sale/accessories.html");
    }

    @Test(groups = "withExpandedList")
    public void homeAndDecorLink() {

        actions("Home & Decor", "http://demo-store.seleniumacademy.com/sale/home-decor.html");
    }
}
