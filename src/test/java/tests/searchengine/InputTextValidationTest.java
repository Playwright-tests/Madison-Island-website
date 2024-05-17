package tests.searchengine;

import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.support.URLs;
import tests.base.BaseTest;
import qa.pageobject.header.SearchEngine;

@Epic("E2E")
public class InputTextValidationTest extends BaseTest {

    private SearchEngine searchEngine;

    @BeforeMethod
    public void prepare() {

        searchEngine = new SearchEngine(getPage());
    }

    @Test
    @Owner("Paweł Aksman")
    @Tag("Search engine")
    @Tag("Field")
    @Link(name = "Home page", value = URLs.HOME_PAGE)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verification of the search field text input")
    public void checkInputText() {

        String phrase = "This is the phrase";
        searchEngine.setPhrase(phrase);

        Assert.assertEquals(searchEngine.getPhrase(), phrase,
                "Incorrect input content");
    }
}
