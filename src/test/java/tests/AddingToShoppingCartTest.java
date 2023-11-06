package tests;

import qa.dataProvider.Provider;
import qa.extentreportsmanager.ExtentReportsManager;
import qa.factories.ProductShopFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.pageobject.productpage.ProductPage;
import qa.pageobject.components.MainMenu;
import qa.pageobject.components.ProductThumbnail;
import qa.pageobject.productpage.ProductShop;
import qa.pageobject.shoppingcart.ShoppingCart;
import qa.base.BaseTest;
import qa.utils.ProductOptions;

import static qa.playwright.PlaywrightLauncher.*;

public class AddingToShoppingCartTest extends BaseTest {

    private ProductPage productPage;

    @BeforeMethod
    public void create() {

        productPage = new ProductPage(getPage());
    }

    private void openProductPage(String category, String type, String name) {

        MainMenu mainMenu = new MainMenu(getPage());
        ProductThumbnail productThumbnail = new ProductThumbnail(getPage(), name);

        mainMenu.hoverParent(category);
        mainMenu.clickItem(type);
        productThumbnail.clickViewDetailsButton();
    }

    private void setFields(ProductShop productShop) {

        productPage.setProductShop(productShop);
        productPage.getProductShop().clickAddToCartButton();
    }

    private void checkCartContents(ProductOptions options) {

        ShoppingCart shoppingCart = new ShoppingCart(getPage());

        Assert.assertEquals(shoppingCart.getTable().getName(), options.getName(), "Incorrect product name in the shopping cart");
        Assert.assertEquals(shoppingCart.getTable().getColor(), options.getColor(), "Incorrect product color in the shopping cart");
        Assert.assertEquals(shoppingCart.getTable().getSize(), options.getSize(), "Incorrect product size in the shopping cart");
        Assert.assertEquals(shoppingCart.getTable().getQuantityCell().getQuantity(), options.getQuantity(), "Incorrect amount of product");
    }

    @Test(dataProvider = "correctProductData", dataProviderClass = Provider.class)
    public void correct(ProductOptions options) {

        ExtentReportsManager.createTest("Correct product features",
                "Checking whether a product with the appropriate parameters has been added to the cart");

        openProductPage(options.getCategory(), options.getProductType(), options.getName());
        setFields(ProductShopFactory.withAllFields(getPage(), options));

        Assert.assertEquals(getPage().url(), "http://demo-store.seleniumacademy.com/checkout/cart/",
                "The shopping cart page has not been opened");

        checkCartContents(options);
    }

    @Test(dataProvider = "correctProductData", dataProviderClass = Provider.class)
    public void colorNotSelected(ProductOptions options) {

        ExtentReportsManager.createTest("Unselected product color",
                "Checking whether a message about an unselected product color has appeared");

        openProductPage(options.getCategory(), options.getProductType(), options.getName());
        setFields(ProductShopFactory.withoutColor(getPage(), options));

        Assert.assertNotEquals(getPage().url(), "http://demo-store.seleniumacademy.com/checkout/cart/");
        Assert.assertTrue(productPage.getProductShop().isRequiredColorMessageVisible(),
                "The message about unselected product color has not been displayed");
    }

    @Test(dataProvider = "correctProductData", dataProviderClass = Provider.class)
    public void sizeNotSelected(ProductOptions options) {

        ExtentReportsManager.createTest("Unselected product size",
                "Checking whether a message about an unselected product size has appeared");

        openProductPage(options.getCategory(), options.getProductType(), options.getName());
        setFields(ProductShopFactory.withoutSize(getPage(), options));

        Assert.assertNotEquals(getPage().url(), "http://demo-store.seleniumacademy.com/checkout/cart/");
        Assert.assertTrue(productPage.getProductShop().isRequiredSizeMessageVisible(),
                "The message about unselected product size has not been displayed");
    }

    @Test(dataProvider = "correctProductData", dataProviderClass = Provider.class)
    public void colorAndSizeNotSelected(ProductOptions options) {

        ExtentReportsManager.createTest("Unselected product color and size",
                "Checking whether a message about an unselected product color and size appeared");

        openProductPage(options.getCategory(), options.getProductType(), options.getName());
        setFields(ProductShopFactory.withoutColorAndSize(getPage(), options));

        Assert.assertNotEquals(getPage().url(), "http://demo-store.seleniumacademy.com/checkout/cart/");
        Assert.assertTrue(productPage.getProductShop().isRequiredColorMessageVisible());
        Assert.assertTrue(productPage.getProductShop().isRequiredSizeMessageVisible());
    }

    @Test(dataProvider = "incorrectQuantityValue", dataProviderClass = Provider.class)
    public void incorrectQuantityValue(ProductOptions options) {

        ExtentReportsManager.createTest("Incorrect quantity value",
                "Checking the system's behavior after entering an incorrect value in the \"Quantity\" field.");

        openProductPage(options.getCategory(), options.getProductType(), options.getName());
        setFields(ProductShopFactory.withAllFields(getPage(), options));

        Assert.assertNotEquals(getPage().url(), "http://demo-store.seleniumacademy.com/checkout/cart/",
                "No message about an incorrect quantity of product, the system has been opened the shopping cart page");
    }

    @Test(dataProvider = "incorrectQuantityFormat", dataProviderClass = Provider.class)
    public void incorrectQuantityFormat(ProductOptions options) {

        ExtentReportsManager.createTest("Incorrect product quantity value format",
                "Checking the system's behavior after entering an incorrect value format in the \"Quantity\" field.");

        openProductPage(options.getCategory(), options.getProductType(), options.getName());
        setFields(ProductShopFactory.withAllFields(getPage(), options));

        Assert.assertNotEquals(getPage().url(), "http://demo-store.seleniumacademy.com/checkout/cart/",
                "No message about incorrect quantity value format has not been displayed, the system has been opened the shopping cart page");
    }

    @Test(dataProvider = "blankQuantityField", dataProviderClass = Provider.class)
    public void blankQuantityField(ProductOptions options) {

        ExtentReportsManager.createTest("Empty \"Quantity\" field",
                "Checking the system's behavior when the \"Quantity\" field is empty");

        openProductPage(options.getCategory(), options.getProductType(), options.getName());
        setFields(ProductShopFactory.withAllFields(getPage(), options));

        Assert.assertNotEquals(getPage().url(), "http://demo-store.seleniumacademy.com/checkout/cart/",
                "No message about about empty \"Quantity\" field has not been displayed, the system has been opened the shopping cart page");
    }
}
