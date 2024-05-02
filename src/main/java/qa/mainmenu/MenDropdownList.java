package qa.mainmenu;

import com.microsoft.playwright.Page;

public class MenDropdownList extends MainMenuDropdownList {

    public MenDropdownList(Page page) {

        super(page, "Men","View All MenNew ArrivalsShirtsTees, Knits and PolosPants & DenimBlazers");
    }

    public void clickViewAllMenLink() {

        clickItem("View All Men");
    }

    public void clickNewArrivalsLink() {

        clickItem("New Arrivals");
    }

    public void clickShirtsLink() {

        clickItem("Shirts");
    }

    public void clickTeesKnitsAndPolosLink() {

        clickItem("Tees, Knits and Polos");
    }

    public void clickPantsAndDenimLink() {

        clickItem("Pants & Denim");
    }

    public void clickBlazersLink() {

        clickItem("Blazers");
    }
}
