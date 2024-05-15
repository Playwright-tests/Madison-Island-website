package qa.pageobject.shoppingcart;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import qa.base.BasePage;

public class QuantityField extends BasePage {

    private final Locator field;

    public QuantityField(Page page, Locator locator) {

        super(page);

        field = locator;
    }

    public QuantityField clickQuantityField() {

        field.click();
        return this;
    }

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
