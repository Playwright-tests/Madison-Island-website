package tests;

import qa.dataProvider.Provider;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.enums.URLs;
import qa.extentreportsmanager.ExtentReportsManager;
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

    @Test(dataProvider = "credentialsValidationEmailField", dataProviderClass = Provider.class)
    public void validationEmailField(Credentials credentials) {

        ExtentReportsManager.createTest("\"" + credentials.getEmail() + "\" as an incorrect email",
                "Checking whether a message about incorrect email format is displayed");

        setData(credentials);

        Assert.assertNotEquals(loginForm.getValidationMessage(), "",
                "No validation message");
        Assert.assertEquals(loginForm.getValidationMessage(), credentials.getMessage(),
                "Incorrect message content");
    }

    @Test(dataProvider = "emptyEmailField", dataProviderClass = Provider.class)
    public void emptyEmailField(Credentials credentials) {

        ExtentReportsManager.createTest("Blank \"Email Address\" field",
                "Checking whether a message about an empty \"Email Address\" field is displayed");

        setData(credentials);

        Assert.assertTrue(loginForm.getAdviceRequiredEmailLocator().isVisible(),
                "The message about blank \"Email Address\" has not been displayed");
    }

    @Test(dataProvider = "CR_correct", dataProviderClass = Provider.class)
    public void correctCredentials(Credentials credentials) {

        ExtentReportsManager.createTest("Logging in using \"" + credentials.getPassword() + "\" as incorrect password",
                "Verifying that the user is logged in after logging in with the correct credentials");

        setData(credentials);
        Dashboard dashboard = new Dashboard(getPage());

        Assert.assertEquals(dashboard.getTitle(), credentials.getMessage(),
                "An user has not been logged in");
    }

    @Test(dataProvider = "incorrectPassword", dataProviderClass = Provider.class)
    public void incorrectPassword(Credentials credentials) {

        ExtentReportsManager.createTest("Logging in using \"" + credentials.getPassword() + "\" as incorrect password",
                "Checking whether a message about an incorrect password is displayed");

        setData(credentials);

        Assert.assertTrue(loginForm.getInvalidLoginOrPasswordMessageLocator().isVisible(),
                "The message about an incorrect password has not been displayed");
    }

    @Test(dataProvider = "emptyPasswordField", dataProviderClass = Provider.class)
    public void blankPasswordField(Credentials credentials) {

        ExtentReportsManager.createTest("Blank \"Password\" field",
                "Checking whether a message about an empty \"Password\" field is displayed");

        setData(credentials);

        Assert.assertTrue(loginForm.getAdviceRequiredPasswordLocator().isVisible(),
                "The message about blank \"Password\" has not been displayed");
    }
}
