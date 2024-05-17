package qa.pageobject.mainmenu;

import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

public class SaleDropdownList extends MainMenuDropdownList {

    public SaleDropdownList(Page page) {

        super(page, "Sale", "View All SaleWomenMenAccessoriesHome & Decor");
    }

    @Step("Click the \"View All Sale\" link")
    public void clickViewAllSaleLink() {

        clickItem("View All Sale");
    }

    @Step("Click the \"Women\" link")
    public void clickWomenLink() {

        clickItem("Women");
    }

    @Step("Click the \"Men\" link")
    public void clickMenLink() {

        clickItem("Men");
    }

    @Step("Click the \"Accessories\" link")
    public void clickAccessoriesLink() {

        clickItem("Accessories");
    }

    @Step("Click the \"Home & Decor\" link")
    public void clickHomeAndDecorLink() {

        clickItem("Home & Decor");
    }
}
