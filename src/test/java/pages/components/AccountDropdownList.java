package pages.components;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import qa.base.BasePage;

public class AccountDropdownList extends BasePage {

    private Locator nav;
    private Locator dropdownList;

    public AccountDropdownList(Page page) {

        super(page);

        nav = getPage().getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Account").setExact(true));
        dropdownList = getPage().locator("#header-account").locator("div>ul").locator("li");
    }

    public int getDropdownListCount() {

        return dropdownList.count();
    }

    public void clickAccountNav() {

        nav.click();
    }

    public void clickElementList(int nth) {

        dropdownList.nth(nth).click();
    }
}
