package pageobject.components;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import qa.base.BasePage;

public class AccountDropdownList extends BasePage {

    private final Locator nav;

    public AccountDropdownList(Page page) {

        super(page);

        nav = getPage().getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Account").setExact(true));
    }

    public void clickAccountNav() {

        nav.click();
    }

    public void clickItem(String nth) {

        getPage().locator("#header-account")
                 .getByRole(AriaRole.LINK, new Locator
                 .GetByRoleOptions().setName(nth).setExact(true)).click();
    }
}
