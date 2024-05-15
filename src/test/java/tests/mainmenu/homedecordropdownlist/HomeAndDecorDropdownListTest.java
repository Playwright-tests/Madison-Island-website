package tests.mainmenu.homedecordropdownlist;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.pageobject.mainmenu.HomeAndDecorDropdownList;
import qa.support.URLs;
import tests.base.BaseTest;

public class HomeAndDecorDropdownListTest extends BaseTest {

    private HomeAndDecorDropdownList homeAndDecorDropdownList;

    @BeforeMethod
    public void prepare() {

        homeAndDecorDropdownList = new HomeAndDecorDropdownList(getPage());
        homeAndDecorDropdownList.hoverTriggerElement();
    }

    @Test
    public void viewAllHomeLink() {

        clickAndVerifyPageUrl(HomeAndDecorDropdownList::clickViewAllHomeAndDecorLink, homeAndDecorDropdownList, URLs.HOME_DECOR_PAGE);
    }

    @Test
    public void booksAndMusicLink() {

        clickAndVerifyPageUrl(HomeAndDecorDropdownList::clickBooksAndMusicLink, homeAndDecorDropdownList, URLs.BOOKS_MUSIC_PAGE);
    }

    @Test
    public void bedAndBatchLink() {

        clickAndVerifyPageUrl(HomeAndDecorDropdownList::clickBedAndBathLink, homeAndDecorDropdownList, URLs.BED_BATH_PAGE);
    }

    @Test
    public void electronicsLink() {

        clickAndVerifyPageUrl(HomeAndDecorDropdownList::clickElectronicsLink, homeAndDecorDropdownList, URLs.ELECTRONICS_PAGE);
    }

    @Test
    public void decorativeAccentsLink() {

        clickAndVerifyPageUrl(HomeAndDecorDropdownList::clickDecorativeAccentsLink, homeAndDecorDropdownList, URLs.DECORATIVE_ACCENTS_PAGE);
    }
}
