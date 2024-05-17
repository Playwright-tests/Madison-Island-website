package tests.mainmenu;

import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.pageobject.mainmenu.MainMenu;
import qa.support.URLs;
import tests.base.BaseTest;

@Epic("E2E")
public class MainMenuLinksTest extends BaseTest {

    private MainMenu mainMenu;

    @BeforeMethod
    public void prepare() {

        mainMenu = new MainMenu(getPage());
    }

    @Test(priority = 1, groups = "withoutExpandedList")
    @Owner("Paweł Aksman")
    @Tag("Main menu")
    @Tag("Dropdown list")
    @Tag("Links")
    @Link(name = "Home page", url = URLs.HOME_PAGE)
    @Severity(SeverityLevel.CRITICAL)
    @Description("The \"Women\" link")
    public void womenLink() {

        clickAndVerifyPageUrl(MainMenu::clickWomenLink, mainMenu, URLs.WOMEN_PAGE);
    }

    @Test(priority = 2, groups = "withoutExpandedList")
    @Owner("Paweł Aksman")
    @Tag("Main menu")
    @Tag("Dropdown list")
    @Tag("Links")
    @Link(name = "Home page", url = URLs.HOME_PAGE)
    @Severity(SeverityLevel.CRITICAL)
    @Description("The \"Men\" link")
    public void menLink() {

        clickAndVerifyPageUrl(MainMenu::clickMenLink, mainMenu, URLs.MEN_PAGE);
    }

    @Test(priority = 3, groups = "withoutExpandedList")
    @Owner("Paweł Aksman")
    @Tag("Main menu")
    @Tag("Dropdown list")
    @Tag("Links")
    @Link(name = "Home page", url = URLs.HOME_PAGE)
    @Severity(SeverityLevel.CRITICAL)
    @Description("The \"Accessories\" link")
    public void accessoriesLink() {

        clickAndVerifyPageUrl(MainMenu::clickAccessoriesLink, mainMenu, URLs.ACCESSORIES_PAGE);
    }

    @Test(priority = 4, groups = "withoutExpandedList")
    @Owner("Paweł Aksman")
    @Tag("Main menu")
    @Tag("Dropdown list")
    @Tag("Links")
    @Link(name = "Home page", url = URLs.HOME_PAGE)
    @Severity(SeverityLevel.CRITICAL)
    @Description("The \"Home & Decor\" link")
    public void homeAndDecorLink() {

        clickAndVerifyPageUrl(MainMenu::clickHomeAndDecorLink, mainMenu, URLs.HOME_DECOR_PAGE);
    }

    @Test(priority = 5, groups = "withoutExpandedList")
    @Owner("Paweł Aksman")
    @Tag("Main menu")
    @Tag("Dropdown list")
    @Tag("Links")
    @Link(name = "Home page", url = URLs.HOME_PAGE)
    @Severity(SeverityLevel.CRITICAL)
    @Description("The \"Sale\" link")
    public void saleLink() {

        clickAndVerifyPageUrl(MainMenu::clickSaleLink, mainMenu, URLs.SALE_PAGE);
    }

    @Test(priority = 6, groups = "withoutExpandedList")
    @Owner("Paweł Aksman")
    @Tag("Main menu")
    @Tag("Dropdown list")
    @Tag("Links")
    @Link(name = "Home page", url = URLs.HOME_PAGE)
    @Severity(SeverityLevel.CRITICAL)
    @Description("The \"VIP\" link")
    public void vipLink() {

        clickAndVerifyPageUrl(MainMenu::clickVipLink, mainMenu, URLs.VIP_PAGE);
    }
}
