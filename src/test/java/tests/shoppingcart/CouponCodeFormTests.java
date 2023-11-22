package tests.shoppingcart;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.dataProvider.Provider;
import qa.extentreportsmanager.ExtentReportsManager;
import qa.factories.FillingTheShoppingCart;
import qa.pageobject.shoppingcart.CouponCodeForm;
import qa.pageobject.shoppingcart.ShoppingCart;

public class CouponCodeFormTests extends BaseTest {

    private CouponCodeForm couponCodeForm;

    @BeforeMethod
    public void create() {

        FillingTheShoppingCart.fill(getPage(), "Women", "Pants & Denim", "TriBeCa Skinny Jean", "Black", "30");

        couponCodeForm = new CouponCodeForm(getPage());
    }

    private void fill(String couponCode) {

        couponCodeForm.setCouponCode(couponCode);
        couponCodeForm.clickApplyButton();
    }

    @Test(dataProvider = "incorrectCouponCode", dataProviderClass = Provider.class)
    public void incorrectCouponCode(String couponCode) {

        ExtentReportsManager.createTest("Applying a coupon using an incorrect code",
                "Checking whether a message about an incorrect coupon code is displayed");

        fill(couponCode);

        ShoppingCart shoppingCart = new ShoppingCart(getPage());

        String expectedMessage = "Coupon code \"" + couponCode + "\" is not valid.";

        getPage().waitForSelector(shoppingCart.getErrorMessageSelector());

        Assert.assertTrue(shoppingCart.isErrorMessageVisible(),
                "The message about an incorrect coupon code has not been displayed");
        Assert.assertEquals(shoppingCart.getErrorMessageText(), expectedMessage,
                "Incorrect message content");
    }

    @Test
    public void blankCouponCodeField() {

        ExtentReportsManager.createTest("Blank coupon code field",
                "Checking whether a message about blank \"DISCOUNT CODES\" field is displayed");

        fill("");

        getPage().waitForSelector(couponCodeForm.getErrorMessageSelector());

        Assert.assertTrue(couponCodeForm.isErrorMessageVisible(),
                "The message about blank \"DISCOUNT CODES\" field has not been displayed");
        Assert.assertEquals(couponCodeForm.getErrorMessageText(), "This is a required field.",
                "Incorrect message content");
    }
}
