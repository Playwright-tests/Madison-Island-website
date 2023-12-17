package qa.pageobject.shoppingcart;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import qa.base.BasePage;

public class Table extends BasePage {

    private final Locator shoppingCartTable;
    private final Locator row;
    private final Locator errorMessage;
    private final Locator updateCartButton;
    private final QuantityField quantityField;

    public Table(Page page) {

        super(page);

        shoppingCartTable = page.locator("#shopping-cart-table");
        row = shoppingCartTable.locator("tbody tr");
        errorMessage = page.locator(".item-msg.error");
        updateCartButton = row.locator("td.product-cart-actions").getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Update"));

        quantityField = new QuantityField(getPage(), row.locator("td.product-cart-actions").getByRole(AriaRole.TEXTBOX, new Locator.GetByRoleOptions().setName("Qty")));
    }

    public void clickUpdateCartButton() {

        updateCartButton.click();
    }

    public String getName() {

        return row.locator("td.product-cart-info h2 a").textContent();
    }

    public String getColor() {

        return row.locator("td.product-cart-info dl.item-options dd").first().textContent().trim();
    }

    public String getSize() {

        return row.locator("td.product-cart-info dl.item-options dd").nth(1).textContent().trim();
    }

    public String getPrice() {

        return row.locator("td.product-cart-price span.price").textContent();
    }

    public String getSubtotal() {

        return row.locator("td.product-cart-total span.price").textContent().replaceAll("\\s", "");
    }

    public QuantityField getQuantityField() {

        return quantityField;
    }

    public Locator getErrorMessageLocator() {

        return errorMessage;
    }

    public String getErrorMessageText() {

        return errorMessage.textContent().trim();
    }

    public boolean isVisible() {

        return shoppingCartTable.isVisible();
    }
}
