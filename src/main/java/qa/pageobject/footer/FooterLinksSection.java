package qa.pageobject.footer;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import qa.base.BasePage;


public class FooterLinksSection extends BasePage {

    public FooterLinksSection(Page page) {

        super(page);
    }
    protected void clickLink(String linkText) {

        getPage().getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(linkText).setExact(true)).click();
    }
}
