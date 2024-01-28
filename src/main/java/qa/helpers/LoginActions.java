package qa.helpers;

import com.microsoft.playwright.Page;
import qa.dataProviders.DataProviders;
import qa.pageobject.components.LoginForm;
import qa.records.Credentials;

import java.io.IOException;

public class LoginActions {

    public static void login(Page page) throws IOException {

        DataProviders dataProviders = new DataProviders();
        Credentials[] credentials = (Credentials[]) dataProviders.CR_correct();

        LoginForm loginForm = new LoginForm(page);
        loginForm.setEmail(credentials[0].getEmail());
        loginForm.setPassword(credentials[0].getPassword());
        loginForm.clickLoginButton();
    }
}
