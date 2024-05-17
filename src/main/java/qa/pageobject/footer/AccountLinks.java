package qa.pageobject.footer;

import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

public class AccountLinks extends FooterLinksSection{

    public AccountLinks(Page page) {

        super(page);
    }

    @Step("Click the \"My Account\" link")
    public void clickMyAccountLink() {

        clickLink("My Account");
    }

    @Step("Click the \"Orders and Returns\" link")
    public void clickOrdersAndReturnsLink() {

        clickLink("Orders and Returns");
    }
}
