package tests;

import dataProvider.Provider;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.components.AccountDropdownList;
import pages.components.LoginForm;
import playwright.PlaywrightLauncher;
import qa.base.BaseTest;
import utils.Pair;
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

        setData(data.getFirst(), data.getSecond());
        Assert.assertTrue(loginForm.isRequiredEmailMessageVisible());
    }

    @Test(dataProvider = "incorrectPassword", dataProviderClass = Provider.class)
    public void incorrectPassword(Pair<String, String> data) {

        setData(data.getFirst(), data.getSecond());
        Assert.assertTrue(loginForm.isInvalidLoginOrPasswordMessageVisible());
    }

    @Test(dataProvider = "emptyPasswordField", dataProviderClass = Provider.class)
    public void emptyPasswordField(Pair<String, String> data) {

        setData(data.getFirst(), data.getSecond());
        Assert.assertTrue(loginForm.isRequiredPasswordMessageVisible());
    }
}
