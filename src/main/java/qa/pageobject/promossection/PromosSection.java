package qa.pageobject.promossection;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import qa.base.BasePage;

public class PromosSection extends BasePage {

    public PromosSection(Page page) {

        super(page);
    }

    private void clickImage(String name) {

        getPage().getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(name)).click();
    }

    public void clickPhysicalAndVirtualGiftCardsImage() {

        clickImage("Physical & Virtual Gift Cards");
    }

    public void clickShopPrivateSalesImage() {

        clickImage("Shop Private Sales - Members Only");
    }

    public void clickTravelGearImage() {

        clickImage("Travel Gear for Every Occasion");
    }
}
