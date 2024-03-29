package tests.login;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.enums.URLs;
import qa.pageobject.loginform.LoginForm;

public class InputTextValidationTest extends BaseTest {

    private LoginForm loginForm;

    @BeforeMethod
    public void create() {

        goToPage(URLs.LOGIN_PAGE.getName());
        loginForm = new LoginForm(getPage());
    }

    @Test
    public void emailField() {

        String email = "example@gmail.com";
        loginForm.setEmail(email);

        Assert.assertEquals(loginForm.getEmailFieldText(), email,
                "Incorrect input content");
    }

    @Test
    public void passwordField() {

        String password = "password";
        loginForm.setPassword(password);

        Assert.assertEquals(loginForm.getPasswordFieldText(), password,
                "Incorrect input content");
    }
}
