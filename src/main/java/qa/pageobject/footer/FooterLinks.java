package qa.pageobject.footer;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import qa.base.BasePage;


public class FooterLinks extends BasePage {

    public FooterLinks(Page page) {

        super(page);
    }
    public void clickElementList(String linkText) {

        getPage().getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(linkText).setExact(true)).click();
    }
}
