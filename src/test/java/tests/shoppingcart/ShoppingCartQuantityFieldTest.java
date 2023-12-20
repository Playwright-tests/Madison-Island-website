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
import qa.enums.URLs;
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

        ExtentReportsManager.createTest("Setting the product quantity using \"" + data.getQuantity() + "\" as the minimum value",
                "Checking the system's behavior after entering the maximum value in the \"QTY\" field");

        String expectedSubtotal = Formatter.format(shoppingCart.getTable().getPrice(), data.getQuantity());
        setQuantity(data.getQuantity());

        Assert.assertEquals(shoppingCart.getTable().getSubtotal(), expectedSubtotal,
                "Incorrect system behavior after setting the product quantity to \"" + data.getQuantity() + "\"");
    }

    @Test(dataProvider = "QF_aboveMin", dataProviderClass = Provider.class)
    public void aboveMin(ProductData data) {

        ExtentReportsManager.createTest("Setting the product quantity using \"" + data.getQuantity() + "\" as the above minimum value",
                "Checking the system's behavior after entering the maximum value in the \"QTY\" field");

        String expectedSubtotal = Formatter.format(shoppingCart.getTable().getPrice(), data.getQuantity());
        setQuantity(data.getQuantity());

        Assert.assertEquals(shoppingCart.getTable().getSubtotal(), expectedSubtotal,
                "Incorrect system behavior after setting the product quantity to \"" + data.getQuantity() + "\"");
    }

    @Test
    public void zero() {

        ExtentReportsManager.createTest("Setting the product quantity using \"0\" as the maximum value",
                "Checking whether the product will be removed from the shopping cart after setting the quantity to \"0\"");

        setQuantity("0");

        Assert.assertFalse(shoppingCart.getTable().isVisible(),
                "The product has not been removed form the shopping cart");
        Assert.assertEquals(shoppingCart.getPageTitleText(), "Shopping Cart is Empty",
                "Incorrect message content");
    }

    @Test(dataProvider = "QF_belowMaxSC", dataProviderClass = Provider.class)
    public void belowMax(ProductData data) {

        ExtentReportsManager.createTest("Setting the product quantity using \"" + data.getQuantity() + "\" as the below maximum value",
                "Checking the system's behavior after entering the maximum value in the \"QTY\" field");

        setQuantity(data.getQuantity());

        System.out.println("MSG: " + shoppingCart.getTable().getErrorMessageText());

        Assert.assertTrue(shoppingCart.getErrorMessageLocator().isVisible(),
                "No message was displayed about the lack of the requested quantity of product");
        Assert.assertTrue(shoppingCart.getErrorMessageText().contains(data.getMessage()),
                "Incorrect message content");
        Assert.assertTrue(shoppingCart.getTable().getErrorMessageLocator().isVisible(),
                "No error message was displayed in the shopping cart table");
        Assert.assertTrue(shoppingCart.getTable().getErrorMessageText().contains(data.getMessage()),
                "Incorrect error message content");
    }

    @Test(dataProvider = "QF_maxSC", dataProviderClass = Provider.class)
    public void max(ProductData data) {

        ExtentReportsManager.createTest("Setting the product quantity using \"" + data.getQuantity() + "\" as the maximum value",
                "Checking the system's behavior after entering the maximum value in the \"QTY\" field");

        setQuantity(data.getQuantity());

        Assert.assertTrue(shoppingCart.getTable().getErrorMessageLocator().isVisible(),
                "No message was displayed about the lack of the requested quantity of product");
        Assert.assertTrue(shoppingCart.getTable().getErrorMessageText().contains(data.getMessage()),
                "Incorrect message content");
        Assert.assertTrue(shoppingCart.getTable().getErrorMessageLocator().isVisible(),
                "No error message was displayed in the shopping cart table");
        Assert.assertTrue(shoppingCart.getTable().getErrorMessageText().contains(data.getMessage()),
                "Incorrect error message content");
    }

    @Test(dataProvider = "QF_aboveMaxSC", dataProviderClass = Provider.class)
    public void aboveMax(ProductData data) {

        ExtentReportsManager.createTest("Setting the product quantity using \"" + data.getQuantity() + "\" as too large value",
                "Checking the system's behavior after entering too large value in the \"QTY\" field");

        setQuantity(data.getQuantity());

        Assert.assertTrue(shoppingCart.getTable().getErrorMessageLocator().isVisible(),
                "The message about too large value has not been displayed");
        Assert.assertTrue(shoppingCart.getTable().getErrorMessageText().contains(data.getMessage()),
                "Incorrect message content");
    }

    @Test(dataProvider = "QF_negativeSC", dataProviderClass = Provider.class)
    public void negative(ProductData data) {

        ExtentReportsManager.createTest("Setting the product quantity using \"" + data.getQuantity() + "\" as the negative number",
                "Checking the system's behavior after entering the negative number in the \"QTY\" field");

        setQuantity(data.getQuantity());

        Assert.assertFalse(shoppingCart.getTable().getQuantityField().getValidationMessage().isEmpty(),
                "No validation message");
        Assert.assertEquals(shoppingCart.getTable().getQuantityField().getValidationMessage(), data.getValidationMessage(),
                "Incorrect validation message content");
    }

    @Test(dataProvider = "QF_floatingPoint", dataProviderClass = Provider.class)
    public void floatingPoint(ProductData data) {

        ExtentReportsManager.createTest("Setting the product quantity using \"" + data.getQuantity() + "\" as the floating point",
                "Checking the system's behavior after entering the floating point in the \"QTY\" field");

        setQuantity(data.getQuantity());

        Assert.assertFalse(shoppingCart.getTable().getQuantityField().getValidationMessage().isEmpty(),
                "No validation message");
        Assert.assertEquals(shoppingCart.getTable().getQuantityField().getValidationMessage(), data.getValidationMessage(),
                "Incorrect validation message content");
    }

    @Test(dataProvider = "QF_notANumber", dataProviderClass = Provider.class)
    public void notANumber(ProductData data) {

        ExtentReportsManager.createTest("Setting the product quantity using \"" + data.getQuantity() + "\" as the value which is not a number",
                "Checking the system's behavior after entering the value which is not a number in the \"QTY\" field");

        setQuantity(data.getQuantity());

        Assert.assertFalse(shoppingCart.getTable().getQuantityField().getValidationMessage().isEmpty(),
                "No validation message");
        Assert.assertEquals(shoppingCart.getTable().getQuantityField().getValidationMessage(), data.getValidationMessage(),
                "Incorrect validation message content");
    }
}

