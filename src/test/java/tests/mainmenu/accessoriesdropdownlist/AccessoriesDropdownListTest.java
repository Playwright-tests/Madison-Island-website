package tests.mainmenu.accessoriesdropdownlist;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.pageobject.mainmenu.AccessoriesDropdownList;
import qa.support.URLs;
import tests.base.BaseTest;

public class AccessoriesDropdownListTest extends BaseTest {

    private AccessoriesDropdownList accessoriesDropdownList;

    @BeforeMethod
    public void prepare() {

        accessoriesDropdownList = new AccessoriesDropdownList(getPage());
        accessoriesDropdownList.hoverTriggerElement();
    }

    @Test
    public void viewAllAccessoriesLink() {

        clickAndVerifyPageUrl(AccessoriesDropdownList::clickViewAllAccessoriesLink, accessoriesDropdownList, URLs.ACCESSORIES_PAGE);
    }

    @Test
    public void eyewearLink() {

        clickAndVerifyPageUrl(AccessoriesDropdownList::clickEyewearLink, accessoriesDropdownList, URLs.EYEWEAR_PAGE);
    }

    @Test
    public void jewelryLink() {

        clickAndVerifyPageUrl(AccessoriesDropdownList::clickJewelryLink, accessoriesDropdownList, URLs.JEWELRY_PAGE);
    }

    @Test
    public void shoes() {

        clickAndVerifyPageUrl(AccessoriesDropdownList::clickShoesLink, accessoriesDropdownList, URLs.SHOES_PAGE);
    }

    @Test
    public void bagsAndLuggage() {

        clickAndVerifyPageUrl(AccessoriesDropdownList::clickBagsAndLuggageLink, accessoriesDropdownList, URLs.BAGS_LUGGAGE_PAGE);
    }
}
