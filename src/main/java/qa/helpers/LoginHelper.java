package qa.helpers;

import com.microsoft.playwright.Page;
import qa.pageobject.components.AccountDropdownList;
import qa.pageobject.components.LoginForm;

public class LoginHelper {

    public static void login(Page page) {

        AccountDropdownList accountDropdownList = new AccountDropdownList(page);
        accountDropdownList.clickAccountNav();
        accountDropdownList.clickItem("My Account");

        LoginForm loginForm = new LoginForm(page);
        loginForm.setEmail("marko@gmail.com");
        loginForm.setPassword("Multiple1234");
        loginForm.clickLoginButton();
    }
}
