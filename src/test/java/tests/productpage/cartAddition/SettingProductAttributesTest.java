package tests.productpage.cartAddition;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.base.BaseTest;
import qa.support.URLs;
import qa.pageobject.productpage.ProductShop;
import qa.models.Product;

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

    @Test
    public void allAttributesSelected() {

        productShop
                .setColor(product.getColor())
                .setSize(product.getSize())
                .setQuantity(product.getQuantity())
                .clickAddToCartButton();

        Assert.assertEquals(getPage().url(), URLs.SHOPPING_CART,"The product has not been added to the shopping cart");
    }

    @Test
    public void colorNotSelected() {

        productShop
                .setSize(product.getSize())
                .setQuantity(productShop.getQuantity())
                .clickAddToCartButton();

        Assert.assertNotEquals(getPage().url(), URLs.SHOPPING_CART,"The product has been added to the shopping cart");
        Assert.assertTrue(productShop.getRequiredColorMessageLocator().isVisible(),"The message about unselected product color has not been displayed");
        Assert.assertEquals(productShop.getRequiredColorMessage(), "This is a required field.","Incorrect message content");
    }

    @Test
    public void sizeNotSelected() {

        productShop
                .setColor(product.getColor())
                .setQuantity(productShop.getQuantity())
                .clickAddToCartButton();

        Assert.assertNotEquals(getPage().url(), URLs.SHOPPING_CART,"The product has not been added to the shopping cart");
        Assert.assertTrue(productShop.getRequiredSizeMessageLocator().isVisible(),"The message about unselected product size has not been displayed");
        Assert.assertEquals(productShop.getRequiredSizeMessage(), "This is a required field.","Incorrect message content");
    }
}
