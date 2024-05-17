package qa.pageobject.promossection;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import io.qameta.allure.Step;
import qa.base.BasePage;

public class PromosSection extends BasePage {

    public PromosSection(Page page) {

        super(page);
    }

    private void clickImage(String name) {

        getPage().getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(name)).click();
    }

    @Step("Click the \"Physical & Virtual Gift Cards\" image")
    public void clickPhysicalAndVirtualGiftCardsImage() {

        clickImage("Physical & Virtual Gift Cards");
    }

    @Step("Click the \"Shop Private Sales - Members Only\" image")
    public void clickShopPrivateSalesImage() {

        clickImage("Shop Private Sales - Members Only");
    }

    @Step("Click the \"Travel Gear for Every Occasion\" image")
    public void clickTravelGearImage() {

        clickImage("Travel Gear for Every Occasion");
    }
}
