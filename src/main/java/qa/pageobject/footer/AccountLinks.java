package qa.pageobject.footer;

import com.microsoft.playwright.Page;

public class AccountLinks extends FooterLinksSection{

    public AccountLinks(Page page) {

        super(page);
    }

    public void clickMyAccountLink() {

        clickLink("My Account");
    }

    public void clickOrdersAndReturnsLink() {

        clickLink("Orders and Returns");
    }
}
