package pageobject.shoppingcart;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import qa.base.BasePage;

public class Table extends BasePage {

    private final Locator shoppingCartTable;
    private final Locator row;
    private final QuantityCell quantityCell;

    public Table(Page page) {

        super(page);

        shoppingCartTable = page.locator("#shopping-cart-table");
        row = shoppingCartTable.locator("tbody tr");

        quantityCell = new QuantityCell(getPage(), row.locator("td.product-cart-actions"));
    }

    public String getName() {

        return row.locator("td.product-cart-info h2 a").textContent();
    }

    public String getColor() {

        return row.locator("td.product-cart-info dl.item-options dd").first().textContent();
    }

    public String getSize() {

        return row.locator("td.product-cart-info dl.item-options dd").nth(1).textContent();
    }

    public String getPrice() {

        return row.locator("td.product-cart-price span.price").textContent();
    }

    public QuantityCell getQuantityCell() {

        return quantityCell;
    }
}
