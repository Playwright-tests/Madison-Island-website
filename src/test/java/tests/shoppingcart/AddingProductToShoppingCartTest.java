package tests.shoppingcart;

import org.testng.Assert;
import qa.dataProvider.Provider;
import qa.enums.ProductShopMethods;
import qa.enums.URLs;
import qa.extentreportsmanager.ExtentReportsManager;
import qa.helpers.ProductShopHandler;
import org.testng.annotations.Test;
import qa.pageobject.productpage.ProductShop;
import qa.pageobject.shoppingcart.ShoppingCart;
import qa.base.BaseTest;
import qa.records.ProductData;
import java.lang.reflect.InvocationTargetException;

public class AddingProductToShoppingCartTest extends BaseTest {

    private ProductShop productShop;

    private void fill(ProductData data, ProductShopMethods omitted) throws InvocationTargetException, IllegalAccessException {

        productShop = ProductShopHandler.set(getPage(), data, omitted);
    }

    private void checkCartContents(ProductData data) throws InvocationTargetException, IllegalAccessException {

        ShoppingCart shoppingCart = new ShoppingCart(getPage());
        fill(data, ProductShopMethods.ALL);

        String productName = productShop.getProductName();

        productShop.clickAddToCartButton();

        Assert.assertEquals(shoppingCart.getTable().getName(), productName, "Incorrect product name in the shopping cart");
        Assert.assertEquals(shoppingCart.getTable().getColor(), data.getColor(), "Incorrect product color in the shopping cart");
        Assert.assertEquals(shoppingCart.getTable().getSize(), data.getSize(), "Incorrect product size in the shopping cart");
        Assert.assertEquals(shoppingCart.getTable().getQuantityField().getQuantity(), data.getQuantity(), "Incorrect amount of product");
    }

    @Test(dataProvider = "correctProductData", dataProviderClass = Provider.class)
    public void correct(ProductData data) throws InvocationTargetException, IllegalAccessException {

        ExtentReportsManager.createTest("Correct product features",
                "Checking whether a product with the appropriate parameters has been added to the cart");

        getPage().navigate(data.getUrl());
        checkCartContents(data);
    }

    @Test(dataProvider = "correctProductData", dataProviderClass = Provider.class)
    public void colorNotSelected(ProductData data) throws InvocationTargetException, IllegalAccessException {

        ExtentReportsManager.createTest("Unselected product color",
                "Checking whether a message about an unselected product color has appeared");

        goToPage(data.getUrl());
        fill(data, ProductShopMethods.SET_COLOR);
        productShop.clickAddToCartButton();

        Assert.assertTrue(productShop.getRequiredColorMessageLocator().isVisible(),
                "The message about unselected product color has not been displayed");
        Assert.assertEquals(productShop.getRequiredColorMessage(), data.getMessage(),
                "Incorrect message content");
    }

    @Test(dataProvider = "correctProductData", dataProviderClass = Provider.class)
    public void sizeNotSelected(ProductData data) throws InvocationTargetException, IllegalAccessException {

        ExtentReportsManager.createTest("Unselected product size",
                "Checking whether a message about an unselected product size has appeared");

        goToPage(data.getUrl());
        fill(data, ProductShopMethods.SET_SIZE);
        productShop.clickAddToCartButton();

        Assert.assertTrue(productShop.getRequiredSizeMessageLocator().isVisible(),
                "The message about unselected product size has not been displayed");
        Assert.assertEquals(productShop.getRequiredColorMessage(), data.getMessage(),
                "Incorrect message content");
    }

    @Test(dataProvider = "QF_blank", dataProviderClass = Provider.class)
    public void blankQuantityField(ProductData data) throws InvocationTargetException, IllegalAccessException {

        ExtentReportsManager.createTest("Blank \"Quantity\" field",
                "Checking the system's behavior when the \"Quantity\" field is blank");

        goToPage(data.getUrl());
        fill(data, ProductShopMethods.ALL);
        productShop.clickAddToCartButton();

        Assert.assertNotEquals(getPage().url(), URLs.SHOPPING_CART.getName(),
                "The message about about blank \"Quantity\" field has not been displayed, the system has been opened the shopping cart page");
    }
}
