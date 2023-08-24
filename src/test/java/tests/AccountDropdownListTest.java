package tests;

import enums.AccountDropdownListURLs;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import pages.components.AccountDropdownList;
import qa.base.BaseTest;
import utils.JSONReader;

public class AccountDropdownListTest extends BaseTest {

    private AccountDropdownList accountDropdownList;
    private String[] expectedResults;

    @BeforeClass
    public void init() {

        accountDropdownList = new AccountDropdownList(getPage());
        expectedResults = JSONReader.get("URLs", "accountDropdownList");
    }

    private void check(String items, AccountDropdownListURLs index) {

        accountDropdownList.clickAccountNav();
        accountDropdownList.clickItem(items);

        String currentURL = getPage().url();

        getPage().goBack();

        Assert.assertEquals(currentURL, expectedResults[index.ordinal()]);
    }

    @Test
    void myAccountLink() {

        check("My Account", AccountDropdownListURLs.MY_ACCOUNT);
    }

    @Test
    void myWishlistLink() {

        check("My Wishlist", AccountDropdownListURLs.MY_WISHLIST);
    }

    @Test
    void myCartLink() {

        check("My Cart", AccountDropdownListURLs.MY_CART);
    }

    @Test
    void checkoutLink() {

        check("Checkout", AccountDropdownListURLs.CHECKOUT);
    }

    @Test
    void registerLink() {

        check("Register", AccountDropdownListURLs.REGISTER);
    }

    @Test
    void logInLink() {

        check("Log In", AccountDropdownListURLs.LOG_IN);
    }
}
