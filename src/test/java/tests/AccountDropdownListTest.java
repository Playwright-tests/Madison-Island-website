package tests;

import qa.dataProvider.Provider;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.extentreportsmanager.ExtentReportsManager;
import qa.pageobject.components.AccountDropdownList;
import qa.base.BaseTest;
import qa.utils.Pair;

public class AccountDropdownListTest extends BaseTest {

    private AccountDropdownList accountDropdownList;

    @BeforeMethod
    public void create() {

        accountDropdownList = new AccountDropdownList(getPage());
    }

    @Test(dataProvider = "accountDropdownList", dataProviderClass = Provider.class)
    void clickingButton(Pair<String, String> data) {

        ExtentReportsManager.createTest("Clicking the \"" + data.getFirst() + "\" button",
                "Checking whether the page with the address \"" + data.getSecond() +  "\" opens after clicking the \"" + data.getFirst() + "\" button.");

        accountDropdownList.clickAccountNav();
        accountDropdownList.clickItem(data.getFirst());

        Assert.assertEquals(getPage().url(), data.getSecond(),
                "The page with address \"" + data.getSecond() + "\" has not been opened");
    }
}
