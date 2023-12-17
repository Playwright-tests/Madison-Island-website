package qa.helpers;

import com.microsoft.playwright.Page;
import qa.dataProvider.Provider;
import qa.pageobject.components.LoginForm;
import qa.records.Credentials;

public class LoginActions {

    public static void login(Page page) {

        Provider provider = new Provider();
        Credentials[] credentials = (Credentials[]) provider.CR_correct();

        LoginForm loginForm = new LoginForm(page);
        loginForm.setEmail(credentials[0].email());
        loginForm.setPassword(credentials[0].password());
        loginForm.clickLoginButton();
    }
}
