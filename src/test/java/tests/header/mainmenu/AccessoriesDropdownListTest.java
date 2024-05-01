package tests.header.mainmenu;

import org.testng.annotations.Test;
import qa.support.URLs;
import tests.base.MainMenuBaseTest;

public class AccessoriesDropdownListTest extends MainMenuBaseTest {

    public AccessoriesDropdownListTest() {

        setTriggerElement("Accessories");
    }

    @Test(groups = "withExpandedList")
    public void viewAllAccessoriesLink() {

        actionsForDropdownLists("View All Accessories", URLs.ACCESSORIES_PAGE);
    }

    @Test(groups = "withExpandedList")
    public void eyewearLink() {

        actionsForDropdownLists("Eyewear", URLs.EYEWEAR_PAGE);
    }

    @Test(groups = "withExpandedList")
    public void jewelryLink() {

        actionsForDropdownLists("Jewelry", URLs.JEWELRY_PAGE);
    }

    @Test(groups = "withExpandedList")
    public void shoes() {

        actionsForDropdownLists("Shoes", URLs.SHOES_PAGE);
    }

    @Test(groups = "withExpandedList")
    public void bagsAndLuggage() {

        actionsForDropdownLists("Bags & Luggage", URLs.BAGS_LUGGAGE_PAGE);
    }
}
