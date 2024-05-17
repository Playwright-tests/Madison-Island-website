package tests.shoppingcart.quantityfield;

import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
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
    @Owner("Paweł Aksman")
    @Tag("Newsletter form")
    @Tag("Quantity field")
    @Tag("Fields")
    @Tag("Shopping cart")
    @Link(name = "Home page", url = URLs.HOME_PAGE)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verification of the quantity field text input")
    public void checkInputText() {

        String quantity = "123";
        Allure.link("The \"" + product.getName() + "\" product page", product.getUrl());
        Allure.parameter("Quantity", quantity);
        shoppingCart.getTable().getQuantityField(0).setQuantity(quantity);

        Assert.assertEquals(shoppingCart.getTable().getQuantityField(0).getQuantity(), quantity,
                "Incorrect input content");
    }
}
