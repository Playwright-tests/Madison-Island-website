package qa.pageobject.sections;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import qa.base.BasePage;

public class Header extends BasePage {

    private final Locator shoppingCartLink;

    public Header(Page page) {

        super(page);

        shoppingCartLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Cart"));
    }

    public void clickShoppingCartLink() {

        shoppingCartLink.click();
    }
}
