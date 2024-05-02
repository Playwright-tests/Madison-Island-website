package qa.mainmenu;

import com.microsoft.playwright.Page;

public class HomeAndDecorDropdownList extends MainMenuDropdownList {

    public HomeAndDecorDropdownList(Page page) {

        super(page, "Home & Decor", "View All Home & DecorBooks & MusicBed & BathElectronicsDecorative Accents");
    }

    public void clickViewAllHomeAndDecorLink() {

        clickItem("View All Home & Decor");
    }

    public void clickBooksAndMusicLink() {

        clickItem("Books & Music");
    }

    public void clickBedAndBathLink() {

        clickItem("Bed & Bath");
    }

    public void clickElectronicsLink() {

        clickItem("Electronics");
    }

    public void clickDecorativeAccentsLink() {

        clickItem("Decorative Accents");
    }
}
