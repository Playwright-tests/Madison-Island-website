package tests;

import qa.dataProvider.Provider;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.extentreportsmanager.ExtentReportsManager;
import qa.pageobject.components.AccountDropdownList;
import qa.pageobject.components.LoginForm;
import qa.base.BaseTest;
import qa.utils.Credentials;
import qa.utils.NewsletterData;

public class LoginTest extends BaseTest {

    private static LoginForm loginForm;

    @BeforeMethod
    public void create() {

        AccountDropdownList accountDropdownList = new AccountDropdownList(getPage());
        loginForm = new LoginForm(getPage());

        accountDropdownList.clickAccountNav();
        accountDropdownList.clickItem("My Account");
    }

    private void setData(Credentials credentials) {

        loginForm.setEmail(credentials.getEmail());
        loginForm.setPassword(credentials.getPassword());
        loginForm.clickLoginButton();
    }

    @Test(dataProvider = "validationEmailField", dataProviderClass = Provider.class)
    public void validationEmailField(NewsletterData newsletterData) {

        ExtentReportsManager.createTest("\"" + newsletterData.getEmail() + "\" as an incorrect email",
                "Checking whether a message about incorrect email format is displayed");

        setData(new Credentials(newsletterData));

        Assert.assertNotEquals(loginForm.getValidationMessage(), "",
                "No validation message");

        Assert.assertEquals(loginForm.getValidationMessage(), newsletterData.getValidationMessage(),
                "Incorrect message content");
    }

    @Test(dataProvider = "emptyEmailField", dataProviderClass = Provider.class)
    public void emptyEmailField(Credentials credentials) {

        ExtentReportsManager.createTest("Blank \"Email Address\" field",
                "Checking whether a message about an empty \"Email Address\" field is displayed");

        setData(credentials);
        Assert.assertTrue(loginForm.isRequiredEmailMessageVisible(),
                "The message about blank \"Email Address\" has not been displayed");
    }

    @Test(dataProvider = "incorrectPassword", dataProviderClass = Provider.class)
    public void incorrectPassword(Credentials credentials) {

        ExtentReportsManager.createTest("Logging in using \"" + credentials.getPassword() + "\" as incorrect password",
                "Checking whether a message about an incorrect password is displayed");

        setData(credentials);
        Assert.assertTrue(loginForm.isInvalidLoginOrPasswordMessageVisible(),
                "The message about an incorrect password has not been displayed");
    }

    @Test(dataProvider = "emptyPasswordField", dataProviderClass = Provider.class)
    public void blankPasswordField(Credentials credentials) {

        ExtentReportsManager.createTest("Blank \"Password\" field",
                "Checking whether a message about an empty \"Password\" field is displayed");

        setData(credentials);
        Assert.assertTrue(loginForm.isRequiredPasswordMessageVisible(),
                "The message about blank \"Password\" has not been displayed");
    }
}
