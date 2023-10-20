package qa.pageobject.components;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import qa.base.BasePage;

import java.util.HashMap;

public class MainMenu extends BasePage {

    Locator parent;
    String hovered;

    HashMap<String, String> items = new HashMap<>() {{

        put("Women", "WomenView All WomenNew ArrivalsTops & BlousesPants & DenimDresses & Skirts");
        put("Men", "MenView All MenNew ArrivalsShirtsTees, Knits and PolosPants & DenimBlazers");
        put("Accessories", "AccessoriesView All AccessoriesEyewearJewelryShoesBags & Luggage");
        put("Home & Decor", "Home & DecorView all Home & DecorBooks & MusicBed & BathElectronicsDecorative Accents");
        put("Sale", "SaleView All SaleWomenMenAccessoriesHome & Decor");
    }};

    public MainMenu(Page page) {

        super(page);

        parent = getPage().locator("#nav");
    }

    public void hoverParent(String name) {

        parent.getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName(name).setExact(true)).hover();
        hovered = name;
    }

    public void clickItem(String name) {

        Locator item = getPage().getByRole(AriaRole.LISTITEM).filter(new Locator.FilterOptions().setHasText(items.get(hovered)));
        item.getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName(name).setExact(true)).click();
    }

    public void clickVip() {

        parent.getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("VIP").setExact(true)).click();
    }
}
