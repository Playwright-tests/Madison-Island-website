package tests.mainmenu.saledropdownlist;

import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.pageobject.mainmenu.SaleDropdownList;
import qa.support.URLs;
import tests.base.BaseTest;

@Epic("E2E")
public class SaleDropdownListTest extends BaseTest {

    private SaleDropdownList saleDropdownList;

    @BeforeMethod
    public void prepare() {

        saleDropdownList = new SaleDropdownList(getPage());
        saleDropdownList.hoverTriggerElement();
    }

    @Test(priority = 1)
    @Owner("Paweł Aksman")
    @Tag("Main menu")
    @Tag("Dropdown list")
    @Tag("Links")
    @Link(name = "Home page", url = URLs.HOME_PAGE)
    @Severity(SeverityLevel.CRITICAL)
    @Description("The \"View All Sale\" link")
    public void viewAllSaleLink() {

        clickAndVerifyPageUrl(SaleDropdownList::clickViewAllSaleLink, saleDropdownList, URLs.SALE_PAGE);
    }

    @Test(priority = 2)
    @Owner("Paweł Aksman")
    @Tag("Main menu")
    @Tag("Dropdown list")
    @Tag("Links")
    @Link(name = "Home page", url = URLs.HOME_PAGE)
    @Severity(SeverityLevel.NORMAL)
    @Description("The \"Women\" link")
    public void womenLink() {

        clickAndVerifyPageUrl(SaleDropdownList::clickWomenLink, saleDropdownList, URLs.SALE_WOMEN_PAGE);
    }

    @Test(priority = 3)
    @Owner("Paweł Aksman")
    @Tag("Main menu")
    @Tag("Dropdown list")
    @Tag("Links")
    @Link(name = "Home page", url = URLs.HOME_PAGE)
    @Severity(SeverityLevel.NORMAL)
    @Description("The \"Men\" link")
    public void menLink() {

        clickAndVerifyPageUrl(SaleDropdownList::clickMenLink, saleDropdownList, URLs.SALE_MEN_PAGE);
    }

    @Test(priority = 4)
    @Owner("Paweł Aksman")
    @Tag("Main menu")
    @Tag("Dropdown list")
    @Tag("Links")
    @Link(name = "Home page", url = URLs.HOME_PAGE)
    @Severity(SeverityLevel.NORMAL)
    @Description("The \"Accessories\" link")
    public void accessories() {

        clickAndVerifyPageUrl(SaleDropdownList::clickAccessoriesLink, saleDropdownList, URLs.SALE_ACCESSORIES_PAGE);
    }

    @Test(priority = 5)
    @Owner("Paweł Aksman")
    @Tag("Main menu")
    @Tag("Dropdown list")
    @Tag("Links")
    @Link(name = "Home page", url = URLs.HOME_PAGE)
    @Severity(SeverityLevel.NORMAL)
    @Description("The \"Home & Decor\" link")
    public void homeAndDecorLink() {

        clickAndVerifyPageUrl(SaleDropdownList::clickHomeAndDecorLink, saleDropdownList, URLs.SALE_HOME_DECOR_PAGE);
    }
}
