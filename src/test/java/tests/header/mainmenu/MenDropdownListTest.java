package tests.header.mainmenu;

import org.testng.annotations.Test;
import tests.base.MainMenuBaseTest;

public class MenDropdownListTest extends MainMenuBaseTest {

    public MenDropdownListTest() {

        setTriggerElement("Men");
    }

    @Test(groups = "withExpandedList")
    public void viewAllMenLink() {

        actions("View All Men", "http://demo-store.seleniumacademy.com/men.html");
    }

    @Test(groups = "withExpandedList")
    public void newArrivalsLink() {

        actions("New Arrivals", "http://demo-store.seleniumacademy.com/men/new-arrivals.html");
    }

    @Test(groups = "withExpandedList")
    public void shirtsLink() {

        actions("Shirts", "http://demo-store.seleniumacademy.com/men/shirts.html");
    }

    @Test(groups = "withExpandedList")
    public void teesKnitsLink() {

        actions("Tees, Knits and Polos", "http://demo-store.seleniumacademy.com/men/tees-knits-and-polos.html");
    }

    @Test(groups = "withExpandedList")
    public void pantsAndDenim() {

        actions("Pants & Denim", "http://demo-store.seleniumacademy.com/men/pants-denim.html");
    }

    @Test(groups = "withExpandedList")
    public void blazersLink() {

        actions("Blazers", "http://demo-store.seleniumacademy.com/men/blazers.html");
    }
}
