package tests;

import org.testng.Assert;
import qa.dataProvider.Provider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.enums.URLs;
import qa.extentreportsmanager.ExtentReportsManager;
import qa.pageobject.components.SearchResults;
import qa.pageobject.sections.Header;
import qa.base.BaseTest;

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

        //consumer.accept(searchResults);
    }

    @Test(dataProvider = "searchEngineCorrectPhrase", dataProviderClass = Provider.class)
    public void correctPhrase(String phrase) {

        ExtentReportsManager.createTest("Searching for a product with the correct phrase",
                "Checking whether the product was found after searching with the correct phrase");

        search(phrase);

        Assert.assertTrue(getPage().url().contains(URLs.SEARCH_RESULTS_PAGE.getName()),
                "The page with address \"" + URLs.SEARCH_RESULTS_PAGE.getName() + "\" has not been opened");
        Assert.assertTrue(searchResults.getAmountItemsMessageLocator().isVisible(),
                "No product has been found");
    }

    @Test(dataProvider = "searchEngineCorrectPhraseUpperLower", dataProviderClass = Provider.class)
    public void correctPhraseUpperLower(String phrase) {

        ExtentReportsManager.createTest("Searching for a product with the correct phrase which has uppercase and lowercase letters",
                "Checking whether the product was found after searching with the correct phrase which has uppercase and lowercase letters");

        search(phrase);

        Assert.assertTrue(getPage().url().contains(URLs.SEARCH_RESULTS_PAGE.getName()),
                "The page with address \"" + URLs.SEARCH_RESULTS_PAGE.getName() + "\" has not been opened");
        Assert.assertTrue(searchResults.getAmountItemsMessageLocator().isVisible(),
                "No product has been found");
    }

    @Test(dataProvider = "searchEngineIncorrectPhrase", dataProviderClass = Provider.class)
    public void incorrectPhrase(String phrase) {

        ExtentReportsManager.createTest("Searching for a product with the incorrect phrase",
                "Checking whether the product was found after searching with the incorrect phrase");

        search(phrase);

        Assert.assertTrue(getPage().url().contains(URLs.SEARCH_RESULTS_PAGE.getName()),
                "The page with address \"" + URLs.SEARCH_RESULTS_PAGE.getName() + "\" has not been opened");
        Assert.assertTrue(searchResults.getNoResultsMessageLocator().isVisible(),
                "No product has been found");
    }
}
