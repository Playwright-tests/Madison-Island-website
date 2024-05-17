package qa.pageobject.header;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import io.qameta.allure.Step;
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

    @Step("Click the trigger element")
    public void clickTriggerElement() {

        getPage().getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Account").setExact(true)).click();
    }

    @Step("Click the \"My Account\" link")
    public void clickMyAccountLink() {

        clickItem("My Account");
    }

    @Step("Click the \"My Wishlist\" link")
    public void clickMyWishlistLink() {

        clickItem("My Wishlist");
    }

    @Step("Click the \"My Cart\" link")
    public void clickMyCartLink() {

        clickItem("My Cart");
    }

    @Step("Click the \"Checkout\" link")
    public void clickCheckoutLink() {

        clickItem("Checkout");
    }

    @Step("Click the \"Register\" link")
    public void clickRegisterLink() {

        clickItem("Register");
    }

    @Step("Click the \"Log In\" link")
    public void clickLoginLink() {

        clickItem("Log In");
    }
}
