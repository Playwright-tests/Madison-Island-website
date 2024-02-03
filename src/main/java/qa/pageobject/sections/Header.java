package qa.pageobject.sections;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import qa.pageobject.header.MainMenu;
import qa.pageobject.header.SearchEngine;
import qa.base.BasePage;

public class Header extends BasePage {

    private final MainMenu mainMenu;
    private final SearchEngine searchEngine;
    private final Locator shoppingCartLink;
    private final Locator minicartWrapper;

    public Header(Page page) {

        super(page);

        mainMenu = new MainMenu(getPage());
        searchEngine = new SearchEngine(getPage());
        shoppingCartLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Cart"));
        minicartWrapper = page.locator(".minicart-wrapper");
    }

    public void clickShoppingCartLink() {

        shoppingCartLink.click();
    }

    public Locator getMinicartWrapper() {

        return minicartWrapper;
    }

    public MainMenu getMainMenu() {

        return mainMenu;
    }

    public SearchEngine getSearchEngine() {

        return searchEngine;
    }
}
