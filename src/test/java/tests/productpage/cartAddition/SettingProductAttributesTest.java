package tests.productpage.cartAddition;

import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.base.BaseTest;
import qa.support.URLs;
import qa.pageobject.productpage.ProductShop;
import qa.models.Product;

@Epic("E2E")
public class SettingProductAttributesTest extends BaseTest {

    private ProductShop productShop;
    private final Product product;

    public SettingProductAttributesTest(Product product) {

        this.product = product;
    }

    @BeforeMethod
    public void prepare() {

        goToPage(URLs.HOME_PAGE + product.getUrl());
        productShop = new ProductShop(getPage());
    }

    private void setAllureParameter() {

        Allure.link("The \"" + product.getName() + "\" product page", product.getUrl());
    }

    @Test(priority = 1)
    @Owner("Paweł Aksman")
    @Tag("Newsletter form")
    @Tag("Product page")
    @Tag("Shopping cart")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Adding a product to the cart selected all product attributes")
    public void allAttributesSelected() {

        setAllureParameter();
        productShop
                .setColor(product.getColor())
                .setSize(product.getSize())
                .setQuantity(product.getQuantity())
                .clickAddToCartButton();

        Assert.assertEquals(getPage().url(), URLs.SHOPPING_CART,"The product has not been added to the shopping cart");
    }

    @Test(priority = 2)
    @Owner("Paweł Aksman")
    @Tag("Newsletter form")
    @Tag("Product page")
    @Tag("Shopping cart")
    @Severity(SeverityLevel.NORMAL)
    @Feature("Attempting to adding a product to the cart when a color is not selected")
    public void colorNotSelected() {

        setAllureParameter();
        productShop
                .setSize(product.getSize())
                .setQuantity(productShop.getQuantity())
                .clickAddToCartButton();

        Assert.assertNotEquals(getPage().url(), URLs.SHOPPING_CART,"The product has been added to the shopping cart");
        Assert.assertTrue(productShop.getRequiredColorMessageLocator().isVisible(),"The message about unselected product color has not been displayed");
        Assert.assertEquals(productShop.getRequiredColorMessage(), "This is a required field.","Incorrect message content");
    }

    @Test(priority = 3)
    @Owner("Paweł Aksman")
    @Tag("Newsletter form")
    @Tag("Product page")
    @Tag("Shopping cart")
    @Severity(SeverityLevel.NORMAL)
    @Feature("Attempting to adding a product to the cart when a size is not selected")
    public void sizeNotSelected() {

        setAllureParameter();
        productShop
                .setColor(product.getColor())
                .setQuantity(productShop.getQuantity())
                .clickAddToCartButton();

        Assert.assertNotEquals(getPage().url(), URLs.SHOPPING_CART,"The product has not been added to the shopping cart");
        Assert.assertTrue(productShop.getRequiredSizeMessageLocator().isVisible(),"The message about unselected product size has not been displayed");
        Assert.assertEquals(productShop.getRequiredSizeMessage(), "This is a required field.","Incorrect message content");
    }
}
