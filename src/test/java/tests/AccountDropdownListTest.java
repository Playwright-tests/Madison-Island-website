package tests;

import qa.dataProvider.Provider;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.pageobject.components.AccountDropdownList;
import qa.base.BaseTest;
import qa.utils.Pair;

import static qa.playwright.PlaywrightLauncher.*;

public class AccountDropdownListTest extends BaseTest {

    private AccountDropdownList accountDropdownList;

    @BeforeMethod
    public void create() {

        accountDropdownList = new AccountDropdownList(getPage());
    }

    @Test(dataProvider = "accountDropdownList", dataProviderClass = Provider.class)
    void link(Pair<String, String> data) {

        accountDropdownList.clickAccountNav();
        accountDropdownList.clickItem(data.getFirst());

        Assert.assertEquals(getPage().url(), data.getSecond());
    }
}
