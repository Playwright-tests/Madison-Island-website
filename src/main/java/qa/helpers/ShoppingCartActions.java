package qa.helpers;

import com.microsoft.playwright.Page;
import qa.dataProvider.Provider;
import qa.enums.ProductShopMethods;
import qa.pageobject.productpage.ProductShop;
import qa.records.ProductData;

import java.lang.reflect.InvocationTargetException;


public class ShoppingCartActions {

    public static void addToCart(Page page) throws InvocationTargetException, IllegalAccessException {

        Provider provider = new Provider();
        ProductData[] productData = (ProductData[]) provider.correctProductData();
        ProductShop productShop = ProductShopHandler.set(page, productData[0], ProductShopMethods.ALL);
        productShop.clickAddToCartButton();
    }
}
