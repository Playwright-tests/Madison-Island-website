package tests;

import dataProvider.Provider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject.components.SearchResults;
import pageobject.sections.Header;
import qa.base.BaseTest;
import java.util.function.Consumer;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static playwright.PlaywrightLauncher.*;

public class SearchEngineTest extends BaseTest {

    private Header header;
    private SearchResults searchResults;

    @BeforeMethod
    public void create() {

        header = new Header(getPage());
        searchResults = new SearchResults(getPage());
    }

    private void check(String phrase, Consumer<SearchResults> consumer) {

        header.getSearchEngine().setPhrase(phrase);
        header.getSearchEngine().clickSearchButton();

        consumer.accept(searchResults);
    }

    @Test(dataProvider = "searchEngineCorrectPhrase", dataProviderClass = Provider.class)
    public void correctPhrase(String phrase) {

        check(phrase, (SearchResults sr)->{assertThat(sr.getAmountItemsMessage()).isVisible();});
    }

    @Test(dataProvider = "searchEngineCorrectPhraseUpperLower", dataProviderClass = Provider.class)
    public void correctPhraseUpperLower(String phrase) {

        check(phrase, (SearchResults sr)->{assertThat(sr.getAmountItemsMessage()).isVisible();});
    }

    @Test(dataProvider = "searchEngineIncorrectPhrase", dataProviderClass = Provider.class)
    public void incorrectPhrase(String phrase) {

        check(phrase, (SearchResults sr)->{assertThat(sr.getNoResultsMessage()).isVisible();});
    }
}
