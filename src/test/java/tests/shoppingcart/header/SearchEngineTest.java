package tests.shoppingcart.header;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.dataProviders.SearchEngineDataProviders;
import qa.enums.URLs;
import qa.pageobject.searchresultspage.SearchResults;
import qa.pageobject.sections.Header;
import qa.base.BaseTest;
import qa.support.dataprovidernames.DataProviderNames;

public class SearchEngineTest extends BaseTest {

    private Header header;
    private SearchResults searchResults;

    @BeforeMethod
    public void create() {

        header = new Header(getPage());
        searchResults = new SearchResults(getPage());
    }

    private void search(String phrase) {

        header.getSearchEngine().setPhrase(phrase);
        header.getSearchEngine().clickSearchButton();
    }

    @Test(dataProvider = DataProviderNames.CORRECT, dataProviderClass = SearchEngineDataProviders.class)
    public void correct(String phrase) {

        search(phrase);

        Assert.assertTrue(getPage().url().contains(URLs.SEARCH_RESULTS_PAGE.getName()),
                "The page with address \"" + URLs.SEARCH_RESULTS_PAGE.getName() + "\" has not been opened");
        Assert.assertTrue(searchResults.getAmountItemsMessageLocator().isVisible(),
                "No product has been found");
    }

    @Test(dataProvider = DataProviderNames.LOWER_UPPER, dataProviderClass = SearchEngineDataProviders.class)
    public void lowerUpper(String phrase) {

        search(phrase);

        Assert.assertTrue(getPage().url().contains(URLs.SEARCH_RESULTS_PAGE.getName()),
                "The page with address \"" + URLs.SEARCH_RESULTS_PAGE.getName() + "\" has not been opened");
        Assert.assertTrue(searchResults.getAmountItemsMessageLocator().isVisible(),
                "No product has been found");
    }

    @Test(dataProvider = DataProviderNames.INCORRECT, dataProviderClass = SearchEngineDataProviders.class)
    public void incorrect(String phrase) {

        search(phrase);

        Assert.assertTrue(getPage().url().contains(URLs.SEARCH_RESULTS_PAGE.getName()),
                "The page with address \"" + URLs.SEARCH_RESULTS_PAGE.getName() + "\" has not been opened");
        Assert.assertTrue(searchResults.getNoResultsMessageLocator().isVisible(),
                "No product has been found");
    }
}
