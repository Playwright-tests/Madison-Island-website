package tests;

import dataProvider.Provider;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.components.AccountDropdownList;
import pages.components.LoginForm;
import qa.base.BaseTest;
import utils.Pair;

import java.util.List;

public class LoginTest extends BaseTest {

    private static LoginForm loginForm;

    private final String expectedMessage = "This is a required field.";

    @BeforeClass
    public static void init() {

        AccountDropdownList accountDropdownList = new AccountDropdownList(getPage());
        loginForm = new LoginForm(getPage());

        accountDropdownList.clickAccountNav();
        accountDropdownList.clickElementList(5);
    }

    private void setData(String email, String password) {

        loginForm.setEmail(email);
        loginForm.setPassword(password);
        loginForm.clickLoginButton();
    }

    @Test(dataProvider = "incorrectEmail", dataProviderClass = Provider.class)
    public void incorrectEmail(List<Pair<String, String>> data) {

        setData(data.get(0).getFirst(), data.get(0).getSecond());
    }

    @Test(dataProvider = "emptyEmailField", dataProviderClass = Provider.class)
    public void emptyEmailField(List<Pair<String, String>> data) {

        setData(data.get(0).getFirst(), data.get(0).getSecond());

        Assert.assertEquals(loginForm.getRequiredEmailMessageText(), expectedMessage);
    }

    @Test(dataProvider = "incorrectPassword", dataProviderClass = Provider.class)
    public void incorrectPassword(List<Pair<String, String>> data) {

        setData(data.get(0).getFirst(), data.get(0).getSecond());
    }

    @Test(dataProvider = "emptyPasswordField", dataProviderClass = Provider.class)
    public void emptyPasswordField(List<Pair<String, String>> data) {

        setData(data.get(0).getFirst(), data.get(0).getSecond());

        Assert.assertEquals(loginForm.getRequiredPasswordMessageText(), expectedMessage);
    }
}
