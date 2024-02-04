package tests.shoppingcart.couponcode;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.dataProviders.CouponCodeDataProviders;
import qa.enums.URLs;
import qa.helpers.ShoppingCartActions;
import qa.pageobject.shoppingcart.CouponCodeForm;
import qa.pageobject.shoppingcart.ShoppingCart;
import qa.support.dataprovidernames.DataProviderNames;

import java.lang.reflect.InvocationTargetException;

public class TypingCouponCodeTest extends BaseTest {

    private CouponCodeForm couponCodeForm;

    @BeforeMethod
    public void create() throws InvocationTargetException, IllegalAccessException {

        goToPage(URLs.ELIZABETH_KNIT_PRODUCT_PAGE.getName());
        ShoppingCartActions.addToCart(getPage()).clickAddToCartButton();

        couponCodeForm = new CouponCodeForm(getPage());
    }

    private void fill(String couponCode) {

        couponCodeForm.setCouponCode(couponCode);
        couponCodeForm.clickApplyButton();
    }

    @Test(priority = 1, dataProvider = DataProviderNames.INCORRECT, dataProviderClass = CouponCodeDataProviders.class)
    public void incorrectCouponCode(String couponCode) {

        fill(couponCode);

        ShoppingCart shoppingCart = new ShoppingCart(getPage());
        getPage().waitForSelector(shoppingCart.getErrorMessageSelector());

        Assert.assertTrue(shoppingCart.getErrorMessageLocator().isVisible(),
                "The message about an incorrect coupon code has not been displayed");
        Assert.assertEquals(shoppingCart.getErrorMessageText(), "Coupon code \"" + couponCode + "\" is not valid.",
                "Incorrect message content");
    }

    @Test(priority = 2)
    public void blankCouponCodeField() {

        fill("");
        getPage().waitForSelector(couponCodeForm.getErrorMessageSelector());

        Assert.assertTrue(couponCodeForm.getErrorMessageLocator().isVisible(),
                "The message about blank \"DISCOUNT CODES\" field has not been displayed");
        Assert.assertEquals(couponCodeForm.getErrorMessageText(), "This is a required field.",
                "Incorrect message content");
    }
}
