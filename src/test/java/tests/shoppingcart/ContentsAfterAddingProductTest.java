package tests.shoppingcart;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import qa.base.BaseTest;
import qa.dataProviders.ProductDataProviders;
import qa.enums.ProductShopMethods;
import qa.helpers.ProductShopHandler;
import qa.pageobject.productpage.ProductShop;
import qa.pageobject.shoppingcart.ShoppingCart;
import qa.records.ProductData;
import qa.support.dataprovidernames.DataProviderNames;

import java.lang.reflect.InvocationTargetException;

public class ContentsAfterAddingProductTest extends BaseTest {

    private ShoppingCart shoppingCart;
    private String productName;
    private ProductData productData;
    private SoftAssert softAssert;

    @BeforeMethod
    public void create() {

        shoppingCart = new ShoppingCart(getPage());
        softAssert = new SoftAssert();
    }

    private void actions(ProductData data) throws InvocationTargetException, IllegalAccessException {

        productData = data;
        ProductShop productShop = ProductShopHandler.set(getPage(), data, ProductShopMethods.ALL);
        productName = productShop.getProductName();

        productShop.clickAddToCartButton();
    }

    private void checkContents() {

        softAssert.assertEquals(shoppingCart.getTable().getName(), productName,
                "Incorrect product name in the shopping cart");
        softAssert.assertEquals(shoppingCart.getTable().getColor(), productData.getColor(),
                "Incorrect product color in the shopping cart");
        softAssert.assertEquals(shoppingCart.getTable().getSize(), productData.getSize(),
                "Incorrect product size in the shopping cart");
        softAssert.assertEquals(shoppingCart.getTable().getQuantityField().getQuantity(), productData.getQuantity(),
                "Incorrect amount of product");

        softAssert.assertAll();
    }

    @Test(dataProvider = DataProviderNames.PRODUCT_ATTRIBUTES, dataProviderClass = ProductDataProviders.class)
    public void checkingContents(ProductData data) throws InvocationTargetException, IllegalAccessException {

        goToPage(data.getUrl());
        actions(data);
        checkContents();
    }
}
