package qa.mainmenu;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import qa.base.BasePage;

public class MainMenu extends BasePage {


    public MainMenu(Page page) {

        super(page);
    }

    public void clickWomenLink() {

        getPage().getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Women").setExact(true)).click();
    }

    public void clickMenLink() {

        getPage().getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Men").setExact(true)).click();
    }

    public void clickAccessoriesLink() {

        getPage().getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Accessories").setExact(true)).click();
    }

    public void clickHomeAndDecorLink() {

        getPage().getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Home & Decor").setExact(true)).click();
    }

    public void clickSaleLink() {

        getPage().getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Sale").setExact(true)).click();
    }

    public void clickVipLink() {

        getPage().getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("VIP").setExact(true)).click();
    }
}
