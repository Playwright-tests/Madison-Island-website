package tests.shoppingcart.removing;

import com.microsoft.playwright.Page;
import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.models.Product;
import qa.support.ShoppingCartActions;
import tests.base.BaseTest;
import qa.support.URLs;
import qa.pageobject.shoppingcart.ShoppingCart;

@Epic("E2E")
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

    @Test(priority = 1)
    @Owner("Paweł Aksman")
    @Tag("Shopping cart")
    @Tag("Buttons")
    @Link(name = "Home page", url = URLs.SHOPPING_CART)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Removing a product from the shopping cart using a remove button")
    public void withRemoveButton() {

        shoppingCart.getTable().clickRemoveButton(0);
        actions();
    }

    @Test(priority = 2)
    @Owner("Paweł Aksman")
    @Tag("Shopping cart")
    @Tag("Quantity field")
    @Tag("Fields")
    @Link(name = "Home page", url = URLs.SHOPPING_CART)
    @Severity(SeverityLevel.NORMAL)
    @Description("Removing a product from the shopping cart using a quantity field")
    public void withQuantityField() {

        shoppingCart.getTable().getQuantityField(0).setQuantity("0");
        shoppingCart.getTable().clickUpdateCartButton(0);
        actions();
    }
}
