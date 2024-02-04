package tests.header.searchengine;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.pageobject.header.SearchEngine;

public class InputTextValidationTest extends BaseTest {

    private SearchEngine searchEngine;

    @BeforeMethod
    public void create() {

        searchEngine = new SearchEngine(getPage());
    }

    @Test
    public void checkInputText() {

        String phrase = "This is the phrase";
        searchEngine.setPhrase(phrase);

        Assert.assertEquals(searchEngine.getPhrase(), phrase,
                "Incorrect input content");
    }
}
