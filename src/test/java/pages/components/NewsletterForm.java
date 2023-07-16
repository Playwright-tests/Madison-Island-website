package pages.components;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import qa.base.BasePage;

public class NewsletterForm extends BasePage {

    Locator nameField;
    Locator subscribeButton;
    public NewsletterForm(Page page) {

        super(page);

        nameField = getPage().getByTitle("Sign up for our newsletter");
        subscribeButton = getPage().getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Subscribe"));
    }

    public void setName(String name) {

        nameField.fill(name);
    }

    public void clickSubscribeButton() {

        subscribeButton.click();
    }
}
