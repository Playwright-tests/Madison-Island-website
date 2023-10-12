package pageobject.components;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import qa.base.BasePage;

public class MainMenu extends BasePage {

    Locator parent;
    Locator womenItems;
    Locator menItems;
    Locator accessoriesItems;
    Locator homeAndDecorItems;
    Locator saleItems;

    public MainMenu(Page page) {

        super(page);

        parent = getPage().locator("#nav");

        womenItems = getPage().getByRole(AriaRole.LISTITEM)
                .filter(new Locator.FilterOptions().setHasText("WomenView All WomenNew ArrivalsTops & BlousesPants & DenimDresses & Skirts"));

        menItems = getPage().getByRole(AriaRole.LISTITEM)
                .filter(new Locator.FilterOptions().setHasText("MenView All MenNew ArrivalsShirtsTees, Knits and PolosPants & DenimBlazers"));

        accessoriesItems = getPage().getByRole(AriaRole.LISTITEM)
                .filter(new Locator.FilterOptions().setHasText("AccessoriesView All AccessoriesEyewearJewelryShoesBags & Luggage"));

        homeAndDecorItems = getPage().getByRole(AriaRole.LISTITEM)
                .filter(new Locator.FilterOptions().setHasText("Home & DecorView all Home & DecorBooks & MusicBed & BathElectronicsDecorative Accents"));

        saleItems = getPage().getByRole(AriaRole.LISTITEM)
                .filter(new Locator.FilterOptions().setHasText("SaleView All SaleWomenMenAccessoriesHome & Decor"));
    }

    public void hoverParent(String name) {

        parent.getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName(name).setExact(true)).hover();
    }

    private void clickItem(Locator locator, String name) {

        locator.getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName(name).setExact(true)).click();;
    }

    public void clickWomenItem(String name) {

        clickItem(womenItems, name);
    }

    public void clickMenItem(String name) {

        clickItem(menItems, name);
    }

    public void clickAccessoriesItem(String name) {

        clickItem(accessoriesItems, name);
    }

    public void clickHomeAndDecorItem(String name) {

        clickItem(homeAndDecorItems, name);
    }

    public void clickSaleItem(String name) {

        clickItem(saleItems, name);
    }

    public void clickVip() {

        parent.getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("VIP").setExact(true)).click();
    }
}
