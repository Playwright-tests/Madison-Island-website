package tests.shoppingcart;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.dataProvider.Provider;
import qa.factories.FillingTheShoppingCart;
import qa.pageobject.shoppingcart.CouponCodeForm;
import qa.pageobject.shoppingcart.ShoppingCart;

import static qa.playwright.PlaywrightLauncher.*;

public class CouponCodeFormTests extends BaseTest {

    private CouponCodeForm couponCodeForm;

    @BeforeMethod
    public void create() {

        FillingTheShoppingCart.fill("Women", "Pants & Denim", "TriBeCa Skinny Jean", "Black", "30");

        couponCodeForm = new CouponCodeForm(getPage());
    }

    @Test(dataProvider = "incorrectCouponCode", dataProviderClass = Provider.class)
    public void incorrectCouponCode(String couponCode) {

        couponCodeForm.setCouponCode(couponCode);
        couponCodeForm.clickApplyButton();

        ShoppingCart shoppingCart = new ShoppingCart(getPage());

        String expectedMessage = "Coupon code \"" + couponCode + "\" is not valid.";

        getPage().waitForSelector(shoppingCart.getErrorMessageSelector());

        Assert.assertTrue(shoppingCart.isErrorMessageVisible());
        Assert.assertEquals(shoppingCart.getErrorMessageText(), expectedMessage);
    }

    @Test
    public void blankCouponCodeField() {

        couponCodeForm.clickApplyButton();

        getPage().waitForSelector(couponCodeForm.getErrorMessageSelector());

        Assert.assertTrue(couponCodeForm.isErrorMessageVisible());
        Assert.assertEquals(couponCodeForm.getErrorMessageText(), "This is a required field.");
    }
}
