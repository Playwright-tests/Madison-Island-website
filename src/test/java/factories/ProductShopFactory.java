package factories;

import com.microsoft.playwright.Page;
import pageobject.productpage.ProductShop;
import utils.ProductOptions;

public class ProductShopFactory {

    public static ProductShop withAllFields(Page page, ProductOptions options) {

        ProductShop productShop = new ProductShop(page);

        productShop
                .setColor(options.getColor())
                .setSize(options.getSize())
                .setQuantity(options.getQuantity());

        return productShop;
    }

    public static ProductShop withoutColor(Page page, ProductOptions options) {

        ProductShop productShop = new ProductShop(page);

        productShop
                .setSize(options.getSize())
                .setQuantity(options.getQuantity());

        return productShop;
    }

    public static ProductShop withoutSize(Page page, ProductOptions options) {

        ProductShop productShop = new ProductShop(page);

        productShop
                .setColor(options.getColor())
                .setQuantity(options.getQuantity());

        return productShop;
    }

    public static ProductShop withoutColorAndSize(Page page, ProductOptions options) {

        ProductShop productShop = new ProductShop(page);

        productShop.setQuantity(options.getQuantity());

        return productShop;
    }
}
