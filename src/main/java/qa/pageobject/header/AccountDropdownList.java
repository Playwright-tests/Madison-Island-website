package qa.pageobject.header;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import lombok.Getter;
import qa.base.BasePage;

@Getter
public class AccountDropdownList extends BasePage {

    private final String listSelector;

    public AccountDropdownList(Page page) {

        super(page);

        listSelector = "#header-account";
    }

    public void clickItem(String name) {

        getPage().locator("#header-account")
                .getByRole(AriaRole.LINK, new Locator
                        .GetByRoleOptions().setName(name).setExact(true)).click();
    }

    public void clickTriggerElement() {

        getPage().getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Account").setExact(true)).click();
    }

    public void clickMyAccountLink() {

        clickItem("My Account");
    }

    public void clickMyWishlistLink() {

        clickItem("My Wishlist");
    }

    public void clickMyCartLink() {

        clickItem("My Cart");
    }

    public void clickCheckoutLink() {

        clickItem("Checkout");
    }

    public void clickRegisterLink() {

        clickItem("Register");
    }

    public void clickLoginLink() {

        clickItem("Log In");
    }
}
