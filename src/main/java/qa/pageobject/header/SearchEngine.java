package qa.pageobject.header;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import io.qameta.allure.Step;
import qa.base.BasePage;

public class SearchEngine extends BasePage {

    private final Locator searchField;
    private final Locator searchButton;

    public SearchEngine(Page page) {

        super(page);

        searchField = getPage().locator("#search");
        searchButton = getPage().getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Search"));
    }

    @Step("Enter a phrase")
    public void setPhrase(String phrase) {

        searchField.fill(phrase);
    }

    @Step("Click the search button")
    public void clickSearchButton() {

        searchButton.click();
    }

    public String getPhrase() {

        return searchField.inputValue();
    }
}
