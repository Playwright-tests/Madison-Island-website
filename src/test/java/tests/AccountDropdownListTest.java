package tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import qa.dataProviders.AccountDropdownListDataProviders;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.enums.DataDownloadMode;
import qa.exceptions.MockarooRequestException;
import qa.support.dataprovidernames.DataProviderNames;
import qa.pageobject.components.AccountDropdownList;
import qa.base.BaseTest;
import qa.records.LinkData;
import qa.support.testdatafilenames.TestdataFileNames;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;


public class AccountDropdownListTest extends BaseTest {

    private AccountDropdownList accountDropdownList;

    @BeforeSuite
    public void loadTestdata() throws MalformedURLException, FileNotFoundException, URISyntaxException, MockarooRequestException {

        AccountDropdownListDataProviders.loadTestdata(TestdataFileNames.LINKS, DataDownloadMode.LOCAL);
    }

    @AfterSuite
    public void clearTestdata() {

        AccountDropdownListDataProviders.clear();
    }

    @BeforeMethod
    public void create() {

        accountDropdownList = new AccountDropdownList(getPage());
    }

    @Test(dataProvider = DataProviderNames.ACCOUNT_DROPDOWN_LIST, dataProviderClass = AccountDropdownListDataProviders.class)
    void clickingButton(LinkData linkData) {

        accountDropdownList.clickAccountNav();
        accountDropdownList.clickItem(linkData.getLink());

        Assert.assertEquals(getPage().url(), linkData.getUrl(),
                "The page with address \"" + linkData.getUrl() + "\" has not been opened");
    }
}
