package tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.components.AccountDropdownList;
import pages.components.LoginForm;
import qa.base.BaseTest;

public class LoginTest extends BaseTest {

    private static LoginForm loginForm;

    @BeforeAll
    public static void init() {

        AccountDropdownList accountDropdownList = new AccountDropdownList(getPage());
        loginForm = new LoginForm(getPage());

        accountDropdownList.clickAccountNav();
        accountDropdownList.clickElementList(5);
    }

    @Test
    public void incorrectEmail() {

        loginForm.setEmail("myEmail");
        loginForm.setPassword("myPassword");
    }

    @Test
    public void emptyEmailField() {


    }

    @Test
    public void incorrectPassword() {


    }

    @Test
    public void emptyPasswordField() {


    }
}
