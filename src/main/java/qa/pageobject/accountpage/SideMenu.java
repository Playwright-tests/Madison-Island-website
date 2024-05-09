package qa.pageobject.accountpage;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import qa.base.BasePage;

public class SideMenu extends BasePage {

    public SideMenu(Page page) {

        super(page);
    }

    private void clickLink(String linkText) {

        getPage().getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(linkText)).click();
    }

    public void clickAccountDashboardLink() {

        clickLink("Account Dashboard");
    }

    public void clickAccountInformationLink() {

        clickLink("Account Information");
    }

    public void clickAddressBookLink() {

        clickLink("Address Book");
    }

    public void clickMyOrdersLink() {

        clickLink("My Orders");
    }

    public void clickBillingAgreementsLink() {

        clickLink("Billing Agreements");
    }

    public void clickRecurringProfilesLink() {

        clickLink("Recurring Profiles");
    }

    public void clickMyProductReviewsLink() {

        clickLink("My Product Reviews");
    }

    public void clickMyWishlistLink() {

        clickLink("My Wishlist");
    }

    public void clickMyApplicationsLink() {

        clickLink("My Applications");
    }

    public void clickNewsletterSubscriptionsLink() {

        clickLink("Newsletter Subscriptions");
    }

    public void clickMyDownloadableProductsLink() {

        clickLink("My Downloadable Products");
    }
}
