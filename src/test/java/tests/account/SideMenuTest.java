package tests.account;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.dataProvider.Provider;
import qa.enums.URLs;
import qa.extentreportsmanager.ExtentReportsManager;
import qa.helpers.LoginActions;
import qa.pageobject.accountpage.AccountPage;
import qa.records.LinkData;

public class SideMenuTest extends BaseTest {

    private AccountPage accountPage;

    @BeforeMethod
    public void create() {

        goToPage(URLs.LOGIN_PAGE.getName());
        LoginActions.login(getPage());

        accountPage = new AccountPage(getPage());
    }

    @Test(dataProvider = "sideMenu", dataProviderClass = Provider.class)
    public void links(LinkData linkData) {

        ExtentReportsManager.createTest("Clicking the \"" + linkData.link() + "\" button",
                "Checking whether the page with the address \"" + linkData.url() +  "\" opens after clicking the \"" + linkData.link() + "\" button.");

        accountPage.getSideMenu().clickLink(linkData.link());

        Assert.assertEquals(getPage().url(), linkData.url(),
                "The page with address \"" + linkData.url() + "\" has not been opened");
    }
}
