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

        ExtentReportsManager.createTest("Clicking the \"" + linkData.getLink() + "\" button",
                "Checking whether the page with the address \"" + linkData.getUrl() +  "\" opens after clicking the \"" + linkData.getLink() + "\" button.");

        accountDropdownList.clickAccountNav();
        accountDropdownList.clickItem(linkData.getLink());

        Assert.assertEquals(getPage().url(), linkData.getUrl(),
                "The page with address \"" + linkData.getUrl() + "\" has not been opened");
    }
}
