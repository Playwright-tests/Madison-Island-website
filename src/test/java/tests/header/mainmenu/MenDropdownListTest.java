package tests.header.mainmenu;

import org.testng.annotations.Test;
import qa.support.URLs;
import tests.base.MainMenuBaseTest;

public class MenDropdownListTest extends MainMenuBaseTest {

    public MenDropdownListTest() {

        setTriggerElement("Men");
    }

    @Test(groups = "withExpandedList")
    public void viewAllMenLink() {

        actionsForDropdownLists("View All Men", URLs.MEN_PAGE);
    }

    @Test(groups = "withExpandedList")
    public void newArrivalsLink() {

        actionsForDropdownLists("New Arrivals", URLs.MEN_NEW_ARRIVALS_PAGE);
    }

    @Test(groups = "withExpandedList")
    public void shirtsLink() {

        actionsForDropdownLists("Shirts", URLs.SHIRTS_PAGE);
    }

    @Test(groups = "withExpandedList")
    public void teesKnitsLink() {

        actionsForDropdownLists("Tees, Knits and Polos", URLs.TEES_PAGE);
    }

    @Test(groups = "withExpandedList")
    public void pantsAndDenim() {

        actionsForDropdownLists("Pants & Denim", URLs.MEN_PANTS_DENIM_PAGE);
    }

    @Test(groups = "withExpandedList")
    public void blazersLink() {

        actionsForDropdownLists("Blazers", URLs.BLAZERS_PAGE);
    }
}
