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

        for (int i = 0; i < products.length; i++) {

            page.navigate(URLs.HOME_PAGE + products[i].getUrl());

            productShop
                    .setColor(products[i].getColor())
                    .setSize(products[i].getSize())
                    .setQuantity(products[i].getQuantity())
                    .clickAddToCartButton();
        }
    }
}
