package tests.shoppingcart;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.dataProvider.Provider;
import qa.extentreportsmanager.ExtentReportsManager;
import qa.helpers.ShoppingCartActions;
import qa.pageobject.shoppingcart.ShoppingCart;
import qa.records.ProductData;
import qa.urls.URLs;
import qa.utils.Formatter;

import java.lang.reflect.InvocationTargetException;

public class ShoppingCartQuantityFieldTest extends BaseTest {

    private ShoppingCart shoppingCart;

    @BeforeMethod
    public void create() throws InvocationTargetException, IllegalAccessException {

        goToPage(URLs.ELIZABETH_KNIT_PRODUCT_PAGE.getName());
        ShoppingCartActions.addToCart(getPage());

        shoppingCart = new ShoppingCart(getPage());
    }

    private void setQuantity(String quantity) {

        shoppingCart.getTable().getQuantityField().clickQuantityField();
        shoppingCart.getTable().getQuantityField().setQuantity(quantity);
        shoppingCart.getTable().clickUpdateCartButton();

    }

    @Test(dataProvider = "QF_min", dataProviderClass = Provider.class)
    public void min(ProductData data) {

        ExtentReportsManager.createTest("Setting the product quantity using \"" + data.quantity() + "\" as the minimum value",
                "Checking the system's behavior after entering the maximum value in the \"QTY\" field");

        String expectedSubtotal = Formatter.format(shoppingCart.getTable().getPrice(), data.quantity());
        setQuantity(data.quantity());

        Assert.assertEquals(shoppingCart.getTable().getSubtotal(), expectedSubtotal,
                "Incorrect system behavior after setting the product quantity to \"" + data.quantity() + "\"");
    }

    @Test(dataProvider = "QF_aboveMin", dataProviderClass = Provider.class)
    public void aboveMin(ProductData data) {

        String expectedSubtotal = Formatter.format(shoppingCart.getTable().getPrice(), data.quantity());
        setQuantity(data.quantity());

        Assert.assertEquals(shoppingCart.getTable().getSubtotal(), expectedSubtotal,
                "Incorrect system behavior after setting the product quantity to \"" + data.quantity() + "\"");
    }

    @Test
    public void zero() {

        ExtentReportsManager.createTest("Setting the product quantity using \"0\" as the maximum value",
                "checking whether the product will be removed from the shopping cart after setting the quantity to \"0\"");

        setQuantity("0");

        Assert.assertFalse(shoppingCart.getTable().isVisible(),
                "The product has not been removed form the shopping cart");
        Assert.assertEquals(shoppingCart.getPageTitleText(), "Shopping Cart is Empty",
                "Incorrect message content");
    }

    @Test(dataProvider = "QF_belowMaxSC", dataProviderClass = Provider.class)
    public void belowMax(ProductData data) {

        setQuantity(data.quantity());

        System.out.println("MSG: " + shoppingCart.getTable().getErrorMessageText());

        Assert.assertTrue(shoppingCart.isErrorMessageVisible(),
                "No message was displayed about the lack of the requested quantity of product");
        Assert.assertTrue(shoppingCart.getErrorMessageText().contains(data.message()),
                "Incorrect message content");
        Assert.assertTrue(shoppingCart.getTable().isErrorMessageVisible(),
                "No error message was displayed in the shopping cart table");
        Assert.assertTrue(shoppingCart.getTable().getErrorMessageText().contains(data.message()),
                "Incorrect error message content");
    }

    @Test(dataProvider = "QF_maxSC", dataProviderClass = Provider.class)
    public void max(ProductData data) {

        ExtentReportsManager.createTest("Setting the product quantity using \"" + data.quantity() + "\" as the maximum value",
                "Checking the system's behavior after entering the maximum value in the \"QTY\" field");

        setQuantity(data.quantity());

        Assert.assertTrue(shoppingCart.getTable().isErrorMessageVisible(),
                "No message was displayed about the lack of the requested quantity of product");
        Assert.assertTrue(shoppingCart.getTable().getErrorMessageText().contains(data.message()),
                "Incorrect message content");
        Assert.assertTrue(shoppingCart.getTable().isErrorMessageVisible(),
                "No error message was displayed in the shopping cart table");
        Assert.assertTrue(shoppingCart.getTable().getErrorMessageText().contains(data.message()),
                "Incorrect error message content");
    }

    @Test(dataProvider = "QF_aboveMaxSC", dataProviderClass = Provider.class)
    public void aboveMax(ProductData data) {

        ExtentReportsManager.createTest("Setting the product quantity using \"" + data.quantity() + "\" as too large value",
                "Checking the system's behavior after entering too large value in the \"QTY\" field");

        setQuantity(data.quantity());

        Assert.assertTrue(shoppingCart.getTable().isErrorMessageVisible(),
                "The message about too large value has not been displayed");
        Assert.assertEquals(shoppingCart.getTable().getErrorMessageText(), data.message(),
                "Incorrect message content");
    }

    @Test(dataProvider = "QF_negativeSC", dataProviderClass = Provider.class)
    public void negative(ProductData data) {

        ExtentReportsManager.createTest("Setting the product quantity using \"" + data.quantity() + "\" as the negative number",
                "Checking the system's behavior after entering the negative number in the \"QTY\" field");

        setQuantity(data.quantity());

        Assert.assertFalse(shoppingCart.getTable().getQuantityField().getValidationMessage().isEmpty(),
                "No validation message");
        Assert.assertEquals(shoppingCart.getTable().getQuantityField().getValidationMessage(), data.validationMessage(),
                "Incorrect validation message content");
    }

    @Test(dataProvider = "QF_floatingPoint", dataProviderClass = Provider.class)
    public void floatingPoint(ProductData data) {

        ExtentReportsManager.createTest("Setting the product quantity using \"" + data.quantity() + "\" as the floating point",
                "Checking the system's behavior after entering the floating point in the \"QTY\" field");

        setQuantity(data.quantity());

        Assert.assertFalse(shoppingCart.getTable().getQuantityField().getValidationMessage().isEmpty(),
                "No validation message");
        Assert.assertEquals(shoppingCart.getTable().getQuantityField().getValidationMessage(), data.validationMessage(),
                "Incorrect validation message content");
    }

    @Test(dataProvider = "QF_notANumber", dataProviderClass = Provider.class)
    public void notANumber(ProductData data) {

        ExtentReportsManager.createTest("Setting the product quantity using \"" + data.quantity() + "\" as the value which is not a number",
                "Checking the system's behavior after entering the value which is not a number in the \"QTY\" field");

        setQuantity(data.quantity());

        Assert.assertFalse(shoppingCart.getTable().getQuantityField().getValidationMessage().isEmpty(),
                "No validation message");
        Assert.assertEquals(shoppingCart.getTable().getQuantityField().getValidationMessage(), data.validationMessage(),
                "Incorrect validation message content");
    }
}

