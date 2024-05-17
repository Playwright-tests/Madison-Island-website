package tests.accountdropdownlist;

import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.pageobject.header.AccountDropdownList;
import qa.support.URLs;
import tests.base.BaseTest;

@Epic("E2E")
@Feature("The \"Account\" dropdown list links")
public class AccountDropdownListLinksTest extends BaseTest {

    private AccountDropdownList accountDropdownList;

    @BeforeMethod
    public void prepare() {

        accountDropdownList = new AccountDropdownList(getPage());
        accountDropdownList.clickTriggerElement();
    }

    @Test(priority = 1)
    @Owner("Paweł Aksman")
    @Tag("Account")
    @Tag("Dropdown list")
    @Tag("Links")
    @Tag("Menu")
    @Link(name = "Home page", url = "http://demo-store.seleniumacademy.com/")
    @Description("The \"My Account\" link")
    public void myAccountLink() {

        accountDropdownList.clickMyAccountLink();
    }

    @Test(priority = 2)
    @Owner("Paweł Aksman")
    @Tag("Account")
    @Tag("Dropdown list")
    @Tag("Links")
    @Tag("Menu")
    @Link(name = "Home page", url = "http://demo-store.seleniumacademy.com/")
    @Description("The \"My Wishlist\" link")
    public void myWishlistLink() {

        clickAndVerifyPageUrl(AccountDropdownList::clickMyWishlistLink, accountDropdownList, URLs.WISHLIST_PAGE);
    }

    @Test(priority = 3)
    @Owner("Paweł Aksman")
    @Tag("Account")
    @Tag("Dropdown list")
    @Tag("Links")
    @Tag("Menu")
    @Link(name = "Home page", url = "http://demo-store.seleniumacademy.com/")
    @Description("The \"My Cart\" link")
    public void myCartLink() {

        clickAndVerifyPageUrl(AccountDropdownList::clickMyCartLink, accountDropdownList, URLs.SHOPPING_CART_PAGE);
    }

    @Test(priority = 4)
    @Owner("Paweł Aksman")
    @Tag("Account")
    @Tag("Dropdown list")
    @Tag("Links")
    @Tag("Menu")
    @Link(name = "Home page", url = "http://demo-store.seleniumacademy.com/")
    @Description("The \"Checkout\" link")
    public void checkoutLink() {

        accountDropdownList.clickCheckoutLink();
    }

    @Test(priority = 5)
    @Owner("Paweł Aksman")
    @Tag("Account")
    @Tag("Dropdown list")
    @Tag("Links")
    @Tag("Menu")
    @Link(name = "Home page", url = "http://demo-store.seleniumacademy.com/")
    @Description("The \"Register\" link")
    public void registerLink() {

        clickAndVerifyPageUrl(AccountDropdownList::clickRegisterLink, accountDropdownList, URLs.REGISTER_PAGE);
    }

    @Test(priority = 6)
    @Owner("Paweł Aksman")
    @Tag("Account")
    @Tag("Dropdown list")
    @Tag("Links")
    @Tag("Menu")
    @Link(name = "Home page", url = "http://demo-store.seleniumacademy.com/")
    @Description("The \"Log in\" link")
    public void loginLink() {

        clickAndVerifyPageUrl(AccountDropdownList::clickLoginLink, accountDropdownList, URLs.LOGIN_PAGE);
    }
}
