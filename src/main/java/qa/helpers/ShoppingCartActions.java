package qa.helpers;

import com.microsoft.playwright.Page;
import qa.pageobject.productpage.ProductShop;

public class ShoppingCartActions {

    public static ProductShop addToCart(Page page) {

        String color = "Red";
        String size = "L";

        ProductShop productShop = new ProductShop(page);
        productShop.setColor(color);
        productShop.setSize(size);

        return productShop;
    }
}
