package tests.shoppingcart.removing;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.enums.URLs;
import qa.helpers.ShoppingCartActions;
import qa.pageobject.shoppingcart.ShoppingCart;

public class RemovingProductTest extends BaseTest {

    private ShoppingCart shoppingCart;

    @BeforeMethod
    public void create() {

        goToPage(URLs.ELIZABETH_KNIT_PRODUCT_PAGE.getName());
        ShoppingCartActions.addToCart(getPage()).clickAddToCartButton();
        getPage().waitForURL(URLs.SHOPPING_CART.getName());

        shoppingCart = new ShoppingCart(getPage());
        shoppingCart.getTable().findRows();
    }

    private void check() {

        Assert.assertEquals(shoppingCart.getTable().getRowsCount(), 0,
                "The shopping cart is not empty");
        Assert.assertEquals(shoppingCart.getPageTitleText(), "Shopping Cart is Empty",
                "Incorrect message content");
    }

    @Test
    public void withRemoveButton() {

        shoppingCart.getTable().clickRemoveButton(0);
        shoppingCart.getTable().findRows();

        check();
    }

    @Test
    public void withQuantityField() {

        shoppingCart.getTable().getQuantityField(0).setQuantity("0");
        shoppingCart.getTable().clickUpdateCartButton(0);
        shoppingCart.getTable().findRows();

        check();
    }
}
