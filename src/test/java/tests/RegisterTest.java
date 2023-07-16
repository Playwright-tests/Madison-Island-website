package tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.components.AccountDropdownList;
import pages.components.RegisterForm;
import qa.base.BaseTest;
import utils.User;

public class RegisterTest extends BaseTest {

    private static RegisterForm registerForm;

    @BeforeAll
    public static void init() {

        AccountDropdownList accountDropdownList = new AccountDropdownList(getPage());
        registerForm = new RegisterForm(getPage());

        accountDropdownList.clickAccountNav();
        accountDropdownList.clickElementList(4);
    }

    @Test
    public void incorrectFirstName() {

        User user = new User("@#$", "", "Aksman", "af@gmail.com", "asdf$", "asdf$");

        registerForm.clearAll();
        registerForm.setData(user);
    }

    @Test
    public void incorrectMiddleName() {


    }

    @Test
    public void incorrectLastName() {


    }

    @Test
    public void incorrectEmail() {


    }

    @Test
    public void incorrectConfirmedPassword() {


    }
}
