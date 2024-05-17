package qa.pageobject.mainmenu;

import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

public class WomenDropdownList extends MainMenuDropdownList {

    public WomenDropdownList(Page page) {

        super(page, "Women", "View All WomenNew ArrivalsTops & BlousesPants & DenimDresses & Skirts");
    }

    @Step("Click the \"View All Women\" link")
    public void clickViewAllWomenLink() {

        clickItem("View All Women");
    }

    @Step("Click the \"New Arrivals\" link")
    public void clickNewArrivalsLink() {

        clickItem("New Arrivals");
    }

    @Step("Click the \"Tops & Blouses\" link")
    public void clickTopsAndBlousesLink() {

        clickItem("Tops & Blouses");
    }

    @Step("Click the \"Pants & Denim\" link")
    public void clickPantsAndDenimLink() {

        clickItem("Pants & Denim");
    }

    @Step("Click the \"Dresses & Skirts\" link")
    public void clickDressesAndSkirtsLink() {

        clickItem("Dresses & Skirts");
    }
}
