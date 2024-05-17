package qa.pageobject.sections;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import io.qameta.allure.Step;
import qa.base.BasePage;

public class Header extends BasePage {

    private final Locator shoppingCartLink;

    public Header(Page page) {

        super(page);

        shoppingCartLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Cart"));
    }

    @Step("Click the \"Cart\" link")
    public void clickShoppingCartLink() {

        shoppingCartLink.click();
    }
}
