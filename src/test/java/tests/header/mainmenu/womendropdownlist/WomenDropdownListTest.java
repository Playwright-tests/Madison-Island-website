package tests.header.mainmenu.womendropdownlist;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.mainmenu.WomenDropdownList;
import qa.support.URLs;
import tests.base.BaseTest;

public class WomenDropdownListTest extends BaseTest {

    private WomenDropdownList womenDropdownList;

    @BeforeMethod
    public void prepare() {

        womenDropdownList = new WomenDropdownList(getPage());
        womenDropdownList.hoverTriggerElement();
    }

    @Test
    public void viewAllWomenLink() {

        clickAndVerifyPageUrl(WomenDropdownList::clickViewAllWomenLink, womenDropdownList, URLs.WOMEN_PAGE);
    }

    @Test
    public void newArrivalsLink() {

        clickAndVerifyPageUrl(WomenDropdownList::clickNewArrivalsLink, womenDropdownList, URLs.WOMEN_NEW_ARRIVALS_PAGE);
    }

    @Test
    public void topsAndBlousesLink() {

        clickAndVerifyPageUrl(WomenDropdownList::clickTopsAndBlousesLink, womenDropdownList, URLs.TOPS_BLOUSES_PAGE);
    }

    @Test
    public void pantsAndDenimLink() {

        clickAndVerifyPageUrl(WomenDropdownList::clickPantsAndDenimLink, womenDropdownList, URLs.WOMEN_PANTS_DENIM_PAGE);
    }

    @Test
    public void dressesAndSkirtsLink() {

        clickAndVerifyPageUrl(WomenDropdownList::clickDressesAndSkirtsLink, womenDropdownList, URLs.DRESSES_SKIRTS_PAGE);
    }
}
