package qa.helpers;

import com.microsoft.playwright.Page;
import qa.pageobject.productpage.ProductShop;
import qa.records.ProductData;

public class ProductShopFactory {

    public static ProductShop withAllFields(Page page, ProductData data) {

        ProductShop productShop = new ProductShop(page);

        productShop
                .setColor(data.color())
                .setSize(data.size())
                .setQuantity(data.quantity());

        return productShop;
    }

    public static ProductShop withoutColor(Page page, ProductData data) {

        ProductShop productShop = new ProductShop(page);

        productShop
                .setSize(data.size())
                .setQuantity(data.quantity());

        return productShop;
    }

    public static ProductShop withoutSize(Page page, ProductData data) {

        ProductShop productShop = new ProductShop(page);

        productShop
                .setColor(data.color())
                .setQuantity(data.quantity());

        return productShop;
    }

    public static ProductShop withoutColorAndSize(Page page, ProductData data) {

        ProductShop productShop = new ProductShop(page);

        productShop.setQuantity(data.quantity());

        return productShop;
    }
}
