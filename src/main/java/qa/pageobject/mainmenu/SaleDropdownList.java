package qa.pageobject.mainmenu;

import com.microsoft.playwright.Page;

public class SaleDropdownList extends MainMenuDropdownList {

    public SaleDropdownList(Page page) {

        super(page, "Sale", "View All SaleWomenMenAccessoriesHome & Decor");
    }

    public void clickViewAllSaleLink() {

        clickItem("View All Sale");
    }

    public void clickWomenLink() {

        clickItem("Women");
    }

    public void clickMenLink() {

        clickItem("Men");
    }

    public void clickAccessoriesLink() {

        clickItem("Accessories");
    }

    public void clickHomeAndDecorLink() {

        clickItem("Home & Decor");
    }
}
