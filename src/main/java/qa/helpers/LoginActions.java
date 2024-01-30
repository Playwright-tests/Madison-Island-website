package qa.helpers;

import com.microsoft.playwright.Page;
import qa.dataProviders.CredentialsDataProviders;
import qa.pageobject.components.LoginForm;
import qa.records.Credentials;

import java.io.IOException;

public class LoginActions {

    public static void login(Page page) throws IOException {

        CredentialsDataProviders dataProviders = new CredentialsDataProviders();
        Credentials[] credentials = (Credentials[]) dataProviders.correct();

        LoginForm loginForm = new LoginForm(page);
        loginForm.setEmail(credentials[0].getEmail());
        loginForm.setPassword(credentials[0].getPassword());
        loginForm.clickLoginButton();
    }
}
