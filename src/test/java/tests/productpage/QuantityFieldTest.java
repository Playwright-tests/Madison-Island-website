package tests.productpage;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.dataProviders.ProductPageQuantityDataProviders;
import qa.enums.URLs;
import qa.helpers.ShoppingCartActions;
import qa.pageobject.productpage.ProductPage;
import qa.records.QuantityData;
import qa.support.dataprovidernames.DataProviderNames;

public class QuantityFieldTest extends BaseTest {

    private ProductPage productPage;

    @BeforeMethod
    public void create() {

        goToPage(URLs.ELIZABETH_KNIT_PRODUCT_PAGE.getName());
        productPage = new ProductPage(getPage());
        productPage.setProductShop(ShoppingCartActions.addToCart(getPage()));
    }

    private void actions(QuantityData data) {

        productPage.getProductShop().setQuantity(data.getQuantity());
        productPage.getProductShop().clickAddToCartButton();
    }

    @Test(dataProvider = DataProviderNames.BELOW_MIN, dataProviderClass = ProductPageQuantityDataProviders.class)
    public void belowMin(QuantityData data) {

        actions(data);

        Assert.assertTrue(productPage.getErrorMessageLocator().isVisible(),
                "");
        Assert.assertTrue(productPage.getErrorMessage().contains(data.getMessage()));
    }

    @Test(dataProvider = DataProviderNames.MIN, dataProviderClass = ProductPageQuantityDataProviders.class)
    public void min(QuantityData data)  {

        actions(data);

        Assert.assertEquals(getPage().url(), URLs.SHOPPING_CART.getName(),
                "The product has not been added to the shopping cart");
    }

    @Test(dataProvider = DataProviderNames.ABOVE_MIN, dataProviderClass = ProductPageQuantityDataProviders.class)
    public void aboveMin(QuantityData data) {

        actions(data);

        Assert.assertEquals(getPage().url(), URLs.SHOPPING_CART.getName(),
                "The product has not been added to the shopping cart");
    }

    @Test(dataProvider = DataProviderNames.BELOW_MAX, dataProviderClass = ProductPageQuantityDataProviders.class)
    public void belowMax(QuantityData data) {

        actions(data);

        Assert.assertTrue(productPage.getErrorMessageLocator().isVisible(),
                "No error message");
        Assert.assertTrue(productPage.getErrorMessage().contains(data.getMessage()),
                "Incorrect error message content");
    }

    @Test(dataProvider = DataProviderNames.MAX, dataProviderClass = ProductPageQuantityDataProviders.class)
    public void max(QuantityData data) {

        actions(data);

        Assert.assertTrue(productPage.getErrorMessageLocator().isVisible(),
                "No error message");
        Assert.assertTrue(productPage.getErrorMessage().contains(data.getMessage()),
                "Incorrect error message content");
    }

    @Test(dataProvider = DataProviderNames.ABOVE_MAX, dataProviderClass = ProductPageQuantityDataProviders.class)
    public void aboveMax(QuantityData data) {

        actions(data);

        Assert.assertTrue(productPage.getErrorMessageLocator().isVisible(),
                "No error message");
        Assert.assertTrue(productPage.getErrorMessage().contains(data.getMessage()),
                "Incorrect error message content");
    }

    @Test(dataProvider = DataProviderNames.FLOATING_POINT, dataProviderClass = ProductPageQuantityDataProviders.class)
    public void floatingPoint(QuantityData data) {

        actions(data);

        Assert.assertNotEquals(getPage().url(), URLs.SHOPPING_CART.getName(),
                "The product has been added to the shopping cart");
        Assert.assertFalse(productPage.getProductShop().getQuantityValidationMessage().isEmpty(),
                "No validation message");
    }

    @Test(dataProvider = DataProviderNames.NOT_NUMBER, dataProviderClass = ProductPageQuantityDataProviders.class)
    public void notANumber(QuantityData data) {

        actions(data);

        Assert.assertNotEquals(getPage().url(), URLs.SHOPPING_CART.getName(),
                "The product has been added to the shopping cart");
        Assert.assertFalse(productPage.getProductShop().getQuantityValidationMessage().isEmpty(),
                "No validation message");
    }
}
