package tests;

import dataProvider.Provider;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.components.AccountDropdownList;
import qa.base.BaseTest;
import utils.Pair;

import static playwright.PlaywrightLauncher.*;

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
