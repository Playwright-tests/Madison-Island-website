package tests;

import dataProvider.Provider;
import factories.ProductShopFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject.productpage.ProductPage;
import pageobject.components.MainMenu;
import pageobject.components.ProductThumbnail;
import pageobject.productpage.ProductShop;
import pageobject.shoppingcart.ShoppingCart;
import qa.base.BaseTest;
import utils.ProductOptions;

import static playwright.PlaywrightLauncher.*;

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

        Assert.assertEquals(shoppingCart.getTable().getName(), options.getName());
        Assert.assertEquals(shoppingCart.getTable().getColor(), options.getColor());
        Assert.assertEquals(shoppingCart.getTable().getSize(), options.getSize());
        Assert.assertEquals(shoppingCart.getTable().getQuantityCell().getQuantity(), options.getQuantity());
    }

    @Test(dataProvider = "correctProductData", dataProviderClass = Provider.class)
    public void correct(ProductOptions options) {

        openProductPage(options.getCategory(), options.getProductType(), options.getName());
        setFields(ProductShopFactory.withAllFields(getPage(), options));

        Assert.assertEquals(getPage().url(), "http://demo-store.seleniumacademy.com/checkout/cart/");

        checkCartContents(options);
    }

    @Test(dataProvider = "correctProductData", dataProviderClass = Provider.class)
    public void colorNotSelected(ProductOptions options) {

        openProductPage(options.getCategory(), options.getProductType(), options.getName());
        setFields(ProductShopFactory.withoutColor(getPage(), options));

        Assert.assertNotEquals(getPage().url(), "http://demo-store.seleniumacademy.com/checkout/cart/");
        Assert.assertTrue(productPage.getProductShop().isRequiredColorMessageVisible());
    }

    @Test(dataProvider = "correctProductData", dataProviderClass = Provider.class)
    public void sizeNotSelected(ProductOptions options) {

        openProductPage(options.getCategory(), options.getProductType(), options.getName());
        setFields(ProductShopFactory.withoutSize(getPage(), options));

        Assert.assertNotEquals(getPage().url(), "http://demo-store.seleniumacademy.com/checkout/cart/");
        Assert.assertTrue(productPage.getProductShop().isRequiredSizeMessageVisible());
    }

    @Test(dataProvider = "correctProductData", dataProviderClass = Provider.class)
    public void colorAndSizeNotSelected(ProductOptions options) {

        openProductPage(options.getCategory(), options.getProductType(), options.getName());
        setFields(ProductShopFactory.withoutColorAndSize(getPage(), options));

        Assert.assertNotEquals(getPage().url(), "http://demo-store.seleniumacademy.com/checkout/cart/");
        Assert.assertTrue(productPage.getProductShop().isRequiredColorMessageVisible());
        Assert.assertTrue(productPage.getProductShop().isRequiredSizeMessageVisible());
    }

    @Test(dataProvider = "incorrectQuantityValue", dataProviderClass = Provider.class)
    public void incorrectQuantityValue(ProductOptions options) {

        openProductPage(options.getCategory(), options.getProductType(), options.getName());
        setFields(ProductShopFactory.withAllFields(getPage(), options));

        Assert.assertNotEquals(getPage().url(), "http://demo-store.seleniumacademy.com/checkout/cart/");
    }

    @Test(dataProvider = "incorrectQuantityFormat", dataProviderClass = Provider.class)
    public void incorrectQuantityFormat(ProductOptions options) {

        openProductPage(options.getCategory(), options.getProductType(), options.getName());
        setFields(ProductShopFactory.withAllFields(getPage(), options));

        Assert.assertNotEquals(getPage().url(), "http://demo-store.seleniumacademy.com/checkout/cart/");
    }

    @Test(dataProvider = "blankQuantityField", dataProviderClass = Provider.class)
    public void blankQuantityField(ProductOptions options) {

        openProductPage(options.getCategory(), options.getProductType(), options.getName());
        setFields(ProductShopFactory.withAllFields(getPage(), options));

        Assert.assertNotEquals(getPage().url(), "http://demo-store.seleniumacademy.com/checkout/cart/");
    }
}
