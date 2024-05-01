package tests.header.mainmenu;

import org.testng.annotations.Test;
import qa.support.URLs;
import tests.base.MainMenuBaseTest;


public class WomenDropdownListTest extends MainMenuBaseTest {

    public WomenDropdownListTest() {

        setTriggerElement("Women");
    }

    @Test(groups = "withExpandedList")
    public void viewAllWomenLink() {

        actionsForDropdownLists("View All Women", URLs.WOMEN_PAGE);
    }

    @Test(groups = "withExpandedList")
    public void newArrivalsLink() {

        actionsForDropdownLists("New Arrivals", URLs.WOMEN_NEW_ARRIVALS_PAGE);
    }

    @Test(groups = "withExpandedList")
    public void topsAndBlousesLink() {

        actionsForDropdownLists("Tops & Blouses", URLs.TOPS_BLOUSES_PAGE);
    }

    @Test(groups = "withExpandedList")
    public void pantsAndDenimLink() {

        actionsForDropdownLists("Pants & Denim", URLs.WOMEN_PANTS_DENIM_PAGE);
    }

    @Test(groups = "withExpandedList")
    public void dressesAndSkirtsLink() {

        actionsForDropdownLists("Dresses & Skirts", URLs.DRESSES_SKIRTS_PAGE);
    }
}
