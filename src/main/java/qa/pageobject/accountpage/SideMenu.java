package qa.pageobject.accountpage;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import io.qameta.allure.Step;
import qa.base.BasePage;

public class SideMenu extends BasePage {

    public SideMenu(Page page) {

        super(page);
    }

    private void clickLink(String linkText) {

        getPage().getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(linkText)).click();
    }

    @Step("Click the \"Account Dashboard\" link")
    public void clickAccountDashboardLink() {

        clickLink("Account Dashboard");
    }

    @Step("Click the \"Account Information\" link")
    public void clickAccountInformationLink() {

        clickLink("Account Information");
    }

    @Step("Click the \"Address Book\" link")
    public void clickAddressBookLink() {

        clickLink("Address Book");
    }

    @Step("Click the \"My Orders\" link")
    public void clickMyOrdersLink() {

        clickLink("My Orders");
    }

    @Step("Click the \"Billing Agreements\" link")
    public void clickBillingAgreementsLink() {

        clickLink("Billing Agreements");
    }

    @Step("Click the \"Recurring Profiles\" link")
    public void clickRecurringProfilesLink() {

        clickLink("Recurring Profiles");
    }

    @Step("Click the \"My Product Reviews\" link")
    public void clickMyProductReviewsLink() {

        clickLink("My Product Reviews");
    }

    @Step("Click the \"My Wishlist\" link")
    public void clickMyWishlistLink() {

        clickLink("My Wishlist");
    }

    @Step("Click the \"My Applications")
    public void clickMyApplicationsLink() {

        clickLink("My Applications");
    }

    @Step("Click the \"Newsletter Subscriptions")
    public void clickNewsletterSubscriptionsLink() {

        clickLink("Newsletter Subscriptions");
    }

    @Step("Click the \"My Downloadable Products")
    public void clickMyDownloadableProductsLink() {

        clickLink("My Downloadable Products");
    }
}
