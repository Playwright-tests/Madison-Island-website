package qa.pageobject.mainmenu;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import qa.base.BasePage;

public class MainMenuDropdownList extends BasePage {

    private final Locator parent;
    private final String triggerElementText;
    private final String listContents;

    public MainMenuDropdownList(Page page, String triggerElementText, String listContents) {

        super(page);

        parent = page.locator("#nav");
        this.triggerElementText = triggerElementText;
        this.listContents = listContents;
    }

    public void hoverTriggerElement() {

        parent.getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName(triggerElementText).setExact(true)).hover();
    }

    public boolean isListVisible() {

        return getPage().getByText(listContents).isVisible();
    }

    public void clickItem(String name) {

        Locator item = getPage().getByRole(AriaRole.LISTITEM).filter(new Locator.FilterOptions().setHasText(triggerElementText));
        item.getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName(name).setExact(true)).click();
    }
}
