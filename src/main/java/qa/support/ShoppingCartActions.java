package qa.support;

import com.microsoft.playwright.Page;
import qa.models.Product;
import qa.pageobject.productpage.ProductShop;

public class ShoppingCartActions {

    public static void addToCart(Page page, Product product) {

        page.navigate(URLs.HOME_PAGE + product.getUrl());

        ProductShop productShop = new ProductShop(page);
        productShop
                .setColor(product.getColor())
                .setSize(product.getSize())
                .setQuantity(product.getQuantity())
                .clickAddToCartButton();
    }
    
    public static void addToCart(Page page, Product[] products) {

        ProductShop productShop = new ProductShop(page);

        for (Product product : products) {

            page.navigate(URLs.HOME_PAGE + product.getUrl());

            productShop
                    .setColor(product.getColor())
                    .setSize(product.getSize())
                    .setQuantity(product.getQuantity())
                    .clickAddToCartButton();
        }
    }
}
