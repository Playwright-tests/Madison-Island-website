package qa.pageobject.mainmenu;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import io.qameta.allure.Step;
import qa.base.BasePage;

public class MainMenu extends BasePage {


    public MainMenu(Page page) {

        super(page);
    }

    @Step("Click the \"Women\" link")
    public void clickWomenLink() {

        getPage().getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Women").setExact(true)).click();
    }

    @Step("Click the \"Men\" link")
    public void clickMenLink() {

        getPage().getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Men").setExact(true)).click();
    }

    @Step("Click the \"Accessories\" link")
    public void clickAccessoriesLink() {

        getPage().getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Accessories").setExact(true)).click();
    }

    @Step("Click the \"Home & Decor\" link")
    public void clickHomeAndDecorLink() {

        getPage().getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Home & Decor").setExact(true)).click();
    }

    @Step("Click the \"Sale\" link")
    public void clickSaleLink() {

        getPage().getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Sale").setExact(true)).click();
    }

    @Step("Click the \"VIP\" link")
    public void clickVipLink() {

        getPage().getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("VIP").setExact(true)).click();
    }
}
