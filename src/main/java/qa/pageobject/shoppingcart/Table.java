package qa.pageobject.shoppingcart;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import qa.base.BasePage;

import java.util.List;

public class Table extends BasePage {

    private final Locator shoppingCartTable;
    private List<Locator> rows;
    private final Locator errorMessage;

    public Table(Page page) {

        super(page);

        shoppingCartTable = page.locator("#shopping-cart-table");
        rows = shoppingCartTable.locator("tbody tr").all();
        errorMessage = page.locator(".item-msg.error");
    }

    public void findRows() {

        rows = getPage().locator("table#shopping-cart-table tbody tr").all();
    }

    public int getRowsCount() {

        return rows.size();
    }

    public void clickUpdateCartButton(int row) {

        rows.get(row).locator("td.product-cart-actions").getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Update")).click();
    }

    public String getName(int row) {

        return rows.get(row).locator("td.product-cart-info h2 a").textContent();
    }

    public String getColor(int row) {

        return rows.get(row).locator("td.product-cart-info dl.item-options dd").first().textContent().trim();
    }

    public String getSize(int row) {

        return rows.get(row).locator("td.product-cart-info dl.item-options dd").nth(1).textContent().trim();
    }

    public String getPrice(int row) {

        return rows.get(row).locator("td.product-cart-price span.price").textContent();
    }

    public String getSubtotal(int row) {

        return rows.get(row).locator("td.product-cart-total span.price").textContent().replaceAll("\\s", "");
    }

    public QuantityField getQuantityField(int row) {

        return new QuantityField(getPage(), rows.get(row).locator("td.product-cart-actions").getByRole(AriaRole.TEXTBOX, new Locator.GetByRoleOptions().setName("Qty")));
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
