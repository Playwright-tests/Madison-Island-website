package pageobject.components;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
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

    public void setEmail(String email) {

        emailField.fill(email);
    }

    public void setPassword(String password) {

        passwordField.fill(password);
    }

    public void clickLoginButton() {

        loginButton.click();
    }

    public boolean isRequiredEmailMessageVisible() {

        return adviceRequiredEmail.isVisible();
    }

    public boolean isRequiredPasswordMessageVisible() {

        return adviceRequiredPassword.isVisible();
    }

    public boolean isInvalidLoginOrPasswordMessageVisible() {

        return invalidLoginOrPasswordMessage.isVisible();
    }
}
