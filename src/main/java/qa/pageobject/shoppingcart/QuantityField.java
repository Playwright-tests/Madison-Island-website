package qa.pageobject.shoppingcart;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;
import qa.base.BasePage;

public class QuantityField extends BasePage {

    private final Locator field;

    public QuantityField(Page page, Locator locator) {

        super(page);

        field = locator;
    }

    @Step("Click the quantity field")
    public QuantityField clickQuantityField() {

        field.click();
        return this;
    }

    @Step("Enter a quantity")
    public QuantityField setQuantity(String quantity) {

        field.fill(quantity);
        return this;
    }

    public String getQuantity() {

        return field.inputValue();
    }

    public String getValidationMessage() {

        ElementHandle handle = field.elementHandle();
        Object validationMessage = handle.evaluate("e=>e.validationMessage");

        return validationMessage.toString();
    }
}
