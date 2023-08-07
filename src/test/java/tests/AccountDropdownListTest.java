package tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import pages.components.AccountDropdownList;
import qa.base.BaseTest;

public class AccountDropdownListTest extends BaseTest {

    private AccountDropdownList accountDropdownList;

    @BeforeClass
    public void init() {

        accountDropdownList = new AccountDropdownList(getPage());
    }

    private void clickTheLink(String items) {

        accountDropdownList.clickAccountNav();
        accountDropdownList.clickItem(items);
        getPage().goBack();
    }

    @Test
    void myAccountLink() {

        clickTheLink("My Account");
    }

    @Test
    void myWishlistLink() {

        clickTheLink("My Wishlist");
    }

    @Test
    void myCartLink() {

        clickTheLink("My Cart");
    }

    @Test
    void checkoutLink() {

        clickTheLink("Checkout");
    }

    @Test
    void registerLink() {

        clickTheLink("Register");
    }

    @Test
    void logInLink() {

        clickTheLink("Log In");
    }
}
