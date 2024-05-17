package tests.productpage.quantityField;

import com.microsoft.playwright.Page;
import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.models.Product;
import tests.base.BaseTest;
import qa.dataProviders.QuantityFieldDataProviders;
import qa.support.URLs;
import qa.pageobject.productpage.ProductPage;
import qa.support.DataProviderNames;

@Epic("E2E")
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

    private void setAllureParameters(String quantity) {

        Allure.link("The \"" + product.getName() + "\" product page", product.getUrl());
        Allure.parameter("Quantity", quantity);
    }

    private void actions(String quantity) {

        productPage.getProductShop()
                .setColor(product.getColor())
                .setSize(product.getSize())
                .setQuantity(quantity)
                .clickAddToCartButton();
    }

    @Test(priority = 1)
    @Owner("Paweł Aksman")
    @Tag("Newsletter form")
    @Tag("Quantity field")
    @Tag("Fields")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Quantity- shorter than minimum (min - 1)")
    public void belowMin() {

        setAllureParameters("0");
        actions("0");
        Assert.assertEquals(getPage().url(), URLs.SHOPPING_CART, "The product has not been added to the shopping cart");
    }

    @Test(priority = 2)
    @Owner("Paweł Aksman")
    @Tag("Newsletter form")
    @Tag("Quantity field")
    @Tag("Fields")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Quantity- minimum")
    public void min()  {

        setAllureParameters("1");
        actions("1");
        Assert.assertEquals(getPage().url(), URLs.SHOPPING_CART, "The product has not been added to the shopping cart");
    }

    @Test(priority = 3)
    @Owner("Paweł Aksman")
    @Tag("Newsletter form")
    @Tag("Quantity field")
    @Tag("Fields")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Quantity- exceeding minimum (min + 1)")
    public void aboveMin() {

        setAllureParameters("2");
        actions("2");
        Assert.assertEquals(getPage().url(), URLs.SHOPPING_CART, "The product has not been added to the shopping cart");
    }

    @Test(priority = 4)
    @Owner("Paweł Aksman")
    @Tag("Newsletter form")
    @Tag("Quantity field")
    @Tag("Fields")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Quantity- shorter than maximum (max - 1)")
    public void belowMax() {

        String quantity = String.valueOf(Integer.parseInt(product.getMaxQuantity()) - 1);
        setAllureParameters(quantity);
        actions(quantity);

        Assert.assertEquals(getPage().url(), URLs.SHOPPING_CART, "The product has not been added to the shopping cart");
    }

    @Test(priority = 5)
    @Owner("Paweł Aksman")
    @Tag("Newsletter form")
    @Tag("Quantity field")
    @Tag("Fields")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Quantity- maximum")
    public void max() {

        setAllureParameters(product.getMaxQuantity());
        actions(product.getMaxQuantity());
        Assert.assertEquals(getPage().url(), URLs.SHOPPING_CART, "The product has not been added to the shopping cart");
    }

    @Test(priority = 6)
    @Owner("Paweł Aksman")
    @Tag("Newsletter form")
    @Tag("Quantity field")
    @Tag("Fields")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Quantity- exceeding maximum (max + 1)")
    public void aboveMax() {

        String quantity = String.valueOf(Integer.parseInt(product.getMaxQuantity()) + 1);
        setAllureParameters(quantity);
        actions(quantity);

        Assert.assertNotEquals(getPage().url(), URLs.SHOPPING_CART, "The product has not been added to the shopping cart");

        try {
            getPage().waitForSelector(productPage.getErrorMessageSelector(), new Page.WaitForSelectorOptions().setTimeout(2000));
        } catch (Exception e) {
            Assert.fail("The error message has not been displayed");
        }

        Assert.assertEquals(productPage.getErrorMessage(), "The requested quantity for \"" + product.getName() + "\" is not available.",
                "Incorrect the error message content");
    }

    @Test(priority = 7, dataProvider = DataProviderNames.FLOATING_POINT, dataProviderClass = QuantityFieldDataProviders.class)
    @Owner("Paweł Aksman")
    @Tag("Newsletter form")
    @Tag("Quantity field")
    @Tag("Fields")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Entering a floating point")
    public void floatingPoint(String quantity) {

        setAllureParameters(quantity);
        actions(quantity);
        Assert.assertNotEquals(getPage().url(), URLs.SHOPPING_CART, "The product has not been added to the shopping cart");
        Assert.assertFalse(productPage.getProductShop().getQuantityValidationMessage().isEmpty(),"No validation message");
    }

    @Test(priority = 8, dataProvider = DataProviderNames.NOT_NUMBER, dataProviderClass = QuantityFieldDataProviders.class)
    @Owner("Paweł Aksman")
    @Tag("Newsletter form")
    @Tag("Quantity field")
    @Tag("Fields")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Entering a special character")
    public void notANumber(String quantity) {

        setAllureParameters(quantity);
        actions(quantity);
        Assert.assertNotEquals(getPage().url(), URLs.SHOPPING_CART, "The product has not been added to the shopping cart");
        Assert.assertFalse(productPage.getProductShop().getQuantityValidationMessage().isEmpty(),"No validation message");
    }
}
