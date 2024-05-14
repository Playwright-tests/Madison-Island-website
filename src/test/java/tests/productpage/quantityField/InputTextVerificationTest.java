package tests.productpage.quantityField;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.models.Product;
import qa.support.URLs;
import tests.base.BaseTest;
import qa.pageobject.productpage.ProductPage;

public class InputTextVerificationTest extends BaseTest {

    private ProductPage productPage;
    private final Product product;

    public InputTextVerificationTest(Product product) {

        this.product = product;
    }

    @BeforeMethod
    public void prepare() {

        goToPage(URLs.HOME_PAGE + product.getUrl());
        productPage = new ProductPage(getPage());
    }

    @Test
    public void checkInputText() {

        String quantity = "1234";
        productPage.getProductShop().setQuantity(quantity);

        Assert.assertEquals(productPage.getProductShop().getQuantity(), quantity,"Incorrect input content");
    }
}
