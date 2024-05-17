package tests.footerlinks;

import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.pageobject.footer.AccountLinks;
import qa.support.URLs;
import tests.base.BaseTest;

@Epic("E2E")
public class AccountLinksTest extends BaseTest {

    private AccountLinks accountLinks;

    @BeforeMethod
    public void prepare() {

        accountLinks = new AccountLinks(getPage());
    }

    @Test(priority = 1)
    @Owner("Paweł Aksman")
    @Tag("Links")
    @Tag("Footer")
    @Link(name = "Home page", url = "http://demo-store.seleniumacademy.com/")
    @Feature("The \"My Account\" link")
    public void myAccountLink() {

        clickAndVerifyPageUrl(AccountLinks::clickMyAccountLink, accountLinks, URLs.LOGIN_PAGE);
    }

    @Test(priority = 2)
    @Owner("Paweł Aksman")
    @Tag("Links")
    @Tag("Footer")
    @Link(name = "Home page", url = "http://demo-store.seleniumacademy.com/")
    @Feature("The \"Order and Returns\" link")
    public void ordersAndReturnsLink() {

        clickAndVerifyPageUrl(AccountLinks::clickOrdersAndReturnsLink, accountLinks, URLs.ORDERS_AND_RETURNS_PAGE);
    }
}
