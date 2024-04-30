package tests.header.mainmenu;

import org.testng.annotations.Test;
import tests.base.MainMenuBaseTest;

public class MainMenuLinksTest extends MainMenuBaseTest {


    @Test(groups = "withoutExpandedList")
    public void womenLink() {

        actionsWithoutExpandedList("Women", "http://demo-store.seleniumacademy.com/women.html");
    }

    @Test(groups = "withoutExpandedList")
    public void menLink() {

        actionsWithoutExpandedList("Men", "http://demo-store.seleniumacademy.com/men.html");
    }

    @Test(groups = "withoutExpandedList")
    public void accessoriesLink() {

        actionsWithoutExpandedList("Accessories", "http://demo-store.seleniumacademy.com/accessories.html");
    }

    @Test(groups = "withoutExpandedList")
    public void homeAndDecorLink() {

        actionsWithoutExpandedList("Home & Decor", "http://demo-store.seleniumacademy.com/home-decor.html");
    }

    @Test(groups = "withoutExpandedList")
    public void saleLink() {

        actionsWithoutExpandedList("Sale", "http://demo-store.seleniumacademy.com/sale.html");
    }

    @Test(groups = "withoutExpandedList")
    public void vipLink() {

        actionsWithoutExpandedList("VIP", "http://demo-store.seleniumacademy.com/vip.html");
    }
}
