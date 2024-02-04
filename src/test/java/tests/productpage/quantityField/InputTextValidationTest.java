package tests.productpage.quantityField;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.enums.URLs;
import qa.pageobject.productpage.ProductPage;
import qa.pageobject.productpage.ProductShop;

public class InputTextValidationTest extends BaseTest {

    private ProductPage productPage;

    @BeforeMethod
    public void create() {

        goToPage(URLs.ELIZABETH_KNIT_PRODUCT_PAGE.getName());
        productPage = new ProductPage(getPage());
        productPage.setProductShop(new ProductShop(getPage()));
    }

    @Test
    public void checkInputText() {

        String quantity = "1234";
        productPage.getProductShop().setQuantity(quantity);

        Assert.assertEquals(productPage.getProductShop().getQuantity(), quantity,
                "Incorrect input content");
    }
}
