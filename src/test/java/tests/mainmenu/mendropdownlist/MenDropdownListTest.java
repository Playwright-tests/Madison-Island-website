package tests.mainmenu.mendropdownlist;

import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.pageobject.mainmenu.MenDropdownList;
import qa.support.URLs;
import tests.base.BaseTest;

@Epic("E2E")
public class MenDropdownListTest extends BaseTest {

    private MenDropdownList menDropdownList;

    @BeforeMethod
    public void prepare() {

        menDropdownList = new MenDropdownList(getPage());
        menDropdownList.hoverTriggerElement();
    }

    @Test(priority = 1)
    @Owner("Paweł Aksman")
    @Tag("Main menu")
    @Tag("Dropdown list")
    @Tag("Links")
    @Link(name = "Home page", url = URLs.HOME_PAGE)
    @Severity(SeverityLevel.CRITICAL)
    @Description("The \"View All Men\" link")
    public void viewAllMenLink() {

        clickAndVerifyPageUrl(MenDropdownList::clickViewAllMenLink, menDropdownList, URLs.MEN_PAGE);
    }

    @Test(priority = 2)
    @Owner("Paweł Aksman")
    @Tag("Main menu")
    @Tag("Dropdown list")
    @Tag("Links")
    @Link(name = "Home page", url = URLs.HOME_PAGE)
    @Severity(SeverityLevel.NORMAL)
    @Description("The \"New Arrivals\" link")
    public void newArrivalsLink() {

        clickAndVerifyPageUrl(MenDropdownList::clickNewArrivalsLink, menDropdownList, URLs.MEN_NEW_ARRIVALS_PAGE);
    }

    @Test(priority = 3)
    @Owner("Paweł Aksman")
    @Tag("Main menu")
    @Tag("Dropdown list")
    @Tag("Links")
    @Link(name = "Home page", url = URLs.HOME_PAGE)
    @Severity(SeverityLevel.NORMAL)
    @Description("The \"Shirts\" link")
    public void shirtsLink() {

        clickAndVerifyPageUrl(MenDropdownList::clickShirtsLink, menDropdownList, URLs.SHIRTS_PAGE);
    }

    @Test(priority = 4)
    @Owner("Paweł Aksman")
    @Tag("Main menu")
    @Tag("Dropdown list")
    @Tag("Links")
    @Link(name = "Home page", url = URLs.HOME_PAGE)
    @Severity(SeverityLevel.NORMAL)
    @Description("The \"Tees, Knits And Polos\" link")
    public void teesKnitsLink() {

        clickAndVerifyPageUrl(MenDropdownList::clickTeesKnitsAndPolosLink, menDropdownList, URLs.TEES_PAGE);
    }

    @Test(priority = 5)
    @Owner("Paweł Aksman")
    @Tag("Main menu")
    @Tag("Dropdown list")
    @Tag("Links")
    @Link(name = "Home page", url = URLs.HOME_PAGE)
    @Severity(SeverityLevel.NORMAL)
    @Description("The \"Pants & Denim\" link")
    public void pantsAndDenim() {

        clickAndVerifyPageUrl(MenDropdownList::clickPantsAndDenimLink, menDropdownList, URLs.MEN_PANTS_DENIM_PAGE);
    }

    @Test(priority = 6)
    @Owner("Paweł Aksman")
    @Tag("Main menu")
    @Tag("Dropdown list")
    @Tag("Links")
    @Link(name = "Home page", url = URLs.HOME_PAGE)
    @Severity(SeverityLevel.NORMAL)
    @Description("The \"Blazers\" link")
    public void blazersLink() {

        clickAndVerifyPageUrl(MenDropdownList::clickBlazersLink, menDropdownList, URLs.BLAZERS_PAGE);
    }
}
