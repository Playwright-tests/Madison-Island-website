package pageobject.components;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import qa.base.BasePage;

public class ProductThumbnail extends BasePage {

    private Locator viewDetailsButton;
    private Locator addToWishlistLink;
    private Locator addToCompareLink;

    public ProductThumbnail(Page page, String title) {

        super(page);

        setLocators(title);
    }

    private void setLocators(String title) {

        Locator parent = getPage().getByRole(AriaRole.LISTITEM)
                .filter(new Locator.FilterOptions()
                .setHas(getPage().getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName(title))));

        viewDetailsButton = parent.getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("View Details"));
        addToWishlistLink = parent.getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("Add to Wishlist"));
        addToCompareLink = parent.getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("Add to Compare"));
    }

    public void clickViewDetailsButton() {

        viewDetailsButton.click();
    }

    public void clickAdToWishlistLink() {

        addToWishlistLink.click();
    }

    public void clickAddToCompareLink() {

        addToCompareLink.click();
    }
}
