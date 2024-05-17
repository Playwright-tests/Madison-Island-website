package tests.productpage.quantityField;

import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.models.Product;
import qa.support.URLs;
import tests.base.BaseTest;
import qa.pageobject.productpage.ProductPage;

@Epic("E2E")
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
    @Owner("Paweł Aksman")
    @Tag("Newsletter form")
    @Tag("Quantity field")
    @Tag("Fields")
    @Tag("Shopping cart")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verification of the quantity field text input")
    public void checkInputText() {

        String quantity = "1234";
        Allure.link("The \"" + product.getName() + "\" product page", product.getUrl());
        Allure.parameter("Quantity", quantity);
        productPage.getProductShop().setQuantity(quantity);

        Assert.assertEquals(productPage.getProductShop().getQuantity(), quantity,"Incorrect input content");
    }
}
