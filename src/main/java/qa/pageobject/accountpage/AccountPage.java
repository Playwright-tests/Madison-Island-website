package qa.pageobject.accountpage;

import com.microsoft.playwright.Page;
import qa.base.BasePage;

public class AccountPage extends BasePage {

    private SideMenu sideMenu;

    public AccountPage(Page page) {

        super(page);

        sideMenu = new SideMenu(page);
    }

    public SideMenu getSideMenu() {

        return sideMenu;
    }
}
