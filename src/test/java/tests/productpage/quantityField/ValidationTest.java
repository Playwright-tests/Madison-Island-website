package tests.productpage.quantityField;

import com.microsoft.playwright.Page;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.models.Product;
import tests.base.BaseTest;
import qa.dataProviders.QuantityFieldDataProviders;
import qa.support.URLs;
import qa.pageobject.productpage.ProductPage;
import qa.support.DataProviderNames;

public class ValidationTest extends BaseTest {

    private ProductPage productPage;
    private final Product product;

    public ValidationTest(Product product) {

        this.product = product;
    }

    @BeforeMethod
    public void prepare() {

        goToPage(URLs.HOME_PAGE + product.getUrl());
        productPage = new ProductPage(getPage());
    }

    private void actions(String quantity) {

        productPage.getProductShop()
                .setColor(product.getColor())
                .setSize(product.getSize())
                .setQuantity(quantity)
                .clickAddToCartButton();
    }

    @Test
    public void belowMin() {

        actions("0");
        Assert.assertEquals(getPage().url(), URLs.SHOPPING_CART, "The product has not been added to the shopping cart");
    }

    @Test
    public void min()  {

        actions("1");
        Assert.assertEquals(getPage().url(), URLs.SHOPPING_CART, "The product has not been added to the shopping cart");
    }

    @Test
    public void aboveMin() {

        actions("2");
        Assert.assertEquals(getPage().url(), URLs.SHOPPING_CART, "The product has not been added to the shopping cart");
    }

    @Test
    public void belowMax() {

        actions(String.valueOf(Integer.parseInt(product.getMaxQuantity()) - 1));
        Assert.assertEquals(getPage().url(), URLs.SHOPPING_CART, "The product has not been added to the shopping cart");
    }

    @Test
    public void max() {

        actions(product.getMaxQuantity());
        Assert.assertEquals(getPage().url(), URLs.SHOPPING_CART, "The product has not been added to the shopping cart");
    }

    @Test
    public void aboveMax() {

        actions(String.valueOf(Integer.parseInt(product.getMaxQuantity()) + 1));

        Assert.assertNotEquals(getPage().url(), URLs.SHOPPING_CART, "The product has not been added to the shopping cart");

        try {
            getPage().waitForSelector(productPage.getErrorMessageSelector(), new Page.WaitForSelectorOptions().setTimeout(2000));
        } catch (Exception e) {
            Assert.fail("The error message has not been displayed");
        }

        Assert.assertEquals(productPage.getErrorMessage(), "The requested quantity for \"" + product.getName() + "\" is not available.",
                "Incorrect the error message content");
    }

    @Test(dataProvider = DataProviderNames.FLOATING_POINT, dataProviderClass = QuantityFieldDataProviders.class)
    public void floatingPoint(String quantity) {

        actions(quantity);
        Assert.assertNotEquals(getPage().url(), URLs.SHOPPING_CART, "The product has not been added to the shopping cart");
        Assert.assertFalse(productPage.getProductShop().getQuantityValidationMessage().isEmpty(),"No validation message");
    }

    @Test(dataProvider = DataProviderNames.NOT_NUMBER, dataProviderClass = QuantityFieldDataProviders.class)
    public void notANumber(String quantity) {

        actions(quantity);
        Assert.assertNotEquals(getPage().url(), URLs.SHOPPING_CART, "The product has not been added to the shopping cart");
        Assert.assertFalse(productPage.getProductShop().getQuantityValidationMessage().isEmpty(),"No validation message");
    }
}
