package tests.login;

import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
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

@Epic("E2E")
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

    @Test(priority = 1, dataProvider = DataProviderNames.INCORRECT_EMAIL_FORMAT, dataProviderClass = CredentialsDataProviders.class)
    @Owner("Paweł Aksman")
    @Tag("Login form")
    @Tag("Login")
    @Link(name = "Login page", url = URLs.LOGIN_PAGE)
    @Severity(SeverityLevel.NORMAL)
    @Description("Attempting to log in using an incorrect email format")
    public void incorrectEmailFormat(Credentials credentials) {

        Allure.parameter("Email", credentials.getEmail());
        Allure.parameter("Password", credentials.getPassword());
        actions(credentials);

        Assert.assertNotEquals(loginForm.getValidationMessage(), "",
                "No validation message");
    }

    @Test(priority = 2, dataProvider = DataProviderNames.BLANK_EMAIL_FIELD, dataProviderClass = CredentialsDataProviders.class)
    @Owner("Paweł Aksman")
    @Tag("Login form")
    @Tag("Login")
    @Link(name = "Login page", url = URLs.LOGIN_PAGE)
    @Severity(SeverityLevel.MINOR)
    @Description("Attempting to log in without providing input for the \"Email Address\" field")
    public void blankEmailField(Credentials credentials) {

        Allure.parameter("Password", credentials.getPassword());
        actions(credentials);

        Assert.assertTrue(loginForm.getAdviceRequiredEmailLocator().isVisible(),
                "The message about blank \"Email Address\" has not been displayed");
    }

    @Test(priority = 5, dataProvider = DataProviderNames.CORRECT, dataProviderClass = CredentialsDataProviders.class)
    @Owner("Paweł Aksman")
    @Tag("Login form")
    @Tag("Login")
    @Link(name = "Login page", url = URLs.LOGIN_PAGE)
    @Severity(SeverityLevel.BLOCKER)
    @Description("Logging in using correct credentials")
    public void correct(Credentials credentials) {

        Allure.parameter("Email", credentials.getEmail());
        Allure.parameter("Password", credentials.getPassword());
        actions(credentials);
        Dashboard dashboard = new Dashboard(getPage());

        Assert.assertEquals(dashboard.getTitle(), "My Dashboard",
                "An user has not been logged in");
    }

    @Test(priority = 3, dataProvider = DataProviderNames.INCORRECT_PASSWORD, dataProviderClass = CredentialsDataProviders.class)
    @Owner("Paweł Aksman")
    @Tag("Login form")
    @Tag("Login")
    @Link(name = "Login page", url = URLs.LOGIN_PAGE)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Attempting to log in using an incorrect password")
    public void incorrectPassword(Credentials credentials) {

        Allure.parameter("Email", credentials.getEmail());
        Allure.parameter("Password", credentials.getPassword());
        actions(credentials);

        Assert.assertTrue(loginForm.getInvalidLoginOrPasswordMessageLocator().isVisible(),
                "The message about an incorrect password has not been displayed");
    }

    @Test(priority = 4, dataProvider = DataProviderNames.BLANK_PASSWORD_FIELD, dataProviderClass = CredentialsDataProviders.class)
    @Owner("Paweł Aksman")
    @Tag("Login form")
    @Tag("Login")
    @Link(name = "Login page", url = URLs.LOGIN_PAGE)
    @Severity(SeverityLevel.MINOR)
    @Description("Attempting to log in without providing input for the \"Password\" field")
    public void blankPasswordField(Credentials credentials) {

        Allure.parameter("Email", credentials.getEmail());
        Allure.parameter("Password", credentials.getPassword());
        actions(credentials);

        Assert.assertTrue(loginForm.getAdviceRequiredPasswordLocator().isVisible(),
                "The message about blank \"Password\" has not been displayed");
    }
}
