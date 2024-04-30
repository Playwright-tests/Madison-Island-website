package tests.header.mainmenu;

import org.testng.annotations.Test;
import tests.base.MainMenuBaseTest;

public class HomeAndDecorDropdownListTest extends MainMenuBaseTest {

    public HomeAndDecorDropdownListTest() {

        setTriggerElement("Home & Decor");
    }

    @Test(groups = "withExpandedList")
    public void viewAllHomeLink() {

        actionsWithExpandedList("View All Home & Decor", "http://demo-store.seleniumacademy.com/home-decor.html");
    }

    @Test(groups = "withExpandedList")
    public void booksAndMusicLink() {

        actionsWithExpandedList("Books & Music", "http://demo-store.seleniumacademy.com/home-decor/books-music.html");
    }

    @Test(groups = "withExpandedList")
    public void bedAndBatchLink() {

        actionsWithExpandedList("Bed & Bath", "http://demo-store.seleniumacademy.com/home-decor/bed-bath.html");
    }

    @Test(groups = "withExpandedList")
    public void electronicsLink() {

        actionsWithExpandedList("Electronics", "http://demo-store.seleniumacademy.com/home-decor/electronics.html");
    }

    @Test(groups = "withExpandedList")
    public void decorativeAccentsLink() {

        actionsWithExpandedList("Decorative Accents", "http://demo-store.seleniumacademy.com/home-decor/decorative-accents.html");
    }
}
