package qa.pageobject.loginform;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import io.qameta.allure.Step;
import qa.base.BasePage;

public class LoginForm extends BasePage {

    private final Locator emailField;
    private final Locator passwordField;
    private final Locator loginButton;
    private final Locator invalidLoginOrPasswordMessage;
    private final Locator adviceRequiredEmail;
    private final Locator adviceRequiredPassword;

    public LoginForm(Page page) {

        super(page);

        emailField = getPage().locator("#email");
        passwordField = getPage().locator("#pass");
        loginButton = getPage().getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login"));
        invalidLoginOrPasswordMessage = getPage().getByRole(AriaRole.LISTITEM).filter(new Locator.FilterOptions().setHasText("Invalid login or password")).first();
        adviceRequiredEmail = getPage().locator("#advice-required-entry-email");
        adviceRequiredPassword = getPage().locator("#advice-required-entry-pass");
    }

    @Step("Enter an email")
    public LoginForm setEmail(String email) {

        emailField.fill(email);
        return this;
    }

    @Step("Enter a password")
    public LoginForm setPassword(String password) {

        passwordField.fill(password);
        return this;
    }

    @Step("Click the \"Login\" button")
    public void clickLoginButton() {

        loginButton.click();
    }

    public String getEmailFieldText() {

        return emailField.inputValue();
    }

    public String getPasswordFieldText() {

        return passwordField.inputValue();
    }

    public Locator getAdviceRequiredEmailLocator() {

        return adviceRequiredEmail;
    }

    public Locator getAdviceRequiredPasswordLocator() {

        return adviceRequiredPassword;
    }

    public Locator getInvalidLoginOrPasswordMessageLocator() {

        return invalidLoginOrPasswordMessage;
    }

    public String getValidationMessage() {

        ElementHandle elementHandle = emailField.elementHandle();

        Object object = elementHandle.evaluate("e=>e.validationMessage");

        return object.toString();
    }
}
