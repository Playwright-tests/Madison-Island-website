package tests.header.mainmenu;

import org.testng.annotations.Test;
import tests.base.MainMenuBaseTest;


public class WomenDropdownListTest extends MainMenuBaseTest {

    public WomenDropdownListTest() {

        setTriggerElement("Women");
    }

    @Test(groups = "withExpandedList")
    public void viewAllWomenLink() {

        actions("View All Women", "http://demo-store.seleniumacademy.com/women.html");
    }

    @Test(groups = "withExpandedList")
    public void newArrivalsLink() {

        actions("New Arrivals", "http://demo-store.seleniumacademy.com/women/new-arrivals.html");
    }

    @Test(groups = "withExpandedList")
    public void topsAndBlousesLink() {

        actions("Tops & Blouses", "http://demo-store.seleniumacademy.com/women/tops-blouses.html");
    }

    @Test(groups = "withExpandedList")
    public void pantsAndDenimLink() {

        actions("Pants & Denim", "http://demo-store.seleniumacademy.com/women/pants-denim.html");
    }

    @Test(groups = "withExpandedList")
    public void dressesAndSkirtsLink() {

        actions("Dresses & Skirts", "http://demo-store.seleniumacademy.com/women/dresses-skirts.html");
    }
}
