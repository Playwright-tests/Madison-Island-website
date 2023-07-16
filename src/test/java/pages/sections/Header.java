package pages.sections;

import com.microsoft.playwright.Page;
import pages.components.MainMenu;
import pages.components.SearchEngine;
import qa.base.BasePage;

public class Header extends BasePage {

    private final MainMenu mainMenu;
    private final SearchEngine searchEngine;

    public Header(Page page) {

        super(page);

        mainMenu = new MainMenu(getPage());
        searchEngine = new SearchEngine(getPage());
    }

    public MainMenu getMainMenu() {

        return mainMenu;
    }

    public SearchEngine getSearchEngine() {

        return searchEngine;
    }
}
