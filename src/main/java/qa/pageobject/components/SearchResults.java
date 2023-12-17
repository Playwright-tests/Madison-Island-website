package qa.pageobject.components;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import qa.base.BasePage;

public class SearchResults extends BasePage {

    private final Locator amountItemsMessage;
    private final Locator noResultsMessage;

    public SearchResults(Page page) {

        super(page);

        amountItemsMessage = getPage().locator("strong").filter(new Locator.FilterOptions().setHasText("Item(s)")).first();
        noResultsMessage = getPage().getByText("Your search returns no results.");
    }

    public Locator getAmountItemsMessageLocator() {

        return amountItemsMessage;
    }

    public Locator getNoResultsMessageLocator() {

        return noResultsMessage;
    }
}
