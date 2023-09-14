package pages.components;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import qa.base.BasePage;

public class NewsletterForm extends BasePage {

    Locator emailField;
    Locator subscribeButton;
    Locator adviceRequiredEmail;

    public NewsletterForm(Page page) {

        super(page);

        emailField = getPage().getByTitle("Sign up for our newsletter");
        subscribeButton = getPage().getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Subscribe"));
        adviceRequiredEmail = getPage().locator("#advice-required-entry-newsletter");
    }

    public void setEmail(String email) {

        emailField.fill(email);
    }

    public void clickSubscribeButton() {

        subscribeButton.click();
    }

    public String getEmailFieldText() {

        return emailField.textContent();
    }

    public Locator getAdviceRequiredEmail() {

        return adviceRequiredEmail;
    }
}
