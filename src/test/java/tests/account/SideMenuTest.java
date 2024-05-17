package tests.account;

import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.pageobject.accountpage.SideMenu;
import tests.base.BaseTest;
import qa.support.URLs;
import qa.support.Authentication;


import java.io.IOException;
import java.net.URISyntaxException;

@Epic("E2E")
@Feature("The account side menu links")
public class SideMenuTest extends BaseTest {

    private SideMenu sideMenu;

    @BeforeMethod
    public void prepare() throws IOException, URISyntaxException {

        goToPage(URLs.LOGIN_PAGE);
        Authentication.login(getPage());
        sideMenu = new SideMenu(getPage());
    }

    @Test(priority = 1)
    @Owner("Paweł Aksman")
    @Tag("Account")
    @Tag("Links")
    @Tag("Menu")
    @Link(name = "Account page", url = "http://demo-store.seleniumacademy.com/customer/account/index/")
    @Description("The \"Account Dashboard\" link")
    public void accountDashboardLink() {

        clickAndVerifyPageUrl(SideMenu::clickAccountDashboardLink, sideMenu, URLs.ACCOUNT_DASHBOARD_PAGE);
    }

    @Test(priority = 2)
    @Owner("Paweł Aksman")
    @Tag("Account")
    @Tag("Links")
    @Tag("Menu")
    @Link(name = "Account page", url = "http://demo-store.seleniumacademy.com/customer/account/index/")
    @Description("The \"Account Information\" link")
    public void accountInformationLink() {

        clickAndVerifyPageUrl(SideMenu::clickAccountInformationLink, sideMenu, URLs.ACCOUNT_INFORMATION_PAGE);
    }

    @Test(priority = 3)
    @Owner("Paweł Aksman")
    @Tag("Account")
    @Tag("Links")
    @Tag("Menu")
    @Link(name = "Account page", url = "http://demo-store.seleniumacademy.com/customer/account/index/")
    @Description("The \"Address Book\" link")
    public void addressBookLink() {

        clickAndVerifyPageUrl(SideMenu::clickAddressBookLink, sideMenu, URLs.ADDRESS_BOOK_PAGE);
    }

    @Test(priority = 4)
    @Owner("Paweł Aksman")
    @Tag("Account")
    @Tag("Links")
    @Tag("Menu")
    @Link(name = "Account page", url = "http://demo-store.seleniumacademy.com/customer/account/index/")
    @Description("The \"My Orders\" link")
    public void myOrdersLink() {

        clickAndVerifyPageUrl(SideMenu::clickMyOrdersLink, sideMenu, URLs.MY_ORDERS_PAGE);
    }

    @Test(priority = 5)
    @Owner("Paweł Aksman")
    @Tag("Account")
    @Tag("Links")
    @Tag("Menu")
    @Link(name = "Account page", url = "http://demo-store.seleniumacademy.com/customer/account/index/")
    @Description("The \"Billing Agreements\" link")
    public void billingAgreementsLink() {

        clickAndVerifyPageUrl(SideMenu::clickBillingAgreementsLink, sideMenu, URLs.BILLING_AGREEMENTS_PAGE);
    }

    @Test(priority = 6)
    @Owner("Paweł Aksman")
    @Tag("Account")
    @Tag("Links")
    @Tag("Menu")
    @Link(name = "Account page", url = "http://demo-store.seleniumacademy.com/customer/account/index/")
    @Description("The \"Recurring Profiles\" link")
    public void recurringProfilesLink() {

        clickAndVerifyPageUrl(SideMenu::clickRecurringProfilesLink, sideMenu, URLs.RECURRING_PROFILE_PAGE);
    }

    @Test(priority = 7)
    @Owner("Paweł Aksman")
    @Tag("Account")
    @Tag("Links")
    @Tag("Menu")
    @Link(name = "Account page", url = "http://demo-store.seleniumacademy.com/customer/account/index/")
    @Description("The \"My Product Reviews\" link")
    public void myProductReviews() {

        clickAndVerifyPageUrl(SideMenu::clickMyProductReviewsLink, sideMenu, URLs.MY_PRODUCT_REVIEWS_PAGE);
    }

    @Test(priority = 8)
    @Owner("Paweł Aksman")
    @Tag("Account")
    @Tag("Links")
    @Tag("Menu")
    @Link(name = "Account page", url = "http://demo-store.seleniumacademy.com/customer/account/index/")
    @Description("The \"My Wishlist\" link")
    public void myWishlistLink() {

        clickAndVerifyPageUrl(SideMenu::clickMyWishlistLink, sideMenu, URLs.MY_WISHLIST_PAGE);
    }

    @Test(priority = 9)
    @Owner("Paweł Aksman")
    @Tag("Account")
    @Tag("Links")
    @Tag("Menu")
    @Link(name = "Account page", url = "http://demo-store.seleniumacademy.com/customer/account/index/")
    @Description("The \"My Applications\" link")
    public void myApplicationsLink() {

        clickAndVerifyPageUrl(SideMenu::clickMyApplicationsLink, sideMenu, URLs.MY_APPLICATIONS_PAGE);
    }

    @Test(priority = 10)
    @Owner("Paweł Aksman")
    @Tag("Account")
    @Tag("Links")
    @Tag("Menu")
    @Link(name = "Account page", url = "http://demo-store.seleniumacademy.com/customer/account/index/")
    @Description("The \"Newsletter Subscriptions\" link")
    public void newsletterSubscriptionsLink() {

        clickAndVerifyPageUrl(SideMenu::clickNewsletterSubscriptionsLink, sideMenu, URLs.ACCOUNT_NEWSLETTER_SUBSCRIPTION_PAGE);
    }

    @Test(priority = 11)
    @Owner("Paweł Aksman")
    @Tag("Account")
    @Tag("Links")
    @Tag("Menu")
    @Link(name = "Account page", url = "http://demo-store.seleniumacademy.com/customer/account/index/")
    @Description("The \"My Downloadable Products\" link")
    public void myDownloadableProducts() {

        clickAndVerifyPageUrl(SideMenu::clickMyDownloadableProductsLink, sideMenu, URLs.MY_DOWNLOADABLE_PAGE);
    }
}
