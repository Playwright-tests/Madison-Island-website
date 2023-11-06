package tests;

import qa.dataProvider.Provider;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.extentreportsmanager.ExtentReportsManager;
import qa.pageobject.components.AccountDropdownList;
import qa.pageobject.components.LoginForm;
import qa.playwright.PlaywrightLauncher;
import qa.base.BaseTest;
import qa.utils.Pair;
import java.util.List;

public class LoginTest extends BaseTest {

    private static LoginForm loginForm;

    @BeforeMethod
    public void create() {

        AccountDropdownList accountDropdownList = new AccountDropdownList(PlaywrightLauncher.getPage());
        loginForm = new LoginForm(PlaywrightLauncher.getPage());

        accountDropdownList.clickAccountNav();
        accountDropdownList.clickItem("My Account");
    }

    private void setData(String email, String password) {

        loginForm.setEmail(email);
        loginForm.setPassword(password);
        loginForm.clickLoginButton();
    }

    @Test(dataProvider = "incorrectEmail", dataProviderClass = Provider.class)
    public void incorrectEmail(List<Pair<String, String>> data) {

    }

    @Test(dataProvider = "emptyEmailField", dataProviderClass = Provider.class)
    public void emptyEmailField(Pair<String, String> data) {

        ExtentReportsManager.createTest("Empty email field",
                "Checking whether a message about an empty email field is displayed");

        setData(data.getFirst(), data.getSecond());
        Assert.assertTrue(loginForm.isRequiredEmailMessageVisible());
    }

    @Test(dataProvider = "incorrectPassword", dataProviderClass = Provider.class)
    public void incorrectPassword(Pair<String, String> data) {

        ExtentReportsManager.createTest("Logging in using \"" + data.getSecond() + "\" as incorrect password",
                "Checking whether a message about an incorrect password field is displayed");

        setData(data.getFirst(), data.getSecond());
        Assert.assertTrue(loginForm.isInvalidLoginOrPasswordMessageVisible());
    }

    @Test(dataProvider = "emptyPasswordField", dataProviderClass = Provider.class)
    public void emptyPasswordField(Pair<String, String> data) {

        ExtentReportsManager.createTest("Empty password field",
                "Checking whether a message about an empty password field is displayed");

        setData(data.getFirst(), data.getSecond());
        Assert.assertTrue(loginForm.isRequiredPasswordMessageVisible());
    }
}
