package tests.header.mainmenu;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.mainmenu.MainMenu;
import qa.support.URLs;
import tests.base.BaseTest;

public class MainMenuLinksTest extends BaseTest {

    private MainMenu mainMenu;

    @BeforeMethod
    public void prepare() {

        mainMenu = new MainMenu(getPage());
    }

    @Test(groups = "withoutExpandedList")
    public void womenLink() {

        clickAndVerifyPageUrl(MainMenu::clickWomenLink, mainMenu, URLs.WOMEN_PAGE);
    }

    @Test(groups = "withoutExpandedList")
    public void menLink() {

        clickAndVerifyPageUrl(MainMenu::clickMenLink, mainMenu, URLs.MEN_PAGE);
    }

    @Test(groups = "withoutExpandedList")
    public void accessoriesLink() {

        clickAndVerifyPageUrl(MainMenu::clickAccessoriesLink, mainMenu, URLs.ACCESSORIES_PAGE);
    }

    @Test(groups = "withoutExpandedList")
    public void homeAndDecorLink() {

        clickAndVerifyPageUrl(MainMenu::clickHomeAndDecorLink, mainMenu, URLs.HOME_DECOR_PAGE);
    }

    @Test(groups = "withoutExpandedList")
    public void saleLink() {

        clickAndVerifyPageUrl(MainMenu::clickSaleLink, mainMenu, URLs.SALE_PAGE);
    }

    @Test(groups = "withoutExpandedList")
    public void vipLink() {

        clickAndVerifyPageUrl(MainMenu::clickVipLink, mainMenu, URLs.VIP_PAGE);
    }
}
