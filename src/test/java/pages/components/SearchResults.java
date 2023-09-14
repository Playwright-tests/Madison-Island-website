package pages.components;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import qa.base.BasePage;

public class SearchResults extends BasePage {

    private Locator categoryProducts;
    public SearchResults(Page page) {

        super(page);

        categoryProducts = getPage().locator(".products-grid products-grid--max-3-col first last odd");
    }
}
