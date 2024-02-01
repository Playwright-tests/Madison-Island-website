package qa.helpers;

import com.microsoft.playwright.Page;
import qa.exceptions.MockarooRequestException;
import qa.pageobject.components.LoginForm;

import java.io.IOException;
import java.net.URISyntaxException;

public class LoginActions {

    public static void login(Page page) throws IOException, URISyntaxException, MockarooRequestException {

        String email = "email";
        String password = "password";

        LoginForm loginForm = new LoginForm(page);
        loginForm.setEmail(email);
        loginForm.setPassword(password);
        loginForm.clickLoginButton();
    }
}
