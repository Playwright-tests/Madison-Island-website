package pages.components;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import qa.base.BasePage;

public class LoginForm extends BasePage {

    private final Locator emailField;
    private final Locator passwordField;
    private final Locator loginButton;
    public LoginForm(Page page) {

        super(page);

        emailField = getPage().locator("#email");
        passwordField = getPage().locator("#pass");
        loginButton = getPage().getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login"));
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
}
