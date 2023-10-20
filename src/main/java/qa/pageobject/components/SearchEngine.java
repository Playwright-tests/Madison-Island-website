package qa.pageobject.components;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import qa.base.BasePage;

public class SearchEngine extends BasePage {

    private final Locator searchField;
    private final Locator searchButton;

    public SearchEngine(Page page) {

        super(page);

        searchField = getPage().locator("#search");
        searchButton = getPage().getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Search"));
    }

    public void setPhrase(String phrase) {

        searchField.fill(phrase);
    }

    public void clickSearchButton() {

        searchButton.click();
    }
}
