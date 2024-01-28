package tests;

import qa.dataProviders.DataProviders;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.enums.URLs;
import qa.pageobject.accountpage.Dashboard;
import qa.pageobject.components.LoginForm;
import qa.base.BaseTest;
import qa.records.Credentials;


public class LoginTest extends BaseTest {

    private static LoginForm loginForm;

    @BeforeMethod
    public void create() {

        goToPage(URLs.LOGIN_PAGE.getName());
        loginForm = new LoginForm(getPage());
    }

    private void setData(Credentials credentials) {

        loginForm.setEmail(credentials.getEmail());
        loginForm.setPassword(credentials.getPassword());
        loginForm.clickLoginButton();
    }

    @Test(dataProvider = "credentialsValidationEmailField", dataProviderClass = DataProviders.class)
    public void validationEmailField(Credentials credentials) {

        setData(credentials);

        Assert.assertNotEquals(loginForm.getValidationMessage(), "",
                "No validation message");
    }

    @Test(dataProvider = "emptyEmailField", dataProviderClass = DataProviders.class)
    public void emptyEmailField(Credentials credentials) {

        setData(credentials);

        Assert.assertTrue(loginForm.getAdviceRequiredEmailLocator().isVisible(),
                "The message about blank \"Email Address\" has not been displayed");
    }

    @Test(dataProvider = "CR_correct", dataProviderClass = DataProviders.class)
    public void correctCredentials(Credentials credentials) {

        setData(credentials);
        Dashboard dashboard = new Dashboard(getPage());

        Assert.assertEquals(dashboard.getTitle(), "My Dashboard",
                "An user has not been logged in");
    }

    @Test(dataProvider = "incorrectPassword", dataProviderClass = DataProviders.class)
    public void incorrectPassword(Credentials credentials) {

        setData(credentials);

        Assert.assertTrue(loginForm.getInvalidLoginOrPasswordMessageLocator().isVisible(),
                "The message about an incorrect password has not been displayed");
    }

    @Test(dataProvider = "emptyPasswordField", dataProviderClass = DataProviders.class)
    public void blankPasswordField(Credentials credentials) {

        setData(credentials);

        Assert.assertTrue(loginForm.getAdviceRequiredPasswordLocator().isVisible(),
                "The message about blank \"Password\" has not been displayed");
    }
}
