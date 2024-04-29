package tests.header.mainmenu;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.pageobject.header.MainMenu;


public class WomenDropdownList extends BaseTest {

    private MainMenu mainMenu;

    @BeforeMethod(onlyForGroups = "withoutExpandedList")
    public void prepareWithoutExpandedList() {

        mainMenu = new MainMenu(getPage());
    }

    @BeforeMethod(onlyForGroups = "withExpandedList")
    public void prepareWithExpandedList() {

        mainMenu = new MainMenu(getPage());
        mainMenu.hoverParent("Women");
    }

    private void actions(String link, String expectedUrl) {

        mainMenu.clickItem(link);
        Assert.assertEquals(getPage().url(), expectedUrl, "Incorrect url");
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
