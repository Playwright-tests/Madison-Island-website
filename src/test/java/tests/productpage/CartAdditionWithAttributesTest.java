package tests.productpage;

import org.testng.Assert;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.dataProviders.ProductDataProviders;
import qa.enums.ProductShopMethods;
import qa.enums.URLs;
import qa.helpers.ProductShopHandler;
import qa.pageobject.productpage.ProductShop;
import qa.records.ProductData;
import qa.support.dataprovidernames.DataProviderNames;

import java.lang.reflect.InvocationTargetException;

public class CartAdditionWithAttributesTest extends BaseTest {

    private ProductShop productShop;

    private void fill(ProductData data, ProductShopMethods excluded) throws InvocationTargetException, IllegalAccessException {

        productShop = ProductShopHandler.set(getPage(), data, excluded);
        productShop.clickAddToCartButton();
    }

    @Test(dataProvider = DataProviderNames.PRODUCT_ATTRIBUTES, dataProviderClass = ProductDataProviders.class)
    public void allAttributesSelected(ProductData data) throws InvocationTargetException, IllegalAccessException {

        getPage().navigate(data.getUrl());
        fill(data, ProductShopMethods.ALL);

        Assert.assertEquals(getPage().url(), URLs.SHOPPING_CART.getName(),
                "The product has not been added to the shopping cart");
    }

    @Test(dataProvider = DataProviderNames.PRODUCT_ATTRIBUTES, dataProviderClass = ProductDataProviders.class)
    public void colorNotSelected(ProductData data) throws InvocationTargetException, IllegalAccessException {

        goToPage(data.getUrl());
        fill(data, ProductShopMethods.SET_COLOR);
        productShop.clickAddToCartButton();

        Assert.assertNotEquals(getPage().url(), URLs.SHOPPING_CART.getName(),
                "The product has not been added to the shopping cart");
        Assert.assertTrue(productShop.getRequiredColorMessageLocator().isVisible(),
                "The message about unselected product color has not been displayed");
        Assert.assertEquals(productShop.getRequiredColorMessage(), "This is a required field.",
                "Incorrect message content");
    }

    @Test(dataProvider = DataProviderNames.PRODUCT_ATTRIBUTES, dataProviderClass = ProductDataProviders.class)
    public void sizeNotSelected(ProductData data) throws InvocationTargetException, IllegalAccessException {

        goToPage(data.getUrl());
        fill(data, ProductShopMethods.SET_SIZE);
        productShop.clickAddToCartButton();

        Assert.assertNotEquals(getPage().url(), URLs.SHOPPING_CART.getName(),
                "The product has not been added to the shopping cart");
        Assert.assertTrue(productShop.getRequiredSizeMessageLocator().isVisible(),
                "The message about unselected product size has not been displayed");
        Assert.assertEquals(productShop.getRequiredSizeMessage(), "This is a required field.",
                "Incorrect message content");
    }
}
