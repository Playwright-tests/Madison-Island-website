package tests.shoppingcart.estimatedform;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.enums.URLs;
import qa.helpers.ShoppingCartActions;
import qa.pageobject.shoppingcart.EstimatedShippingAndTaxForm;

public class InputTextValidationTest extends BaseTest {

    private EstimatedShippingAndTaxForm estimatedShippingAndTaxForm;

    @BeforeMethod
    public void create() {

        goToPage(URLs.ELIZABETH_KNIT_PRODUCT_PAGE.getName());
        ShoppingCartActions.addToCart(getPage()).clickAddToCartButton();
        getPage().waitForURL(URLs.SHOPPING_CART.getName());

        estimatedShippingAndTaxForm = new EstimatedShippingAndTaxForm(getPage());
    }

    @Test
    public void cityField() {

        String city = " New York";
        estimatedShippingAndTaxForm.setCity(city);

        Assert.assertEquals(estimatedShippingAndTaxForm.getCityFieldText(), city,
                "Incorrect input content");
    }

    @Test
    public void zipField() {

        String ZIP = "223-443";
        estimatedShippingAndTaxForm.setZIP(ZIP);

        Assert.assertEquals(estimatedShippingAndTaxForm.getZipFieldText(), ZIP,
                "Incorrect input content");
    }
}
