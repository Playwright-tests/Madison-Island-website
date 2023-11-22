package tests;

import qa.dataProvider.Provider;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.extentreportsmanager.ExtentReportsManager;
import qa.pageobject.components.AccountDropdownList;
import qa.base.BaseTest;
import qa.records.LinkData;


public class AccountDropdownListTest extends BaseTest {

    private AccountDropdownList accountDropdownList;

    @BeforeMethod
    public void create() {

        accountDropdownList = new AccountDropdownList(getPage());
    }

    @Test(dataProvider = "accountDropdownList", dataProviderClass = Provider.class)
    void clickingButton(LinkData linkData) {

        ExtentReportsManager.createTest("Clicking the \"" + linkData.link() + "\" button",
                "Checking whether the page with the address \"" + linkData.url() +  "\" opens after clicking the \"" + linkData.link() + "\" button.");

        accountDropdownList.clickAccountNav();
        accountDropdownList.clickItem(linkData.link());

        Assert.assertEquals(getPage().url(), linkData.url(),
                "The page with address \"" + linkData.url() + "\" has not been opened");
    }
}
