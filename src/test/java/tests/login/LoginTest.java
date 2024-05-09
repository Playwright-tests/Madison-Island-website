package tests.login;

import qa.dataProviders.CredentialsDataProviders;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.support.URLs;
import qa.pageobject.accountpage.Dashboard;
import qa.pageobject.loginform.LoginForm;
import tests.base.BaseTest;
import qa.models.Credentials;
import qa.support.DataProviderNames;

public class LoginTest extends BaseTest {

    private static LoginForm loginForm;

    @BeforeMethod
    public void prepare() {

        goToPage(URLs.LOGIN_PAGE);
        loginForm = new LoginForm(getPage());
    }

    private void actions(Credentials credentials) {

        loginForm
                .setEmail(credentials.getEmail())
                .setPassword(credentials.getPassword())
                .clickLoginButton();
    }

    @Test(dataProvider = DataProviderNames.INCORRECT_EMAIL_FORMAT, dataProviderClass = CredentialsDataProviders.class)
    public void incorrectEmailFormat(Credentials credentials) {

        actions(credentials);

        Assert.assertNotEquals(loginForm.getValidationMessage(), "",
                "No validation message");
    }

    @Test(dataProvider = DataProviderNames.BLANK_EMAIL_FIELD, dataProviderClass = CredentialsDataProviders.class)
    public void blankEmailField(Credentials credentials) {

        actions(credentials);

        Assert.assertTrue(loginForm.getAdviceRequiredEmailLocator().isVisible(),
                "The message about blank \"Email Address\" has not been displayed");
    }

    @Test(dataProvider = DataProviderNames.CORRECT, dataProviderClass = CredentialsDataProviders.class)
    public void correct(Credentials credentials) {

        actions(credentials);
        Dashboard dashboard = new Dashboard(getPage());

        Assert.assertEquals(dashboard.getTitle(), "My Dashboard",
                "An user has not been logged in");
    }

    @Test(dataProvider = DataProviderNames.INCORRECT_PASSWORD, dataProviderClass = CredentialsDataProviders.class)
    public void incorrectPassword(Credentials credentials) {

        actions(credentials);

        Assert.assertTrue(loginForm.getInvalidLoginOrPasswordMessageLocator().isVisible(),
                "The message about an incorrect password has not been displayed");
    }

    @Test(dataProvider = DataProviderNames.BLANK_PASSWORD_FIELD, dataProviderClass = CredentialsDataProviders.class)
    public void blankPasswordField(Credentials credentials) {

        actions(credentials);

        Assert.assertTrue(loginForm.getAdviceRequiredPasswordLocator().isVisible(),
                "The message about blank \"Password\" has not been displayed");
    }
}
