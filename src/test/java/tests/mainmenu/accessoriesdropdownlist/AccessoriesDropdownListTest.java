package tests.mainmenu.accessoriesdropdownlist;

import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.pageobject.mainmenu.AccessoriesDropdownList;
import qa.support.URLs;
import tests.base.BaseTest;

@Epic("E2E")
@Feature("The \"Accessories\" dropdown list links")
public class AccessoriesDropdownListTest extends BaseTest {

    private AccessoriesDropdownList accessoriesDropdownList;

    @BeforeMethod
    public void prepare() {

        accessoriesDropdownList = new AccessoriesDropdownList(getPage());
        accessoriesDropdownList.hoverTriggerElement();
    }

    @Test(priority = 1)
    @Owner("Paweł Aksman")
    @Tag("Main menu")
    @Tag("Dropdown list")
    @Tag("Links")
    @Link(name = "Account page", url = "http://demo-store.seleniumacademy.com/customer/account/index/")
    @Description("The \"Account Dashboard\" link")
    public void viewAllAccessoriesLink() {

        clickAndVerifyPageUrl(AccessoriesDropdownList::clickViewAllAccessoriesLink, accessoriesDropdownList, URLs.ACCESSORIES_PAGE);
    }

    @Test(priority = 2)
    @Owner("Paweł Aksman")
    @Tag("Main menu")
    @Tag("Dropdown list")
    @Tag("Links")
    @Link(name = "Account page", url = "http://demo-store.seleniumacademy.com/customer/account/index/")
    @Description("The \"Eyewear\" link")
    public void eyewearLink() {

        clickAndVerifyPageUrl(AccessoriesDropdownList::clickEyewearLink, accessoriesDropdownList, URLs.EYEWEAR_PAGE);
    }

    @Test(priority = 3)
    @Owner("Paweł Aksman")
    @Tag("Main menu")
    @Tag("Dropdown list")
    @Tag("Links")
    @Link(name = "Account page", url = "http://demo-store.seleniumacademy.com/customer/account/index/")
    @Description("The \"Jewelry\" link")
    public void jewelryLink() {

        clickAndVerifyPageUrl(AccessoriesDropdownList::clickJewelryLink, accessoriesDropdownList, URLs.JEWELRY_PAGE);
    }

    @Test(priority = 4)
    @Owner("Paweł Aksman")
    @Tag("Main menu")
    @Tag("Dropdown list")
    @Tag("Links")
    @Link(name = "Account page", url = "http://demo-store.seleniumacademy.com/customer/account/index/")
    @Description("The \"Shoes\" link")
    public void shoes() {

        clickAndVerifyPageUrl(AccessoriesDropdownList::clickShoesLink, accessoriesDropdownList, URLs.SHOES_PAGE);
    }

    @Test(priority = 5)
    @Owner("Paweł Aksman")
    @Tag("Main menu")
    @Tag("Dropdown list")
    @Tag("Links")
    @Link(name = "Account page", url = "http://demo-store.seleniumacademy.com/customer/account/index/")
    @Description("The \"Bags and Luggage\" link")
    public void bagsAndLuggage() {

        clickAndVerifyPageUrl(AccessoriesDropdownList::clickBagsAndLuggageLink, accessoriesDropdownList, URLs.BAGS_LUGGAGE_PAGE);
    }
}
