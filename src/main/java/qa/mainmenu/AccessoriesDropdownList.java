package qa.mainmenu;

import com.microsoft.playwright.Page;

public class AccessoriesDropdownList extends MainMenuDropdownList {

    public AccessoriesDropdownList(Page page) {
        super(page, "Accessories", "View All AccessoriesEyewearJewelryShoesBags & Luggage");
    }

    public void clickViewAllAccessoriesLink() {

        clickItem("View All Accessories");
    }

    public void clickEyewearLink() {

        clickItem("Eyewear");
    }

    public void clickJewelryLink() {

        clickItem("Jewelry");
    }

    public void clickShoesLink() {

        clickItem("Shoes");
    }

    public void clickBagsAndLuggageLink() {

        clickItem("Bags & Luggage");
    }
}
