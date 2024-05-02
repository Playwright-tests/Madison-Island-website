package tests.header.accountdropdownlist;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.pageobject.header.AccountDropdownList;
import tests.base.BaseTest;


public class ExpandingAndCollapsingTest extends BaseTest {

    private AccountDropdownList accountDropdownList;

    @BeforeMethod(onlyForGroups = "withoutExpandedList")
    public void prepareWithoutExpandedList() {

        accountDropdownList = new AccountDropdownList(getPage());
    }

    @BeforeMethod(onlyForGroups = "withExpandedList")
    public void prepareWithExpandedList() {

        accountDropdownList = new AccountDropdownList(getPage());
        accountDropdownList.clickTriggerElement();
    }

    private void actions(WaitForSelectorState selectorState, String expectedState) {

        accountDropdownList.clickTriggerElement();

        try {
            getPage().waitForSelector(accountDropdownList.getListSelector(), new Page.WaitForSelectorOptions().setTimeout(2000)
                    .setState(selectorState));
        } catch (Exception e) {
            Assert.fail("The account dropdown list has not been " + expectedState);
        }
    }

    @Test(groups = "withoutExpandedList")
    public void expandingList() {

        actions(WaitForSelectorState.VISIBLE, "expanded");
    }

    @Test(groups = "withExpandedList")
    public void collapsingList() {

        actions(WaitForSelectorState.HIDDEN, "collapsed");
    }
}
