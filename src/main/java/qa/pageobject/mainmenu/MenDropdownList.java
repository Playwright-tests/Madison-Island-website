package qa.pageobject.mainmenu;

import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

public class MenDropdownList extends MainMenuDropdownList {

    public MenDropdownList(Page page) {

        super(page, "Men","View All MenNew ArrivalsShirtsTees, Knits and PolosPants & DenimBlazers");
    }

    @Step("Click the \"View All Men\" link")
    public void clickViewAllMenLink() {

        clickItem("View All Men");
    }

    @Step("Click the \"New Arrivals\" link")
    public void clickNewArrivalsLink() {

        clickItem("New Arrivals");
    }

    @Step("Click the \"Shirts\" link")
    public void clickShirtsLink() {

        clickItem("Shirts");
    }

    @Step("Click the \"Tees, Knits and Polos\" link")
    public void clickTeesKnitsAndPolosLink() {

        clickItem("Tees, Knits and Polos");
    }

    @Step("Click the \"Pants & Denim\" link")
    public void clickPantsAndDenimLink() {

        clickItem("Pants & Denim");
    }

    @Step("Click the \"Blazers\" link")
    public void clickBlazersLink() {

        clickItem("Blazers");
    }
}
