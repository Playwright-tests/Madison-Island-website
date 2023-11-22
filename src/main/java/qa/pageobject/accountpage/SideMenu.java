package qa.pageobject.accountpage;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import qa.base.BasePage;

public class SideMenu extends BasePage {

    public SideMenu(Page page) {

        super(page);
    }

    public void clickLink(String linkText) {

        getPage().getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(linkText)).click();
    }
}
