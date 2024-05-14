package qa.pageobject.productpage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.Getter;
import lombok.Setter;
import qa.base.BasePage;

public class ProductPage extends BasePage {

    @Getter
    private final String errorMessageSelector = ".error-msg";
    private final Locator errorMessage;
    @Getter
    @Setter
    private ProductShop productShop;

    public ProductPage(Page page) {

        super(page);

        errorMessage = page.locator(errorMessageSelector);
        this.productShop = new ProductShop(getPage());
    }

    public String getErrorMessage() {

        return errorMessage.textContent();
    }
}
