package tests.shoppingcart.couponcode;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.enums.URLs;
import qa.helpers.ShoppingCartActions;
import qa.pageobject.shoppingcart.CouponCodeForm;


public class InputTextValidationTest extends BaseTest {

    private CouponCodeForm couponCodeForm;

    @BeforeMethod
    public void create() {

        goToPage(URLs.ELIZABETH_KNIT_PRODUCT_PAGE.getName());
        ShoppingCartActions.addToCart(getPage()).clickAddToCartButton();
        couponCodeForm = new CouponCodeForm(getPage());
    }

    @Test
    public void checkInputText() {

        String text = "Coupon code";
        couponCodeForm.setCouponCode(text);

        Assert.assertEquals(couponCodeForm.getCouponCode(), text,
                "Incorrect input content");
    }
}
