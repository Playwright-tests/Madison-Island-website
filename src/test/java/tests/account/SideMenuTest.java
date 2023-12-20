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

        ExtentReportsManager.createTest("Clicking the \"" + linkData.getLink() + "\" button",
                "Checking whether the page with the address \"" + linkData.getUrl() +  "\" opens after clicking the \"" + linkData.getLink() + "\" button.");

        accountPage.getSideMenu().clickLink(linkData.getLink());

        Assert.assertEquals(getPage().url(), linkData.getUrl(),
                "The page with address \"" + linkData.getUrl() + "\" has not been opened");
    }
}
