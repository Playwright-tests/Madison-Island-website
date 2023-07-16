package pages.components;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import qa.base.BasePage;

public class MainMenu extends BasePage {

    Locator dropdownList;
    public MainMenu(Page page) {

        super(page);
    }

    public void setDropdownList(String locator) {

        dropdownList = getPage().locator("#nav").locator(locator).locator("li");
    }

    public int getDropdownListCount() {

        return dropdownList.count();
    }

    public void clickElementList(String name, int nthChild) {

        getPage().locator("#nav").getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName(name).setExact(true)).hover();
        dropdownList.nth(nthChild).click();
    }
}
