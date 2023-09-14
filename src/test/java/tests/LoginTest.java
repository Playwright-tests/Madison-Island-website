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
import java.util.function.Consumer;

public class LoginTest extends BaseTest {

    private LoginForm loginForm;

    @BeforeClass
    public void init() {

        AccountDropdownList accountDropdownList = new AccountDropdownList(getPage());
        loginForm = new LoginForm(getPage());

        accountDropdownList.clickAccountNav();
        accountDropdownList.clickItem("My Account");
    }

    private void setData(String email, String password, Consumer<LoginForm> consumer) {

        loginForm.setEmail(email);
        loginForm.setPassword(password);
        loginForm.clickLoginButton();

        consumer.accept(loginForm);
    }

    @Test(dataProvider = "incorrectEmail", dataProviderClass = Provider.class)
    public void incorrectEmail(List<Pair<String, String>> data) {

    }

    @Test(dataProvider = "emptyEmailField", dataProviderClass = Provider.class)
    public void emptyEmailField(List<Pair<String, String>> data) {

        setData(data.get(0).getFirst(), data.get(0).getSecond(), (LoginForm lf)->{Assert.assertTrue(lf.isRequiredEmailMessageVisible());});
    }

    @Test(dataProvider = "incorrectPassword", dataProviderClass = Provider.class)
    public void incorrectPassword(List<Pair<String, String>> data) {

        setData(data.get(0).getFirst(), data.get(0).getSecond(), (LoginForm lf)->{Assert.assertTrue(lf.isInvalidLoginOrPasswordMessageVisible());});
    }

    @Test(dataProvider = "emptyPasswordField", dataProviderClass = Provider.class)
    public void emptyPasswordField(List<Pair<String, String>> data) {

        setData(data.get(0).getFirst(), data.get(0).getSecond(), (LoginForm lf)->{Assert.assertTrue(lf.isRequiredPasswordMessageVisible());});
    }
}
