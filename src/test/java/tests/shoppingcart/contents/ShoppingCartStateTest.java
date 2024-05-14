package tests.shoppingcart.contents;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import tests.base.BaseTest;
import qa.support.URLs;
import qa.pageobject.productpage.ProductShop;
import qa.pageobject.shoppingcart.ShoppingCart;
import qa.models.Product;


public class ShoppingCartStateTest extends BaseTest {

    private ProductShop productShop;
    private ShoppingCart shoppingCart;
    private final Product[] products;
    private SoftAssert softAssert;

    public ShoppingCartStateTest(Product[] products) {

        this.products = products;
    }

    @BeforeMethod
    public void prepare() throws JsonProcessingException {

        productShop = new ProductShop(getPage());
        shoppingCart = new ShoppingCart(getPage());
        softAssert = new SoftAssert();
    }

    private void actions() {

        for (Product product : products) {

            goToPage(URLs.HOME_PAGE + product.getUrl());
            productShop
                    .setColor(product.getColor())
                    .setSize(product.getSize())
                    .setQuantity(product.getQuantity())
                    .clickAddToCartButton();
            getPage().waitForURL(URLs.SHOPPING_CART);
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
    public void checkingContents() {

        actions();
        shoppingCart.getTable().findRows();

        Assert.assertTrue(shoppingCart.getTable().getRowsCount() > 0);
        checkContents();
    }
}
