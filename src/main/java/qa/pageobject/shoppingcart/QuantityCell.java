package qa.pageobject.shoppingcart;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import qa.base.BasePage;

public class QuantityCell extends BasePage {

    private final Locator quantityField;
    private final Locator updateButton;

    public QuantityCell(Page page, Locator parent) {

        super(page);

        quantityField = parent.getByRole(AriaRole.TEXTBOX, new Locator.GetByRoleOptions().setName("Qty"));
        updateButton = parent.getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Update"));
    }

    public void clickQuantityField() {

        quantityField.click();
    }

    public void setQuantity(String quantity) {

        quantityField.fill(quantity);
    }

    public String getQuantity() {

        return quantityField.inputValue();
    }

    public void clickUpdateButton() {

        updateButton.click();;
    }
}
