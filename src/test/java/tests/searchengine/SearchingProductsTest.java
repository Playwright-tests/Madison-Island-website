package tests.searchengine;

import com.microsoft.playwright.Page;
import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.dataProviders.SearchEngineDataProviders;
import qa.pageobject.header.SearchEngine;
import qa.support.URLs;
import qa.pageobject.searchresultspage.SearchResultsPage;
import tests.base.BaseTest;
import qa.support.DataProviderNames;

@Epic("E2E")
public class SearchingProductsTest extends BaseTest {

    private SearchEngine searchEngine;
    private SearchResultsPage searchResultsPage;

    @BeforeMethod
    public void prepare() {

        searchEngine = new SearchEngine(getPage());
        searchResultsPage = new SearchResultsPage(getPage());
    }

    private void waitForSearchResultsPage(String phrase) {

        try {
            getPage().waitForURL(URLs.SEARCH_RESULTS_PAGE + phrase,
                    new Page.WaitForURLOptions().setTimeout(2000));
        } catch (Exception e) {
            Assert.fail("The search results page has not been opened");
        }
    }

    private void actions(String phrase) {

        searchEngine.setPhrase(phrase);
        searchEngine.clickSearchButton();
        waitForSearchResultsPage(phrase);
        searchResultsPage.findProducts();
    }


    @Test(priority = 1, dataProvider = DataProviderNames.CORRECT, dataProviderClass = SearchEngineDataProviders.class)
    @Owner("Paweł Aksman")
    @Tag("Header")
    @Tag("Search engine")
    @Tag("Buttons")
    @Link(name = "Home page", value = URLs.HOME_PAGE)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Searching with a correct phrase")
    public void correct(String phrase) {

        actions(phrase);

        Assert.assertTrue(searchResultsPage.getProductsListSize() > 0, "No products found with the correct phrase: " + phrase);
    }

    @Test(priority = 2, dataProvider = DataProviderNames.LOWER_UPPER, dataProviderClass = SearchEngineDataProviders.class)
    @Owner("Paweł Aksman")
    @Tag("Header")
    @Tag("Buttons")
    @Link(name = "Home page", value = URLs.HOME_PAGE)
    @Severity(SeverityLevel.NORMAL)
    @Description("Searching with a correct phrase having upper and lower cases")
    public void lowerUpper(String phrase) {

        actions(phrase);

        Assert.assertTrue(searchResultsPage.getProductsListSize() > 0, "No products found with the correct phrase: " + phrase);
    }

    @Test(priority = 3, dataProvider = DataProviderNames.INCORRECT, dataProviderClass = SearchEngineDataProviders.class)
    @Owner("Paweł Aksman")
    @Tag("Header")
    @Tag("Buttons")
    @Link(name = "Home page", value = URLs.HOME_PAGE)
    @Severity(SeverityLevel.NORMAL)
    @Description("Searching with an incorrect phrase")
    public void incorrect(String phrase) {

        actions(phrase);

        Assert.assertEquals(searchResultsPage.getProductsListSize(), 0, "Products are found with the correct phrase: " + phrase);
    }
}
