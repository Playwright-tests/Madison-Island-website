package qa.pageobject.shoppingcart;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import qa.base.BasePage;

public class Table extends BasePage {

    private final Locator shoppingCartTable;
    private final Locator row;
    private final Locator quantityErrorMessage;
    private final QuantityCell quantityCell;

    public Table(Page page) {

        super(page);

        shoppingCartTable = page.locator("#shopping-cart-table");
        row = shoppingCartTable.locator("tbody tr");
        quantityErrorMessage = page.locator("p").filter(new Locator.FilterOptions().setHasText("* The requested quantity for"));

        quantityCell = new QuantityCell(getPage(), row.locator("td.product-cart-actions"));
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

    public double getPrice() {

        return Double.parseDouble(row.locator("td.product-cart-price span.price").textContent().replaceAll("\\s", "").replace("$", ""));
    }

    public String getSubtotal() {

        return row.locator("td.product-cart-total span.price").textContent().replaceAll("\\s", "");
    }

    public QuantityCell getQuantityCell() {

        return quantityCell;
    }

    public boolean isQuantityErrorMessageVisible() {

        return quantityErrorMessage.isVisible();
    }

    public String getQuantityErrorMessageText() {

        return quantityErrorMessage.textContent();
    }

    public boolean isVisible() {

        return shoppingCartTable.isVisible();
    }
}
