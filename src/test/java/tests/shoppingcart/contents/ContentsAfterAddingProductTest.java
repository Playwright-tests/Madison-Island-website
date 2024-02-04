package tests.shoppingcart.contents;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import qa.base.BaseTest;
import qa.dataProviders.ProductDataProviders;
import qa.enums.ProductShopMethods;
import qa.enums.URLs;
import qa.helpers.ProductShopHandler;
import qa.pageobject.productpage.ProductShop;
import qa.pageobject.shoppingcart.ShoppingCart;
import qa.records.ProductData;

import java.lang.reflect.InvocationTargetException;

public class ContentsAfterAddingProductTest extends BaseTest {

    private ShoppingCart shoppingCart;
    private ProductData[] products;
    private SoftAssert softAssert;

    @BeforeMethod
    public void create() {

        shoppingCart = new ShoppingCart(getPage());
        softAssert = new SoftAssert();
        ProductDataProviders productDataProviders = new ProductDataProviders();
        products = (ProductData[]) productDataProviders.productAttributes();
    }

    private void actions() throws InvocationTargetException, IllegalAccessException {

        for (ProductData product : products) {

            goToPage(product.getUrl());
            ProductShop productShop = ProductShopHandler.set(getPage(), product, ProductShopMethods.ALL);
            productShop.clickAddToCartButton();
            getPage().waitForURL(URLs.SHOPPING_CART.getName());
        }
    }

    private void checkContents() {

        for (int i = 0; i < products.length; i++) {

            softAssert.assertEquals(shoppingCart.getTable().getName(i), products[i].getName(),
                    "Incorrect product name in the shopping cart");
            softAssert.assertEquals(shoppingCart.getTable().getColor(i), products[i].getColor(),
                    "Incorrect product color in the shopping cart");
            softAssert.assertEquals(shoppingCart.getTable().getSize(i), products[i].getSize(),
                    "Incorrect product size in the shopping cart");
            softAssert.assertEquals(shoppingCart.getTable().getQuantityField(i).getQuantity(), products[i].getQuantity(),
                    "Incorrect amount of product");
        }

        softAssert.assertAll();
    }

    @Test
    public void checkingContents() throws InvocationTargetException, IllegalAccessException {

        actions();
        shoppingCart.getTable().findRows();

        Assert.assertTrue(shoppingCart.getTable().getRowsCount() > 0);
        checkContents();
    }
}
