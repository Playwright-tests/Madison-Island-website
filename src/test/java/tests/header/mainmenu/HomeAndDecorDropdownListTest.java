package tests.header.mainmenu;

import org.testng.annotations.Test;
import qa.support.URLs;
import tests.base.MainMenuBaseTest;

public class HomeAndDecorDropdownListTest extends MainMenuBaseTest {

    public HomeAndDecorDropdownListTest() {

        setTriggerElement("Home & Decor");
    }

    @Test(groups = "withExpandedList")
    public void viewAllHomeLink() {

        actionsForDropdownLists("View All Home & Decor", URLs.HOME_DECOR_PAGE);
    }

    @Test(groups = "withExpandedList")
    public void booksAndMusicLink() {

        actionsForDropdownLists("Books & Music", URLs.BOOKS_MUSIC_PAGE);
    }

    @Test(groups = "withExpandedList")
    public void bedAndBatchLink() {

        actionsForDropdownLists("Bed & Bath", URLs.BED_BATH_PAGE);
    }

    @Test(groups = "withExpandedList")
    public void electronicsLink() {

        actionsForDropdownLists("Electronics", URLs.ELECTRONICS_PAGE);
    }

    @Test(groups = "withExpandedList")
    public void decorativeAccentsLink() {

        actionsForDropdownLists("Decorative Accents", URLs.DECORATIVE_ACCENTS_PAGE);
    }
}
