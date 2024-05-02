package qa.mainmenu;

import com.microsoft.playwright.Page;

public class WomenDropdownList extends MainMenuDropdownList {

    public WomenDropdownList(Page page) {

        super(page, "Women", "View All WomenNew ArrivalsTops & BlousesPants & DenimDresses & Skirts");
    }

    public void clickViewAllWomenLink() {

        clickItem("View All Women");
    }

    public void clickNewArrivalsLink() {

        clickItem("New Arrivals");
    }

    public void clickTopsAndBlousesLink() {

        clickItem("Tops & Blouses");
    }

    public void clickPantsAndDenimLink() {

        clickItem("Pants & Denim");
    }

    public void clickDressesAndSkirtsLink() {

        clickItem("Dresses & Skirts");
    }
}
