package qa.pageobject.productpage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.Getter;
import lombok.Setter;
import qa.base.BasePage;

public class ProductPage extends BasePage {

    private final Locator errorMessage;
    @Getter
    @Setter
    private ProductShop productShop;

    public ProductPage(Page page) {

        super(page);

        errorMessage = page.locator(".error-msg");
        this.productShop = new ProductShop(getPage());
    }

    public Locator getErrorMessageLocator() {

        return errorMessage;
    }

    public String getErrorMessage() {

        return errorMessage.textContent();
    }
}
