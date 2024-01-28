package tests;

import qa.dataProviders.DataProviders;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.extentreportsmanager.ExtentReportsManager;
import qa.localtestdata.LocalTestdata;
import qa.pageobject.components.AccountDropdownList;
import qa.base.BaseTest;
import qa.records.LinkData;


public class AccountDropdownListTest extends BaseTest {

    private AccountDropdownList accountDropdownList;

    @BeforeMethod
    public void create() {

        accountDropdownList = new AccountDropdownList(getPage());
    }

    @Test(dataProvider = LocalTestdata.ACCOUNT_DROPDOWN_LIST, dataProviderClass = DataProviders.class)
    void clickingButton(LinkData linkData) {

        accountDropdownList.clickAccountNav();
        accountDropdownList.clickItem(linkData.getLink());

        Assert.assertEquals(getPage().url(), linkData.getUrl(),
                "The page with address \"" + linkData.getUrl() + "\" has not been opened");
    }
}
