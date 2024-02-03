package qa.helpers;

import com.microsoft.playwright.Page;
import qa.exceptions.MockarooRequestException;
import qa.pageobject.loginform.LoginForm;

import java.io.IOException;
import java.net.URISyntaxException;

public class LoginActions {

    public static void login(Page page) throws IOException, URISyntaxException, MockarooRequestException {

        String email = "goo@gmail.com";
        String password = "pawelek1234";

        LoginForm loginForm = new LoginForm(page);
        loginForm.setEmail(email);
        loginForm.setPassword(password);
        loginForm.clickLoginButton();
    }
}
