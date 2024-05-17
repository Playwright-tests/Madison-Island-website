package tests.mainmenu.womendropdownlist;

import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.pageobject.mainmenu.WomenDropdownList;
import qa.support.URLs;
import tests.base.BaseTest;

@Epic("E2E")
public class WomenDropdownListTest extends BaseTest {

    private WomenDropdownList womenDropdownList;

    @BeforeMethod
    public void prepare() {

        womenDropdownList = new WomenDropdownList(getPage());
        womenDropdownList.hoverTriggerElement();
    }

    @Test(priority = 1)
    @Owner("Paweł Aksman")
    @Tag("Main menu")
    @Tag("Dropdown list")
    @Tag("Links")
    @Link(name = "Home page", url = URLs.HOME_PAGE)
    @Severity(SeverityLevel.CRITICAL)
    @Description("The \"View All Women\" link")
    public void viewAllWomenLink() {

        clickAndVerifyPageUrl(WomenDropdownList::clickViewAllWomenLink, womenDropdownList, URLs.WOMEN_PAGE);
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

        clickAndVerifyPageUrl(WomenDropdownList::clickNewArrivalsLink, womenDropdownList, URLs.WOMEN_NEW_ARRIVALS_PAGE);
    }

    @Test(priority = 3)
    @Owner("Paweł Aksman")
    @Tag("Main menu")
    @Tag("Dropdown list")
    @Tag("Links")
    @Link(name = "Home page", url = URLs.HOME_PAGE)
    @Severity(SeverityLevel.NORMAL)
    @Description("The \"Tops & Blouses\" link")
    public void topsAndBlousesLink() {

        clickAndVerifyPageUrl(WomenDropdownList::clickTopsAndBlousesLink, womenDropdownList, URLs.TOPS_BLOUSES_PAGE);
    }

    @Test(priority = 4)
    @Owner("Paweł Aksman")
    @Tag("Main menu")
    @Tag("Dropdown list")
    @Tag("Links")
    @Link(name = "Home page", url = URLs.HOME_PAGE)
    @Severity(SeverityLevel.NORMAL)
    @Description("The \"Pants & Denim\" link")
    public void pantsAndDenimLink() {

        clickAndVerifyPageUrl(WomenDropdownList::clickPantsAndDenimLink, womenDropdownList, URLs.WOMEN_PANTS_DENIM_PAGE);
    }

    @Test(priority = 5)
    @Owner("Paweł Aksman")
    @Tag("Main menu")
    @Tag("Dropdown list")
    @Tag("Links")
    @Link(name = "Home page", url = URLs.HOME_PAGE)
    @Severity(SeverityLevel.NORMAL)
    @Description("The \"Dresses & Skirts\" link")
    public void dressesAndSkirtsLink() {

        clickAndVerifyPageUrl(WomenDropdownList::clickDressesAndSkirtsLink, womenDropdownList, URLs.DRESSES_SKIRTS_PAGE);
    }
}
