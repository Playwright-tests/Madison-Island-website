package qa.pageobject.mainmenu;

import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

public class HomeAndDecorDropdownList extends MainMenuDropdownList {

    public HomeAndDecorDropdownList(Page page) {

        super(page, "Home & Decor", "View All Home & DecorBooks & MusicBed & BathElectronicsDecorative Accents");
    }

    @Step("Click the \"View All Home & Decor\" link")
    public void clickViewAllHomeAndDecorLink() {

        clickItem("View All Home & Decor");
    }

    @Step("Click the \"Books & Music\" link")
    public void clickBooksAndMusicLink() {

        clickItem("Books & Music");
    }

    @Step("Click the \"Bed & Bath\" link")
    public void clickBedAndBathLink() {

        clickItem("Bed & Bath");
    }

    @Step("Click the \"Electronics\" link")
    public void clickElectronicsLink() {

        clickItem("Electronics");
    }

    @Step("Click the \"Decorative Accents\" link")
    public void clickDecorativeAccentsLink() {

        clickItem("Decorative Accents");
    }
}
