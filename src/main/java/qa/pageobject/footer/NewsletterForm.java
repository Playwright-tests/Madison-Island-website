package qa.pageobject.footer;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import io.qameta.allure.Step;
import qa.base.BasePage;

public class NewsletterForm extends BasePage {

    private final Locator emailField;
    private final Locator subscribeButton;
    private final Locator adviceRequiredEmail;

    public NewsletterForm(Page page) {

        super(page);

        emailField = getPage().getByTitle("Sign up for our newsletter");
        subscribeButton = getPage().getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Subscribe"));
        adviceRequiredEmail = getPage().locator("#advice-required-entry-newsletter");
    }

    @Step("Enter an email")
    public NewsletterForm setEmail(String email) {

        emailField.fill(email);
        return this;
    }

    @Step("Click the \"Subscribe\" button")
    public void clickSubscribeButton() {

        subscribeButton.click();
    }

    public String getEmailFieldText() {

        return emailField.inputValue();
    }

    public String getAdviceRequiredEmailText() {

        return adviceRequiredEmail.textContent();
    }

    public String getValidationMessage() {

        ElementHandle elementHandle = emailField.elementHandle();
        Object object = elementHandle.evaluate("e=>e.validationMessage");

        return object.toString();
    }
}
