package tests.shoppingcart.quantityfield;

import com.microsoft.playwright.Page;
import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.dataProviders.QuantityFieldDataProviders;
import qa.support.ShoppingCartActions;
import qa.models.Product;
import qa.support.DataProviderNames;
import tests.base.BaseTest;
import qa.support.URLs;
import qa.pageobject.shoppingcart.ShoppingCart;

@Epic("E2E")
public class ValidationTest extends BaseTest {

    private final Product product;
    private ShoppingCart shoppingCart;

    public ValidationTest(Product product) {

        this.product = product;
    }

    @BeforeMethod
    public void prepare() {

        ShoppingCartActions.addToCart(getPage(), product);
        getPage().waitForURL(URLs.SHOPPING_CART);

        shoppingCart = new ShoppingCart(getPage());
        shoppingCart.getTable().findRows();
    }

    private void setAllureParameters(String quantity) {

        Allure.link("The \"" + product.getName() + "\" product page", product.getUrl());
        Allure.parameter("Quantity", quantity);
    }

    private void actions(String quantity) {

        shoppingCart.getTable().getQuantityField(0)
                        .clickQuantityField()
                        .setQuantity(quantity);

        shoppingCart.getTable().clickUpdateCartButton(0);
    }

    @Test(priority = 1)
    @Owner("Paweł Aksman")
    @Tag("Newsletter form")
    @Tag("Quantity field")
    @Tag("Fields")
    @Link(name = "Home page", url = URLs.SHOPPING_CART)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Quantity- minimum")
    public void min() {

        Allure.parameter("Quantity", "1");
        actions("1");
        Assert.assertEquals(shoppingCart.getTable().getQuantityField(0).getQuantity(), "1", "Incorrect quantity");
    }

    @Test(priority = 2)
    @Owner("Paweł Aksman")
    @Tag("Newsletter form")
    @Tag("Quantity field")
    @Tag("Fields")
    @Link(name = "Home page", url = URLs.SHOPPING_CART)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Quantity- exceeding minimum (min + 1)")
    public void aboveMin() {

        Allure.parameter("Quantity", "2");
        actions("2");
        Assert.assertEquals(shoppingCart.getTable().getQuantityField(0).getQuantity(), "2", "Incorrect quantity");
    }

    @Test(priority = 3)
    @Owner("Paweł Aksman")
    @Tag("Newsletter form")
    @Tag("Quantity field")
    @Tag("Fields")
    @Link(name = "Home page", url = URLs.SHOPPING_CART)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Quantity- shorter than maximum (max - 1)")
    public void belowMax() {

        String quantity = String.valueOf(Integer.parseInt(product.getMaxQuantity()) - 1);
        Allure.parameter("Quantity", quantity);
        actions(quantity);
        Assert.assertEquals(shoppingCart.getTable().getQuantityField(0).getQuantity(), quantity, "Incorrect quantity");
    }

    @Test(priority = 4)
    @Owner("Paweł Aksman")
    @Tag("Newsletter form")
    @Tag("Quantity field")
    @Tag("Fields")
    @Link(name = "Home page", url = URLs.SHOPPING_CART)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Quantity- maximum")
    public void max() {

        setAllureParameters(product.getMaxQuantity());
        Allure.parameter("Quantity", product.getMaxQuantity());
        Assert.assertEquals(shoppingCart.getTable().getQuantityField(0).getQuantity(), product.getMaxQuantity(), "Incorrect quantity");
    }

    @Test(priority = 5)
    @Owner("Paweł Aksman")
    @Tag("Newsletter form")
    @Tag("Quantity field")
    @Tag("Fields")
    @Link(name = "Home page", url = URLs.SHOPPING_CART)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Quantity- exceeding maximum (max + 1)")
    public void aboveMax() {

        String quantity = String.valueOf(Integer.parseInt(product.getMaxQuantity()) + 1);
        Allure.parameter("Quantity", quantity);
        actions(quantity);

        try {
            getPage().waitForSelector(shoppingCart.getTable().getItemErrorMessageSelector(), new Page.WaitForSelectorOptions().setTimeout(2000));
        } catch (Exception e) {
            Assert.fail("The item error message is not displayed");
        }

        Assert.assertTrue(shoppingCart.getTable().getItemErrorMessageText()
                .contains("The requested quantity for \"" + product.getName() + "\" is not available."),
                "Incorrect message content");
    }

    @Test(priority = 6, dataProvider = DataProviderNames.NEGATIVE, dataProviderClass = QuantityFieldDataProviders.class)
    @Owner("Paweł Aksman")
    @Tag("Newsletter form")
    @Tag("Quantity field")
    @Tag("Fields")
    @Link(name = "Home page", url = URLs.SHOPPING_CART)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Entering a negative value")
    public void negative(String quantity) {

        Allure.parameter("Quantity", quantity);
        actions(quantity);

        Assert.assertFalse(shoppingCart.getTable().getQuantityField(0).getValidationMessage().isEmpty(),"No validation message");
    }

    @Test(priority = 7, dataProvider = DataProviderNames.FLOATING_POINT, dataProviderClass = QuantityFieldDataProviders.class)
    @Owner("Paweł Aksman")
    @Tag("Newsletter form")
    @Tag("Quantity field")
    @Tag("Fields")
    @Link(name = "Home page", url = URLs.SHOPPING_CART)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Entering a floating point")
    public void floatingPoint(String quantity) {

        Allure.parameter("Quantity", quantity);
        actions(quantity);

        Assert.assertFalse(shoppingCart.getTable().getQuantityField(0).getValidationMessage().isEmpty(),"No validation message");
    }

    @Test(priority = 8, dataProvider = DataProviderNames.NOT_NUMBER, dataProviderClass = QuantityFieldDataProviders.class)
    @Owner("Paweł Aksman")
    @Tag("Newsletter form")
    @Tag("Quantity field")
    @Tag("Fields")
    @Link(name = "Home page", url = URLs.SHOPPING_CART)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Entering a special character")
    public void notNumber(String quantity) {

        Allure.parameter("Quantity", quantity);
        actions(quantity);

        Assert.assertFalse(shoppingCart.getTable().getQuantityField(0).getValidationMessage().isEmpty(),"No validation message");
    }
}
