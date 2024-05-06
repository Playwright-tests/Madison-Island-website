package qa.pageobject.searchresultspage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import qa.base.BasePage;

import java.util.List;

public class SearchResultsPage extends BasePage {

    private final Locator productsGrid;
    private List<Locator> products;

    public SearchResultsPage(Page page) {

        super(page);

        productsGrid = page.locator(".products-grid.products-grid--max-3-col.first.last.odd");
    }

    public void findProducts() {

        products = productsGrid.locator(".item.last").all();
    }

    public int getProductsListSize() {

        return products.size();
    }
}
