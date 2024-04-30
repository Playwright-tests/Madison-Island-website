package tests.header.mainmenu;

import org.testng.annotations.Test;
import tests.base.MainMenuBaseTest;

public class AccessoriesDropdownListTest extends MainMenuBaseTest {

    public AccessoriesDropdownListTest() {

        setTriggerElement("Accessories");
    }

    @Test(groups = "withExpandedList")
    public void viewAllAccessoriesLink() {

        actionsWithExpandedList("View All Accessories", "http://demo-store.seleniumacademy.com/accessories.html");
    }

    @Test(groups = "withExpandedList")
    public void eyewearLink() {

        actionsWithExpandedList("Eyewear", "http://demo-store.seleniumacademy.com/accessories/eyewear.html");
    }

    @Test(groups = "withExpandedList")
    public void jewelryLink() {

        actionsWithExpandedList("Jewelry", "http://demo-store.seleniumacademy.com/accessories/jewelry.html");
    }

    @Test(groups = "withExpandedList")
    public void shoes() {

        actionsWithExpandedList("Shoes", "http://demo-store.seleniumacademy.com/accessories/shoes.html");
    }

    @Test(groups = "withExpandedList")
    public void bagsAndLuggage() {

        actionsWithExpandedList("Bags & Luggage", "http://demo-store.seleniumacademy.com/accessories/bags-luggage.html");
    }
}
