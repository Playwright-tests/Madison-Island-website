package tests.shoppingcart.quantityfield;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.models.Product;
import tests.base.BaseTest;
import qa.support.URLs;
import qa.support.ShoppingCartActions;
import qa.pageobject.shoppingcart.ShoppingCart;

public class InputTextVerificationTest extends BaseTest {

    private final Product product;
    private ShoppingCart shoppingCart;

    public InputTextVerificationTest(Product product) {

        this.product = product;
    }

    @BeforeMethod
    public void prepare() {

        ShoppingCartActions.addToCart(getPage(), product);
        getPage().waitForURL(URLs.SHOPPING_CART);

        shoppingCart = new ShoppingCart(getPage());
        shoppingCart.getTable().findRows();
    }

    @Test
    public void checkInputText() {

        String quantity = "123";
        shoppingCart.getTable().getQuantityField(0).setQuantity(quantity);

        Assert.assertEquals(shoppingCart.getTable().getQuantityField(0).getQuantity(), quantity,
                "Incorrect input content");
    }
}
