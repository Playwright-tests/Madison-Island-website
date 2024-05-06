package tests.mainmenu.mendropdownlist;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.mainmenu.MenDropdownList;
import qa.support.URLs;
import tests.base.BaseTest;

public class MenDropdownListTest extends BaseTest {

    private MenDropdownList menDropdownList;

    @BeforeMethod
    public void prepare() {

        menDropdownList = new MenDropdownList(getPage());
        menDropdownList.hoverTriggerElement();
    }

    @Test
    public void viewAllMenLink() {

        clickAndVerifyPageUrl(MenDropdownList::clickViewAllMenLink, menDropdownList, URLs.MEN_PAGE);
    }

    @Test
    public void newArrivalsLink() {

        clickAndVerifyPageUrl(MenDropdownList::clickNewArrivalsLink, menDropdownList, URLs.MEN_NEW_ARRIVALS_PAGE);
    }

    @Test
    public void shirtsLink() {

        clickAndVerifyPageUrl(MenDropdownList::clickShirtsLink, menDropdownList, URLs.SHIRTS_PAGE);
    }

    @Test
    public void teesKnitsLink() {

        clickAndVerifyPageUrl(MenDropdownList::clickTeesKnitsAndPolosLink, menDropdownList, URLs.TEES_PAGE);
    }

    @Test
    public void pantsAndDenim() {

        clickAndVerifyPageUrl(MenDropdownList::clickPantsAndDenimLink, menDropdownList, URLs.MEN_PANTS_DENIM_PAGE);
    }

    @Test
    public void blazersLink() {

        clickAndVerifyPageUrl(MenDropdownList::clickBlazersLink, menDropdownList, URLs.BLAZERS_PAGE);
    }
}
