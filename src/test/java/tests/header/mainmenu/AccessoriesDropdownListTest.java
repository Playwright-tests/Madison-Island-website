package tests.header.mainmenu;

import org.testng.annotations.Test;
import tests.base.MainMenuBaseTest;

public class AccessoriesDropdownListTest extends MainMenuBaseTest {

    public AccessoriesDropdownListTest() {

        setTriggerElement("Accessories");
    }

    @Test(groups = "withExpandedList")
    public void viewAllAccessoriesLink() {

        actions("View All Accessories", "http://demo-store.seleniumacademy.com/accessories.html");
    }

    @Test(groups = "withExpandedList")
    public void eyewearLink() {

        actions("Eyewear", "http://demo-store.seleniumacademy.com/accessories/eyewear.html");
    }

    @Test(groups = "withExpandedList")
    public void jewelryLink() {

        actions("Jewelry", "http://demo-store.seleniumacademy.com/accessories/jewelry.html");
    }

    @Test(groups = "withExpandedList")
    public void shoes() {

        actions("Shoes", "http://demo-store.seleniumacademy.com/accessories/shoes.html");
    }

    @Test(groups = "withExpandedList")
    public void bagsAndLuggage() {

        actions("Bags & Luggage", "http://demo-store.seleniumacademy.com/accessories/bags-luggage.html");
    }
}
