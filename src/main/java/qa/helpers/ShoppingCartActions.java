package qa.helpers;

import com.microsoft.playwright.Page;
import qa.models.Product;
import qa.pageobject.productpage.ProductShop;

public class ShoppingCartActions {

    public static void addToCart(Page page, Product product) {

        page.navigate(page.url());

        ProductShop productShop = new ProductShop(page);
        productShop
                .setColor(product.getColor())
                .setSize(product.getSize())
                .setQuantity(product.getQuantity())
                .clickAddToCartButton();
    }
}
