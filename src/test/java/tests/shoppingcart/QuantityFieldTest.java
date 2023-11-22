package tests.shoppingcart;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.dataProvider.Provider;
import qa.extentreportsmanager.ExtentReportsManager;
import qa.pageobject.components.MainMenu;
import qa.pageobject.components.ProductThumbnail;
import qa.pageobject.productpage.ProductPage;
import qa.pageobject.productpage.ProductShop;
import qa.pageobject.shoppingcart.ShoppingCart;

public class QuantityFieldTest extends BaseTest {

    private ShoppingCart shoppingCart;

    @BeforeMethod
    public void create() {

        shoppingCart = new ShoppingCart(getPage());

        MainMenu mainMenu = new MainMenu(getPage());

        mainMenu.hoverParent("Women");
        mainMenu.clickItem("Pants & Denim");

        ProductThumbnail productThumbnail = new ProductThumbnail(getPage(), "TriBeCa Skinny Jean");
        productThumbnail.clickViewDetailsButton();

        ProductPage productPage = new ProductPage(getPage());
        productPage.setProductShop(new ProductShop(getPage()));
        productPage.getProductShop()
                .setColor("Black")
                .setSize("30")
                .clickAddToCartButton();
    }

    private String getSubtotal(double price, String quantity) {

        return "$" + String.format("%.2f", price * Integer.parseInt(quantity)).replace(",", ".");
    }

    private void setQuantityField(String quantity) {

        shoppingCart.getTable().getQuantityCell().clickQuantityField();
        shoppingCart.getTable().getQuantityCell().setQuantity(quantity);
        shoppingCart.getTable().getQuantityCell().clickUpdateButton();
    }

    private void check() {

        Assert.assertNotNull(shoppingCart.getTable().getQuantityCell().getValidationMessage(),
                "No message about incorrect value in the \"Qty\" field");
        Assert.assertEquals(shoppingCart.getTable().getQuantityCell().getValidationMessage(), "Podaj wartość w wymaganym formacie.",
                "Incorrect message content");
    }

    @Test
    @Parameters({"minValue"})
    public void minValue(String value) {

        ExtentReportsManager.createTest("Setting the product quantity using \"" + value + "\" as the minimum value",
                "Checking the system's behavior after entering the maximum value in the \"QTY\" field");

        setQuantityField(value);

        Assert.assertEquals(shoppingCart.getTable().getSubtotal(), getSubtotal(shoppingCart.getTable().getPrice(), value),
                "Incorrect system behavior after setting the product quantity to \"" + value + "\"");
    }

    @Test
    public void zeroValue() {

        ExtentReportsManager.createTest("Setting the product quantity using \"0\" as the maximum value",
                "checking whether the product will be removed from the shopping cart after setting the quantity to \"0\"");

        setQuantityField("0");

        Assert.assertFalse(shoppingCart.getTable().isVisible(),
                "The product has not been removed form the shopping cart");
        Assert.assertEquals(shoppingCart.getPageTitleText(), "Shopping Cart is Empty",
                "Incorrect message content");
    }

    @Test
    @Parameters({"maxValue"})
    public void maxValue(String value) {

        ExtentReportsManager.createTest("Setting the product quantity using \"" + value + "\" as the maximum value",
                "Checking the system's behavior after entering the maximum value in the \"QTY\" field");

        setQuantityField("1000");

        Assert.assertTrue(shoppingCart.getTable().isQuantityErrorMessageVisible(),
                "No message was displayed about the lack of the requested quantity of product");

        Assert.assertTrue(shoppingCart.getTable().getQuantityErrorMessageText().contains("* The requested quantity for"));
    }

    @Test
    @Parameters({"negative"})
    public void negativeNumber(String value) {

        ExtentReportsManager.createTest("Setting the product quantity using \"" + value + "\" as the negative number",
                "Checking the system's behavior after entering the negative number in the \"QTY\" field");

        setQuantityField(value);

        check();
    }

    @Test
    @Parameters({"tooLarge"})
    public void tooLargeValue(String value) {

        ExtentReportsManager.createTest("Setting the product quantity using \"" + value + "\" as too large value",
                "Checking the system's behavior after entering too large value in the \"QTY\" field");

        setQuantityField(value);

        Assert.assertTrue(shoppingCart.getTable().isQuantityErrorMessageVisible(),
                "The message about too large value has not been displayed");

        Assert.assertEquals(shoppingCart.getTable().getQuantityErrorMessageText(), "The maximum quantity allowed for purchase is 10000.",
                "Incorrect message content");
    }

    @Test(dataProvider = "floatingPointNumber", dataProviderClass = Provider.class)
    public void floatingPoint(String value) {

        ExtentReportsManager.createTest("Setting the product quantity using \"" + value + "\" as the floating point",
                "Checking the system's behavior after entering the floating point in the \"QTY\" field");

        setQuantityField(value);

        check();
    }

    @Test(dataProvider = "notANumber", dataProviderClass = Provider.class)
    public void notANumber(String value) {

        ExtentReportsManager.createTest("Setting the product quantity using \"" + value + "\" as the value which is not a number",
                "Checking the system's behavior after entering the value which is not a number in the \"QTY\" field");

        setQuantityField(value);

        check();
    }
}

