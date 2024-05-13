package tests.account;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.pageobject.accountpage.SideMenu;
import tests.base.BaseTest;
import qa.support.URLs;
import qa.support.Authentication;


import java.io.IOException;
import java.net.URISyntaxException;

public class SideMenuTest extends BaseTest {

    private SideMenu sideMenu;

    @BeforeMethod
    public void prepare() throws IOException, URISyntaxException {

        goToPage(URLs.LOGIN_PAGE);
        Authentication.login(getPage());
        sideMenu = new SideMenu(getPage());
    }

    @Test
    public void accountDashboardLink() {

        clickAndVerifyPageUrl(SideMenu::clickAccountDashboardLink, sideMenu, URLs.ACCOUNT_DASHBOARD_PAGE);
    }

    @Test
    public void accountInformationLink() {

        clickAndVerifyPageUrl(SideMenu::clickAccountInformationLink, sideMenu, URLs.ACCOUNT_INFORMATION_PAGE);
    }

    @Test
    public void addressBookLink() {

        clickAndVerifyPageUrl(SideMenu::clickAddressBookLink, sideMenu, URLs.ADDRESS_BOOK_PAGE);
    }

    @Test
    public void myOrdersLink() {

        clickAndVerifyPageUrl(SideMenu::clickMyOrdersLink, sideMenu, URLs.MY_ORDERS_PAGE);
    }

    @Test
    public void billingAgreementsLink() {

        clickAndVerifyPageUrl(SideMenu::clickBillingAgreementsLink, sideMenu, URLs.BILLING_AGREEMENTS_PAGE);
    }

    @Test
    public void recurringProfilesLink() {

        clickAndVerifyPageUrl(SideMenu::clickRecurringProfilesLink, sideMenu, URLs.RECURRING_PROFILE_PAGE);
    }

    @Test
    public void myProductReviews() {

        clickAndVerifyPageUrl(SideMenu::clickMyProductReviewsLink, sideMenu, URLs.MY_PRODUCT_REVIEWS_PAGE);
    }

    @Test
    public void myWishlistLink() {

        clickAndVerifyPageUrl(SideMenu::clickMyWishlistLink, sideMenu, URLs.MY_WISHLIST_PAGE);
    }

    @Test
    public void myApplicationsLink() {

        clickAndVerifyPageUrl(SideMenu::clickMyApplicationsLink, sideMenu, URLs.MY_APPLICATIONS_PAGE);
    }

    @Test
    public void newsletterSubscriptionsLink() {

        clickAndVerifyPageUrl(SideMenu::clickNewsletterSubscriptionsLink, sideMenu, URLs.ACCOUNT_NEWSLETTER_SUBSCRIPTION_PAGE);
    }

    @Test
    public void myDownloadableProducts() {

        clickAndVerifyPageUrl(SideMenu::clickMyDownloadableProductsLink, sideMenu, URLs.MY_DOWNLOADABLE_PAGE);
    }
}
