package tests.header.accountdropdownlist;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.pageobject.header.AccountDropdownList;
import qa.support.URLs;
import tests.base.BaseTest;

public class AccountDropdownListLinksTest extends BaseTest {

    private AccountDropdownList accountDropdownList;

    @BeforeMethod
    public void prepare() {

        accountDropdownList = new AccountDropdownList(getPage());
        accountDropdownList.clickTriggerElement();
    }

    @Test
    public void myAccountLink() {

        accountDropdownList.clickMyAccountLink();
    }

    @Test
    public void myWishlistLink() {

        clickAndVerifyPageUrl(AccountDropdownList::clickMyWishlistLink, accountDropdownList, URLs.WISHLIST_PAGE);
    }

    @Test
    public void myCartLink() {

        clickAndVerifyPageUrl(AccountDropdownList::clickMyCartLink, accountDropdownList, URLs.SHOPPING_CART_PAGE);
    }

    @Test
    public void checkoutLink() {

        accountDropdownList.clickCheckoutLink();
    }

    @Test
    public void registerLink() {

        clickAndVerifyPageUrl(AccountDropdownList::clickRegisterLink, accountDropdownList, URLs.REGISTER_PAGE);
    }

    @Test
    public void loginLink() {

        clickAndVerifyPageUrl(AccountDropdownList::clickLoginLink, accountDropdownList, URLs.LOGIN_PAGE);
    }
}
