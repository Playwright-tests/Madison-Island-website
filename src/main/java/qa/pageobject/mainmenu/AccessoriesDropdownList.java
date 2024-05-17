package qa.pageobject.mainmenu;

import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

public class AccessoriesDropdownList extends MainMenuDropdownList {

    public AccessoriesDropdownList(Page page) {
        super(page, "Accessories", "View All AccessoriesEyewearJewelryShoesBags & Luggage");
    }

    @Step("Click the \"View All Accessories\" link")
    public void clickViewAllAccessoriesLink() {

        clickItem("View All Accessories");
    }

    @Step("Click the \"Eyewear\" link")
    public void clickEyewearLink() {

        clickItem("Eyewear");
    }

    @Step("Click the \"Jewelry\" link")
    public void clickJewelryLink() {

        clickItem("Jewelry");
    }

    @Step("Click the \"Shoes\" link")
    public void clickShoesLink() {

        clickItem("Shoes");
    }

    @Step("Click the \"Bags & Luggage\" link")
    public void clickBagsAndLuggageLink() {

        clickItem("Bags & Luggage");
    }
}
