package qa.pageobject.shoppingcart;

import com.microsoft.playwright.Page;
import qa.base.BasePage;

public class ShoppingCart extends BasePage {

    private final Table table;

    public ShoppingCart(Page page) {

        super(page);

        table = new Table(page);
    }

    public Table getTable() {

        return table;
    }
}
