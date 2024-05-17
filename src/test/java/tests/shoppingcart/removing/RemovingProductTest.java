package tests.shoppingcart.removing;

import com.microsoft.playwright.Page;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.models.Product;
import qa.support.ShoppingCartActions;
import tests.base.BaseTest;
import qa.support.URLs;
import qa.pageobject.shoppingcart.ShoppingCart;

public class RemovingProductTest extends BaseTest {

    private final Product[] products;
    private ShoppingCart shoppingCart;
    int currentTableRowsCount;

    public RemovingProductTest(Product[] products) {

        this.products = products;
    }

    @BeforeMethod
    public void prepare() {

        ShoppingCartActions.addToCart(getPage(), products);
        getPage().waitForURL(URLs.SHOPPING_CART);

        shoppingCart = new ShoppingCart(getPage());
        shoppingCart.getTable().findRows();
        currentTableRowsCount = shoppingCart.getTable().getRowsCount();
    }

    private void actions() {

        getPage().waitForURL(URLs.SHOPPING_CART, new Page.WaitForURLOptions().setTimeout(2000));
        shoppingCart.getTable().findRows();

        Assert.assertEquals(shoppingCart.getTable().getRowsCount(), currentTableRowsCount - 1,
                "The product has not been removed from the shopping cart");
    }

    @Test
    public void withRemoveButton() throws InterruptedException {


        shoppingCart.getTable().clickRemoveButton(0);
        actions();
    }

    @Test
    public void withQuantityField() throws InterruptedException {

        shoppingCart.getTable().getQuantityField(0).setQuantity("0");
        shoppingCart.getTable().clickUpdateCartButton(0);
        actions();
    }
}
