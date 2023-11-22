package tests.account;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.dataProvider.Provider;
import qa.helpers.LoginHelper;
import qa.pageobject.accountpage.AccountPage;
import qa.utils.LinkData;

public class SideMenuTest extends BaseTest {

    private AccountPage accountPage;

    @BeforeMethod
    public void create() {

        LoginHelper.login(getPage());

        accountPage = new AccountPage(getPage());
    }

    @Test(dataProvider = "sideMenu", dataProviderClass = Provider.class)
    public void links(LinkData linkData) {

        accountPage.getSideMenu().clickLink(linkData.getLink());

        Assert.assertEquals(getPage().url(), linkData.getUrl());
    }
}
