package tests.login;

import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.base.BaseTest;
import qa.support.URLs;
import qa.pageobject.loginform.LoginForm;

@Epic("E2E")
@Feature("Login form input fields verification")
public class InputTextValidationTest extends BaseTest {

    private LoginForm loginForm;

    @BeforeMethod
    public void prepare() {

        goToPage(URLs.LOGIN_PAGE);
        loginForm = new LoginForm(getPage());
    }

    @Test(priority = 1)
    @Owner("Paweł Aksman")
    @Tag("Login form")
    @Tag("Fields")
    @Tag("Inputs")
    @Link(name = "Login page", url = "http://demo-store.seleniumacademy.com/customer/account/login/")
    @Description("Verification of the \"Email address\" field text input")
    public void emailField() {

        String email = "example@gmail.com";
        Allure.parameter("Email", email);
        loginForm.setEmail(email);

        Assert.assertEquals(loginForm.getEmailFieldText(), email,
                "Incorrect input content");
    }

    @Test(priority = 2)
    @Owner("Paweł Aksman")
    @Tag("Login form")
    @Tag("Fields")
    @Tag("Inputs")
    @Link(name = "Login page", url = "http://demo-store.seleniumacademy.com/customer/account/login/")
    @Description("Verification of the \"Password\" field text input")
    public void passwordField() {

        String password = "password";
        Allure.parameter("Password", password);
        loginForm.setPassword(password);

        Assert.assertEquals(loginForm.getPasswordFieldText(), password,
                "Incorrect input content");
    }
}
