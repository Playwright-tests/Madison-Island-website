package tests.header.mainmenu;

import org.testng.annotations.Test;
import tests.base.MainMenuBaseTest;


public class WomenDropdownListTest extends MainMenuBaseTest {

    public WomenDropdownListTest() {

        setTriggerElement("Women");
    }

    @Test(groups = "withExpandedList")
    public void viewAllWomenLink() {

        actionsWithExpandedList("View All Women", "http://demo-store.seleniumacademy.com/women.html");
    }

    @Test(groups = "withExpandedList")
    public void newArrivalsLink() {

        actionsWithExpandedList("New Arrivals", "http://demo-store.seleniumacademy.com/women/new-arrivals.html");
    }

    @Test(groups = "withExpandedList")
    public void topsAndBlousesLink() {

        actionsWithExpandedList("Tops & Blouses", "http://demo-store.seleniumacademy.com/women/tops-blouses.html");
    }

    @Test(groups = "withExpandedList")
    public void pantsAndDenimLink() {

        actionsWithExpandedList("Pants & Denim", "http://demo-store.seleniumacademy.com/women/pants-denim.html");
    }

    @Test(groups = "withExpandedList")
    public void dressesAndSkirtsLink() {

        actionsWithExpandedList("Dresses & Skirts", "http://demo-store.seleniumacademy.com/women/dresses-skirts.html");
    }
}
