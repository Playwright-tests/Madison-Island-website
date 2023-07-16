package pages.components;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import qa.base.BasePage;
import utils.User;

public class RegisterForm extends BasePage {

    private final Locator checkbox;
    private final Locator registerButton;

    public RegisterForm(Page page) {

        super(page);

        checkbox = getPage().getByRole(AriaRole.CHECKBOX, new Page.GetByRoleOptions().setName("Sign Up for Newsletter"));
        registerButton = getPage().getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Register"));
    }

    public void clearAll() {

        getPage().getByLabel("First Name").clear();
        getPage().getByLabel("Middle Name").clear();
        getPage().getByLabel("Last Name").clear();
        getPage().getByLabel("Email Address").clear();
        getPage().getByLabel("*Password", new Page.GetByLabelOptions().setExact(true)).clear();
        getPage().getByLabel("*Confirm Password", new Page.GetByLabelOptions().setExact(true)).clear();
    }

    public void setData(User user) {

        getPage().getByLabel("First Name").fill(user.getFirstName());
        getPage().getByLabel("Middle Name").fill(user.getMiddleName());
        getPage().getByLabel("Last Name").fill(user.getLastName());
        getPage().getByLabel("Email Address").fill(user.getEmailAddress());
        getPage().getByLabel("*Password", new Page.GetByLabelOptions().setExact(true)).fill(user.getPassword());
        getPage().getByLabel("*Confirm Password", new Page.GetByLabelOptions().setExact(true)).fill(user.getConfirmedPassword());
    }

    public void setCheckboxCheck() {

        checkbox.check();
    }

    public void setCheckboxUncheck() {

        checkbox.uncheck();
    }

    public void clickRegisterButton() {

        registerButton.click();
    }
}
