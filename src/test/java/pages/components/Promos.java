package pages.components;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import qa.base.BasePage;

public class Promos extends BasePage {

    private final Locator homeAndDecor;
    private final Locator shopPrivateSales;
    private final Locator travelGear;

    public Promos(Page page) {

        super(page);

        homeAndDecor = getPage().getByAltText("Physical & Virtual Gift Cards");
        shopPrivateSales = getPage().getByAltText("Shop Private Sales - Members Only");
        travelGear = getPage().getByAltText("Travel Gear for Every Occasion");
    }

    public void clickHomeAndDecorImage() {

        homeAndDecor.click();
    }

    public void clickShopPrivateSalesImage() {

        shopPrivateSales.click();
    }

    public void clickTravelGearImage() {

        travelGear.click();
    }
}
