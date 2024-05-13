package qa.support;

import com.microsoft.playwright.Page;
import qa.pageobject.loginform.LoginForm;

public class Authentication {

    public static void login(Page page) {

        String email = "goo@gmail.com";
        String password = "pawelek1234";

        LoginForm loginForm = new LoginForm(page);
        loginForm.setEmail(email);
        loginForm.setPassword(password);
        loginForm.clickLoginButton();
    }
}
