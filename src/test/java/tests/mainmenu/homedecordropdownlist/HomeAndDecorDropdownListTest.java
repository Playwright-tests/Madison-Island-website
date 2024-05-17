package tests.mainmenu.homedecordropdownlist;

import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.pageobject.mainmenu.HomeAndDecorDropdownList;
import qa.support.URLs;
import tests.base.BaseTest;

@Epic("E2E")
public class HomeAndDecorDropdownListTest extends BaseTest {

    private HomeAndDecorDropdownList homeAndDecorDropdownList;

    @BeforeMethod
    public void prepare() {

        homeAndDecorDropdownList = new HomeAndDecorDropdownList(getPage());
        homeAndDecorDropdownList.hoverTriggerElement();
    }

    @Test(priority = 1)
    @Owner("Paweł Aksman")
    @Tag("Main menu")
    @Tag("Dropdown list")
    @Tag("Links")
    @Link(name = "Home page", url = URLs.HOME_PAGE)
    @Severity(SeverityLevel.CRITICAL)
    @Description("The \"View All Home & Decor\" link")
    public void viewAllHomeLink() {

        clickAndVerifyPageUrl(HomeAndDecorDropdownList::clickViewAllHomeAndDecorLink, homeAndDecorDropdownList, URLs.HOME_DECOR_PAGE);
    }

    @Test(priority = 2)
    @Owner("Paweł Aksman")
    @Tag("Main menu")
    @Tag("Dropdown list")
    @Tag("Links")
    @Link(name = "Home page", url = URLs.HOME_PAGE)
    @Severity(SeverityLevel.NORMAL)
    @Description("The \"Books & Music\" link")
    public void booksAndMusicLink() {

        clickAndVerifyPageUrl(HomeAndDecorDropdownList::clickBooksAndMusicLink, homeAndDecorDropdownList, URLs.BOOKS_MUSIC_PAGE);
    }

    @Test(priority = 3)
    @Owner("Paweł Aksman")
    @Tag("Main menu")
    @Tag("Dropdown list")
    @Tag("Links")
    @Link(name = "Home page", url = URLs.HOME_PAGE)
    @Severity(SeverityLevel.NORMAL)
    @Description("The \"Bed & Bath\" link")
    public void bedAndBatchLink() {

        clickAndVerifyPageUrl(HomeAndDecorDropdownList::clickBedAndBathLink, homeAndDecorDropdownList, URLs.BED_BATH_PAGE);
    }

    @Test(priority = 4)
    @Owner("Paweł Aksman")
    @Tag("Main menu")
    @Tag("Dropdown list")
    @Tag("Links")
    @Link(name = "Home page", url = URLs.HOME_PAGE)
    @Severity(SeverityLevel.NORMAL)
    @Description("The \"Electronics\" link")
    public void electronicsLink() {

        clickAndVerifyPageUrl(HomeAndDecorDropdownList::clickElectronicsLink, homeAndDecorDropdownList, URLs.ELECTRONICS_PAGE);
    }

    @Test(priority = 5)
    @Owner("Paweł Aksman")
    @Tag("Main menu")
    @Tag("Dropdown list")
    @Tag("Links")
    @Link(name = "Home page", url = URLs.HOME_PAGE)
    @Severity(SeverityLevel.NORMAL)
    @Description("The \"Decorative Accents\" link")
    public void decorativeAccentsLink() {

        clickAndVerifyPageUrl(HomeAndDecorDropdownList::clickDecorativeAccentsLink, homeAndDecorDropdownList, URLs.DECORATIVE_ACCENTS_PAGE);
    }
}
