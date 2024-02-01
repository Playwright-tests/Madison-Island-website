package tests.account;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.dataProviders.SideMenuDataProviders;
import qa.enums.URLs;
import qa.exceptions.MockarooRequestException;
import qa.helpers.LoginActions;
import qa.pageobject.accountpage.AccountPage;
import qa.records.LinkData;
import qa.support.dataprovidernames.DataProviderNames;

import java.io.IOException;
import java.net.URISyntaxException;

public class SideMenuTest extends BaseTest {

    private AccountPage accountPage;

    @BeforeMethod
    public void create() throws IOException, URISyntaxException, MockarooRequestException {

        goToPage(URLs.LOGIN_PAGE.getName());
        LoginActions.login(getPage());

        accountPage = new AccountPage(getPage());
    }

    @Test(dataProvider = DataProviderNames.SIDE_MENU, dataProviderClass = SideMenuDataProviders.class)
    public void links(LinkData linkData) {

        accountPage.getSideMenu().clickLink(linkData.getLink());

        Assert.assertEquals(getPage().url(), linkData.getUrl(),
                "The page with address \"" + linkData.getUrl() + "\" has not been opened");
    }
}
