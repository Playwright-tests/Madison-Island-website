package qa.pageobject.shoppingcart;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.Getter;
import qa.base.BasePage;

public class ShoppingCart extends BasePage {

    private final String errorMessageSelector;
    @Getter
    private final Table table;
    private final Locator errorMessage;
    private final Locator pageTitle;

    public ShoppingCart(Page page) {

        super(page);

        errorMessageSelector = "li.error-msg";

        table = new Table(page);
        errorMessage = page.locator(".error-msg");
        pageTitle = page.locator("div.page-title");
    }

    public Locator getErrorMessageLocator() {

        return errorMessage;
    }

    public String getErrorMessageSelector() {

        return errorMessageSelector;
    }

    public String getErrorMessageText() {

        return errorMessage.textContent();
    }

    public String getPageTitleText() {

        return pageTitle.textContent().trim();
    }
}
