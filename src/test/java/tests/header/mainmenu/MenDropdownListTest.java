package tests.header.mainmenu;

import org.testng.annotations.Test;
import tests.base.MainMenuBaseTest;

public class MenDropdownListTest extends MainMenuBaseTest {

    public MenDropdownListTest() {

        setTriggerElement("Men");
    }

    @Test(groups = "withExpandedList")
    public void viewAllMenLink() {

        actionsWithExpandedList("View All Men", "http://demo-store.seleniumacademy.com/men.html");
    }

    @Test(groups = "withExpandedList")
    public void newArrivalsLink() {

        actionsWithExpandedList("New Arrivals", "http://demo-store.seleniumacademy.com/men/new-arrivals.html");
    }

    @Test(groups = "withExpandedList")
    public void shirtsLink() {

        actionsWithExpandedList("Shirts", "http://demo-store.seleniumacademy.com/men/shirts.html");
    }

    @Test(groups = "withExpandedList")
    public void teesKnitsLink() {

        actionsWithExpandedList("Tees, Knits and Polos", "http://demo-store.seleniumacademy.com/men/tees-knits-and-polos.html");
    }

    @Test(groups = "withExpandedList")
    public void pantsAndDenim() {

        actionsWithExpandedList("Pants & Denim", "http://demo-store.seleniumacademy.com/men/pants-denim.html");
    }

    @Test(groups = "withExpandedList")
    public void blazersLink() {

        actionsWithExpandedList("Blazers", "http://demo-store.seleniumacademy.com/men/blazers.html");
    }
}
