package qa.helpers;

import com.microsoft.playwright.Page;
import qa.pageobject.productpage.ProductShop;
import qa.utils.ProductData;

public class ProductShopFactory {

    public static ProductShop withAllFields(Page page, ProductData data) {

        ProductShop productShop = new ProductShop(page);

        productShop
                .setColor(data.getColor())
                .setSize(data.getSize())
                .setQuantity(data.getQuantity());

        return productShop;
    }

    public static ProductShop withoutColor(Page page, ProductData data) {

        ProductShop productShop = new ProductShop(page);

        productShop
                .setSize(data.getSize())
                .setQuantity(data.getQuantity());

        return productShop;
    }

    public static ProductShop withoutSize(Page page, ProductData data) {

        ProductShop productShop = new ProductShop(page);

        productShop
                .setColor(data.getColor())
                .setQuantity(data.getQuantity());

        return productShop;
    }

    public static ProductShop withoutColorAndSize(Page page, ProductData data) {

        ProductShop productShop = new ProductShop(page);

        productShop.setQuantity(data.getQuantity());

        return productShop;
    }
}
