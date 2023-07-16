package tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.components.AccountDropdownList;
import qa.base.BaseTest;

public class AccountDropdownListTest extends BaseTest {

    private static AccountDropdownList accountDropdownList;

    enum Items { MY_ACCOUNT, MY_WISHLIST, MY_CART, CHECKOUT, REGISTER, LOG_IN }

    @BeforeAll
    public static void init() {

        accountDropdownList = new AccountDropdownList(getPage());
    }

    private void clickTheLink(Items items) {

        accountDropdownList.clickAccountNav();
        accountDropdownList.clickElementList(items.ordinal());
        getPage().goBack();
    }

    @Test
    void myAccountLink() {

        clickTheLink(Items.MY_ACCOUNT);
    }

    @Test
    void myWishlistLink() {

        clickTheLink(Items.MY_WISHLIST);
    }

    @Test
    void myCartLink() {

        clickTheLink(Items.MY_CART);
    }

    @Test
    void checkoutLink() {

        clickTheLink(Items.CHECKOUT);
    }

    @Test
    void registerLink() {

        clickTheLink(Items.REGISTER);
    }

    @Test
    void logInLink() {

        clickTheLink(Items.LOG_IN);
    }
}
