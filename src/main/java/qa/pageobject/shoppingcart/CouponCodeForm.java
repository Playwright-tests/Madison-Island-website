package qa.pageobject.shoppingcart;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import qa.base.BasePage;

public class CouponCodeForm extends BasePage {

    private final String errorMessageSelector;
    private final Locator couponCodeField;
    private final Locator applyButton;
    private final Locator errorMessage;

    public CouponCodeForm(Page page) {

        super(page);

        errorMessageSelector = "#advice-required-entry-coupon_code";

        couponCodeField = page.locator("#coupon_code");
        applyButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Apply"));
        errorMessage = page.locator(errorMessageSelector);
    }

    public void setCouponCode(String couponCode) {

        couponCodeField.fill(couponCode);
    }

    public void clickApplyButton() {

        applyButton.click();
    }

    public String getCouponCode() {

        return couponCodeField.inputValue();
    }

    public Locator getErrorMessageLocator() {

        return errorMessage;
    }

    public String getErrorMessageSelector() {

        return errorMessageSelector;
    }

    public String getErrorMessageText() {

        return errorMessage.textContent();
    }
}
