package pages.productpage;

import com.microsoft.playwright.Page;
import qa.base.BasePage;

public class ProductPage extends BasePage {

    private final ProductShop productShop;

    public ProductPage(Page page) {

        super(page);

        productShop = new ProductShop(page);
    }

    public ProductShop getProductShop() {

        return productShop;
    }
}
