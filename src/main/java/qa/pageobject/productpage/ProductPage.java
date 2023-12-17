package qa.pageobject.productpage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import qa.base.BasePage;

public class ProductPage extends BasePage {

    private final Locator errorMessage;
    private ProductShop productShop;

    public ProductPage(Page page) {

        super(page);

        errorMessage = page.locator(".error-msg");
        this.productShop = null;
    }

    public void setProductShop(ProductShop productShop) {

        this.productShop = productShop;
    }

    public boolean isErrorMessageVisible() {

        return errorMessage.isVisible();
    }

    public String getErrorMessage() {

        return errorMessage.textContent();
    }

    public ProductShop getProductShop() {

        return productShop;
    }
}
