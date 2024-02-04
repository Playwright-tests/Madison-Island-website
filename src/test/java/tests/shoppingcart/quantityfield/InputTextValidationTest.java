package tests.shoppingcart.quantityfield;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.enums.URLs;
import qa.helpers.ShoppingCartActions;
import qa.pageobject.shoppingcart.ShoppingCart;

public class InputTextValidationTest extends BaseTest {

    private ShoppingCart shoppingCart;

    @BeforeMethod
    public void create() {

        goToPage(URLs.ELIZABETH_KNIT_PRODUCT_PAGE.getName());
        ShoppingCartActions.addToCart(getPage()).clickAddToCartButton();
        getPage().waitForURL(URLs.SHOPPING_CART.getName());

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
