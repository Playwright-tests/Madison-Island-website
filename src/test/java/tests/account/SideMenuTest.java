package tests.account;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.dataProviders.DataProviders;
import qa.dataProviders.SideMenuDataProviders;
import qa.enums.DataDownloadMode;
import qa.enums.URLs;
import qa.exceptions.MockarooRequestException;
import qa.helpers.LoginActions;
import qa.pageobject.accountpage.AccountPage;
import qa.records.LinkData;
import qa.support.dataprovidernames.DataProviderNames;
import qa.support.testdatafilenames.TestdataFileNames;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class SideMenuTest extends BaseTest {

    private AccountPage accountPage;

    @BeforeSuite
    public void loadTestdata() throws MalformedURLException, FileNotFoundException, URISyntaxException, MockarooRequestException {

        SideMenuDataProviders.loadTestdata(TestdataFileNames.LINKS, DataDownloadMode.LOCAL);
    }

    @AfterSuite
    public void clearTestdata() {

        SideMenuDataProviders.clear();
    }

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
