package qa.helpers;

import com.microsoft.playwright.Page;
import qa.dataProviders.CredentialsDataProviders;
import qa.enums.DataDownloadMode;
import qa.exceptions.MockarooRequestException;
import qa.pageobject.components.LoginForm;
import qa.records.Credentials;
import qa.support.testdatafilenames.TestdataFileNames;

import java.io.IOException;
import java.net.URISyntaxException;

public class LoginActions {

    public static void login(Page page) throws IOException, URISyntaxException, MockarooRequestException {

        CredentialsDataProviders.loadTestdata(TestdataFileNames.CREDENTIALS, DataDownloadMode.LOCAL);
        CredentialsDataProviders dataProviders = new CredentialsDataProviders();
        Credentials[] credentials = (Credentials[]) dataProviders.correct();

        LoginForm loginForm = new LoginForm(page);
        loginForm.setEmail(credentials[0].getEmail());
        loginForm.setPassword(credentials[0].getPassword());
        loginForm.clickLoginButton();
    }
}
