package tests.shoppingcart;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.dataProviders.QuantityFieldDataProviders;
import qa.enums.URLs;
import qa.helpers.ShoppingCartActions;
import qa.pageobject.shoppingcart.ShoppingCart;
import qa.records.QuantityData;
import qa.support.dataprovidernames.DataProviderNames;
import qa.utils.Formatter;

import java.lang.reflect.InvocationTargetException;

public class QuantityFieldTest extends BaseTest {

    private ShoppingCart shoppingCart;

    @BeforeMethod
    public void create() throws InvocationTargetException, IllegalAccessException {

        goToPage(URLs.ELIZABETH_KNIT_PRODUCT_PAGE.getName());
        ShoppingCartActions.addToCart(getPage()).clickAddToCartButton();

        shoppingCart = new ShoppingCart(getPage());
    }

    private void setQuantity(String quantity) {

        shoppingCart.getTable().getQuantityField().clickQuantityField();
        shoppingCart.getTable().getQuantityField().setQuantity(quantity);
        shoppingCart.getTable().clickUpdateCartButton();
    }

    @Test(dataProvider = DataProviderNames.MIN, dataProviderClass = QuantityFieldDataProviders.class)
    public void min(QuantityData data) {

        String expectedSubtotal = Formatter.format(shoppingCart.getTable().getPrice(), data.getQuantity());
        setQuantity(data.getQuantity());

        Assert.assertEquals(shoppingCart.getTable().getSubtotal(), expectedSubtotal,
                "Incorrect system behavior after setting the product quantity to \"" + data.getQuantity() + "\"");
    }

    @Test(dataProvider = DataProviderNames.ABOVE_MIN, dataProviderClass = QuantityFieldDataProviders.class)
    public void aboveMin(QuantityData data) {

        String expectedSubtotal = Formatter.format(shoppingCart.getTable().getPrice(), data.getQuantity());
        setQuantity(data.getQuantity());

        Assert.assertEquals(shoppingCart.getTable().getSubtotal(), expectedSubtotal,
                "Incorrect system behavior after setting the product quantity to \"" + data.getQuantity() + "\"");
    }

    @Test(dataProvider = DataProviderNames.BELOW_MAX, dataProviderClass = QuantityFieldDataProviders.class)
    public void belowMax(QuantityData data) {

        setQuantity(data.getQuantity());

        Assert.assertTrue(shoppingCart.getErrorMessageLocator().isVisible(),
                "No message was displayed about the lack of the requested quantity of product");
        Assert.assertTrue(shoppingCart.getErrorMessageText().contains(data.getMessage()),
                "Incorrect message content");
        Assert.assertTrue(shoppingCart.getTable().getErrorMessageLocator().isVisible(),
                "No error message was displayed in the shopping cart table");
        Assert.assertTrue(shoppingCart.getTable().getErrorMessageText().contains(data.getMessage()),
                "Incorrect error message content");
    }

    @Test(dataProvider = DataProviderNames.MAX, dataProviderClass = QuantityFieldDataProviders.class)
    public void max(QuantityData data) {

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

    @Test(dataProvider = DataProviderNames.ABOVE_MAX, dataProviderClass = QuantityFieldDataProviders.class)
    public void aboveMax(QuantityData data) {

        setQuantity(data.getQuantity());

        Assert.assertTrue(shoppingCart.getTable().getErrorMessageLocator().isVisible(),
                "The message about too large value has not been displayed");
        Assert.assertTrue(shoppingCart.getTable().getErrorMessageText().contains(data.getMessage()),
                "Incorrect message content");
    }

    @Test(dataProvider = DataProviderNames.NEGATIVE, dataProviderClass = QuantityFieldDataProviders.class)
    public void negative(QuantityData data) {

        setQuantity(data.getQuantity());

        Assert.assertFalse(shoppingCart.getTable().getQuantityField().getValidationMessage().isEmpty(),
                "No validation message");
    }

    @Test(dataProvider = DataProviderNames.FLOATING_POINT, dataProviderClass = QuantityFieldDataProviders.class)
    public void floatingPoint(QuantityData data) {

        setQuantity(data.getQuantity());

        Assert.assertFalse(shoppingCart.getTable().getQuantityField().getValidationMessage().isEmpty(),
                "No validation message");
    }

    @Test(dataProvider = DataProviderNames.NOT_NUMBER, dataProviderClass = QuantityFieldDataProviders.class)
    public void notNumber(QuantityData data) {

        setQuantity(data.getQuantity());

        Assert.assertFalse(shoppingCart.getTable().getQuantityField().getValidationMessage().isEmpty(),
                "No validation message");
    }
}
