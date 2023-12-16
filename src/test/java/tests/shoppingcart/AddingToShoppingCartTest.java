package tests.shoppingcart;

import org.testng.Assert;
import qa.dataProvider.Provider;
import qa.enums.ProductShopMethods;
import qa.extentreportsmanager.ExtentReportsManager;
import qa.helpers.ProductShopHandler;
import org.testng.annotations.Test;
import qa.pageobject.productpage.ProductShop;
import qa.pageobject.shoppingcart.ShoppingCart;
import qa.base.BaseTest;
import qa.records.ProductData;
import java.lang.reflect.InvocationTargetException;

public class AddingToShoppingCartTest extends BaseTest {

    private ProductShop fill(ProductData data) throws InvocationTargetException, IllegalAccessException {

        return ProductShopHandler.set(getPage(), data, ProductShopMethods.ALL);
    }

    private void checkCartContents(ProductData data) throws InvocationTargetException, IllegalAccessException {

        ShoppingCart shoppingCart = new ShoppingCart(getPage());
        ProductShop productShop = fill(data);

        String productName = productShop.getProductName();

        productShop.clickAddToCartButton();

        Assert.assertEquals(shoppingCart.getTable().getName(), productName, "Incorrect product name in the shopping cart");
        Assert.assertEquals(shoppingCart.getTable().getColor(), data.color(), "Incorrect product color in the shopping cart");
        Assert.assertEquals(shoppingCart.getTable().getSize(), data.size(), "Incorrect product size in the shopping cart");
        Assert.assertEquals(shoppingCart.getTable().getQuantityCell().getQuantity(), data.quantity(), "Incorrect amount of product");
    }

    @Test(dataProvider = "correctProductData", dataProviderClass = Provider.class)
    public void correct(ProductData data) throws InvocationTargetException, IllegalAccessException {

        ExtentReportsManager.createTest("Correct product features",
                "Checking whether a product with the appropriate parameters has been added to the cart");

        getPage().navigate(data.url());
        checkCartContents(data);
    }

    @Test(dataProvider = "correctProductData", dataProviderClass = Provider.class)
    public void colorNotSelected(ProductData data) throws InvocationTargetException, IllegalAccessException {

        ExtentReportsManager.createTest("Unselected product color",
                "Checking whether a message about an unselected product color has appeared");

        goToPage(data.url());
        ProductShop productShop = ProductShopHandler.set(getPage(), data, ProductShopMethods.SET_COLOR);
        productShop.clickAddToCartButton();

        Assert.assertTrue(productShop.isRequiredColorMessageVisible(),
                "The message about unselected product color has not been displayed");
    }

    @Test(dataProvider = "correctProductData", dataProviderClass = Provider.class)
    public void sizeNotSelected(ProductData data) throws InvocationTargetException, IllegalAccessException {

        ExtentReportsManager.createTest("Unselected product size",
                "Checking whether a message about an unselected product size has appeared");

        goToPage(data.url());
        ProductShop productShop = ProductShopHandler.set(getPage(), data, ProductShopMethods.SET_SIZE);
        productShop.clickAddToCartButton();

        Assert.assertTrue(productShop.isRequiredSizeMessageVisible(),
                "The message about unselected product size has not been displayed");
    }

    @Test(dataProvider = "correctProductData", dataProviderClass = Provider.class)
    public void colorAndSizeNotSelected(ProductData data) {

        //ExtentReportsManager.createTest("Unselected product color and size",
          //      "Checking whether a message about an unselected product color and size appeared");

        goToPage(data.url());
        ProductShop productShop = new ProductShop(getPage());
        productShop.setQuantity(data.quantity());
        productShop.clickAddToCartButton();

        Assert.assertTrue(productShop.isRequiredColorMessageVisible());
        Assert.assertTrue(productShop.isRequiredSizeMessageVisible());
    }

    @Test(dataProvider = "incorrectQuantityValue", dataProviderClass = Provider.class)
    public void incorrectQuantityValue(ProductData data) throws InvocationTargetException, IllegalAccessException {

        ExtentReportsManager.createTest("Incorrect quantity value",
                "Checking the system's behavior after entering an incorrect value in the \"Quantity\" field.");

        goToPage(data.url());
        ProductShop productShop = fill(data);
        productShop.clickAddToCartButton();

        Assert.assertNotEquals(getPage().url(), "http://demo-store.seleniumacademy.com/checkout/cart/",
                "No message about an incorrect quantity of product, the system has been opened the shopping cart page");
    }

    @Test(dataProvider = "incorrectQuantityFormat", dataProviderClass = Provider.class)
    public void incorrectQuantityFormat(ProductData data) throws InvocationTargetException, IllegalAccessException {

        ExtentReportsManager.createTest("Incorrect product quantity value format",
                "Checking the system's behavior after entering an incorrect value format in the \"Quantity\" field.");

        goToPage(data.url());
        ProductShop productShop = fill(data);
        productShop.clickAddToCartButton();

        Assert.assertNotEquals(getPage().url(), "http://demo-store.seleniumacademy.com/checkout/cart/",
                "The message about an incorrect quantity value format has not been displayed, the system has been opened the shopping cart page");
    }

    @Test(dataProvider = "blankQuantityField", dataProviderClass = Provider.class)
    public void blankQuantityField(ProductData data) throws InvocationTargetException, IllegalAccessException {

        ExtentReportsManager.createTest("Blank \"Quantity\" field",
                "Checking the system's behavior when the \"Quantity\" field is blank");

        goToPage(data.url());
        ProductShop productShop = fill(data);
        productShop.clickAddToCartButton();

        Assert.assertNotEquals(getPage().url(), "http://demo-store.seleniumacademy.com/checkout/cart/",
                "The message about about blank \"Quantity\" field has not been displayed, the system has been opened the shopping cart page");
    }
}
