package qa.helpers;

import com.microsoft.playwright.Page;
import qa.enums.ProductShopMethods;
import qa.pageobject.productpage.ProductShop;
import qa.records.ProductData;
import qa.utils.MethodsRetriever;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ProductShopHandler {

    private static String[] toArray(ProductData data) {

        return new String[]{ data.getColor(), data.getQuantity(), data.getSize() };
    }

    public static ProductShop set(Page page, ProductData data, ProductShopMethods excluded) throws InvocationTargetException, IllegalAccessException {

        ProductShop productShop = new ProductShop(page);
        MethodsRetriever<ProductShop> retriever = new MethodsRetriever<>(ProductShop.class);
        Method[] methods = retriever.getMethods();
        String[] clothingData = toArray(data);

        for (int i = 0; i < methods.length; i++) {

            if (!methods[i].getName().toLowerCase().contains(excluded.getName().toLowerCase())) {

                methods[i].invoke(productShop, clothingData[i]);
            }
        }

        return productShop;
    }
}
