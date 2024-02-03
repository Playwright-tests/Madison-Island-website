package tests;

import qa.dataProviders.AccountDropdownListDataProviders;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.support.dataprovidernames.DataProviderNames;
import qa.pageobject.header.AccountDropdownList;
import qa.base.BaseTest;
import qa.records.LinkData;

public class AccountDropdownListTest extends BaseTest {

    private AccountDropdownList accountDropdownList;

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
