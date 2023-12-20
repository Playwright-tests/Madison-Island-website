package tests.productpage;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.dataProvider.Provider;
import qa.enums.ProductShopMethods;
import qa.extentreportsmanager.ExtentReportsManager;
import qa.helpers.ProductShopHandler;
import qa.pageobject.productpage.ProductPage;
import qa.records.ProductData;
import qa.enums.URLs;
import java.lang.reflect.InvocationTargetException;

public class ProductPageQuantityFieldTest extends BaseTest {

    private ProductPage productPage;

    @BeforeMethod
    public void create() {

        productPage = new ProductPage(getPage());
    }

    private void fill(ProductData data) throws InvocationTargetException, IllegalAccessException {

        goToPage(data.getUrl());

        productPage.setProductShop(ProductShopHandler.set(getPage(), data, ProductShopMethods.ALL));
        productPage.getProductShop().clickAddToCartButton();
    }
    @Test(dataProvider = "QF_min", dataProviderClass = Provider.class)
    public void min(ProductData data) throws InvocationTargetException, IllegalAccessException {

        ExtentReportsManager.createTest("Setting the product quantity using \"" + data.getQuantity() + "\" as the minimum value",
                "Checking the system's behavior after entering the maximum value in the \"QTY\" field");

        fill(data);

        Assert.assertEquals(getPage().url(), URLs.SHOPPING_CART.getName(),
                "The product has not been added to the shopping cart");
    }

    @Test(dataProvider = "QF_aboveMin", dataProviderClass = Provider.class)
    public void aboveMin(ProductData data) throws InvocationTargetException, IllegalAccessException {

        ExtentReportsManager.createTest("Setting the product quantity using \"" + data.getQuantity() + "\" as the above minimum value",
                "Checking the system's behavior after entering the maximum value in the \"QTY\" field");

        fill(data);

        Assert.assertEquals(getPage().url(), URLs.SHOPPING_CART.getName(),
                "The product has not been added to the shopping cart");
    }

    @Test(dataProvider = "QF_belowMax", dataProviderClass = Provider.class)
    public void belowMax(ProductData data) throws InvocationTargetException, IllegalAccessException {

        ExtentReportsManager.createTest("Setting the product quantity using \"" + data.getQuantity() + "\" as the below maximum value",
                "Checking the system's behavior after entering the maximum value in the \"QTY\" field");

        fill(data);

        Assert.assertTrue(productPage.getErrorMessageLocator().isVisible(),
                "No error message");
        Assert.assertTrue(productPage.getErrorMessage().contains(data.getMessage()),
                "Incorrect error message content");
    }

    @Test(dataProvider = "QF_max", dataProviderClass = Provider.class)
    public void max(ProductData data) throws InvocationTargetException, IllegalAccessException {

        ExtentReportsManager.createTest("Setting the product quantity using \"" + data.getQuantity() + "\" as the maximum value",
                "Checking the system's behavior after entering the maximum value in the \"QTY\" field");

        fill(data);

        Assert.assertTrue(productPage.getErrorMessageLocator().isVisible(),
                "No error message");
        Assert.assertTrue(productPage.getErrorMessage().contains(data.getMessage()),
                "Incorrect error message content");
    }

    @Test(dataProvider = "QF_belowMin", dataProviderClass = Provider.class)
    public void belowMin(ProductData data) throws InvocationTargetException, IllegalAccessException {

        ExtentReportsManager.createTest("Setting the product quantity using \"" + data.getQuantity() + "\" as below minimum value",
                "Checking the system's behavior after entering too large value in the \"QTY\" field");

        fill(data);

        Assert.assertTrue(productPage.getErrorMessageLocator().isVisible(),
                "");
        Assert.assertTrue(productPage.getErrorMessage().contains(data.getMessage()));
    }

    @Test(dataProvider = "QF_aboveMax", dataProviderClass = Provider.class)
    public void aboveMax(ProductData data) throws InvocationTargetException, IllegalAccessException {

        ExtentReportsManager.createTest("Setting the product quantity using \"" + data.getQuantity() + "\" as too large value",
                "Checking the system's behavior after entering too large value in the \"QTY\" field");

        fill(data);

        Assert.assertTrue(productPage.getErrorMessageLocator().isVisible(),
                "No error message");
        Assert.assertTrue(productPage.getErrorMessage().contains(data.getMessage()),
                "Incorrect error message content");
    }

    @Test(dataProvider = "QF_floatingPoint", dataProviderClass = Provider.class)
    public void floatingPoint(ProductData data) throws InvocationTargetException, IllegalAccessException {

        ExtentReportsManager.createTest("Setting the product quantity using \"" + data.getQuantity() + "\" as the floating point",
                "Checking the system's behavior after entering the floating point in the \"QTY\" field");

        fill(data);

        Assert.assertNotEquals(getPage().url(), URLs.SHOPPING_CART.getName(),
                "The product has been added to the shopping cart");
        Assert.assertFalse(productPage.getProductShop().getQuantityValidationMessage().isEmpty(),
                "No validation message");
        Assert.assertEquals(productPage.getProductShop().getQuantityValidationMessage(), data.getValidationMessage(),
                "Incorrect validation message");
    }

    @Test(dataProvider = "QF_notANumber", dataProviderClass = Provider.class)
    public void notANumber(ProductData data) throws InvocationTargetException, IllegalAccessException {

        ExtentReportsManager.createTest("Setting the product quantity using \"" + data.getQuantity() + "\" as the value which is not a number",
                "Checking the system's behavior after entering the value which is not a number in the \"QTY\" field");

        fill(data);

        Assert.assertNotEquals(getPage().url(), URLs.SHOPPING_CART.getName(),
                "The product has been added to the shopping cart");
        Assert.assertFalse(productPage.getProductShop().getQuantityValidationMessage().isEmpty(),
                "No validation message");
        Assert.assertEquals(productPage.getProductShop().getQuantityValidationMessage(), data.getValidationMessage(),
                "Incorrect validation message content");
    }
}
