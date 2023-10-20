package qa.pageobject.productpage;

import com.microsoft.playwright.Page;
import qa.base.BasePage;

public class ProductPage extends BasePage {

    private ProductShop productShop;

    public ProductPage(Page page) {

        super(page);

        this.productShop = null;
    }

    public void setProductShop(ProductShop productShop) {

        this.productShop = productShop;
    }

    public ProductShop getProductShop() {

        return productShop;
    }
}
