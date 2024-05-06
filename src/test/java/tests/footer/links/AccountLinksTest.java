package tests.footer.links;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.pageobject.footer.AccountLinks;
import qa.support.URLs;
import tests.base.BaseTest;

public class AccountLinksTest extends BaseTest {

    private AccountLinks accountLinks;

    @BeforeMethod
    public void prepare() {

        accountLinks = new AccountLinks(getPage());
    }

    @Test
    public void myAccountLink() {

        clickAndVerifyPageUrl(AccountLinks::clickMyAccountLink, accountLinks, URLs.LOGIN_PAGE);
    }

    @Test
    public void ordersAndReturnsLink() {

        clickAndVerifyPageUrl(AccountLinks::clickOrdersAndReturnsLink, accountLinks, URLs.ORDERS_AND_RETURNS_PAGE);
    }
}
